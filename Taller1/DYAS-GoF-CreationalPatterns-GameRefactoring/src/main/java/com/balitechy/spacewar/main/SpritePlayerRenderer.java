package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpritePlayerRenderer implements IPlayerRenderer {
    
    private Game game;
    private BufferedImage image;

    public SpritePlayerRenderer(Game game) {
        this.game = game;
        this.image = game.getSprites().getImage(219, 304, Player.WIDTH, Player.HEIGHT);
    }

    @Override
    public void render(Graphics g, double x, double y) {
        g.drawImage(image, (int) x, (int) y, null);
    }
}
