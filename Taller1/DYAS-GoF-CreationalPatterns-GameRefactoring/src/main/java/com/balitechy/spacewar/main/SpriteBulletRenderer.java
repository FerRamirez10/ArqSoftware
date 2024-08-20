package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpriteBulletRenderer implements IBulletRenderer {
    
    private Game game;
    private BufferedImage image;

    public SpriteBulletRenderer(Game game) {
        this.game = game;
        this.image = game.getSprites().getImage(35, 52, Bullet.WIDTH, Bullet.HEIGHT);
    }

    @Override
    public void render(Graphics g, double x, double y) {
        g.drawImage(image, (int)x, (int)y, null);
    }
}
