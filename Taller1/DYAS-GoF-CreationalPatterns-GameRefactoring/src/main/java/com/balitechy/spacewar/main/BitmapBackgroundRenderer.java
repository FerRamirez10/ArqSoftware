package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BitmapBackgroundRenderer implements IBackgroundRenderer {

    private BufferedImage background;

    @Override
    public void render(Graphics g, Canvas c) throws IOException {
        SpritesImageLoader bgLoader = new SpritesImageLoader("/bg.png");
        bgLoader.loadImage();
        background = bgLoader.getImage(0, 0, 640, 480);
        g.drawImage(background, 0, 0, c.getWidth(), c.getHeight(), c);
    }
}
