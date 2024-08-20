package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class VectorBackgroundRenderer implements IBackgroundRenderer {

    @Override
    public void render(Graphics g, Canvas c) {
        // Create a gradient background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, c.getWidth(), c.getHeight());

        // Draw gradient manually
        int gradientHeight = c.getHeight();
        Color startColor = Color.BLACK;
        Color endColor = Color.BLUE;
        for (int i = 0; i < gradientHeight; i++) {
            int r = (int) ((1 - (double) i / gradientHeight) * startColor.getRed() + ((double) i / gradientHeight) * endColor.getRed());
            int gColor = (int) ((1 - (double) i / gradientHeight) * startColor.getGreen() + ((double) i / gradientHeight) * endColor.getGreen());
            int b = (int) ((1 - (double) i / gradientHeight) * startColor.getBlue() + ((double) i / gradientHeight) * endColor.getBlue());
            g.setColor(new Color(r, gColor, b));
            g.drawLine(0, i, c.getWidth(), i);
        }

        // Add some stars
        g.setColor(Color.WHITE);
        for (int i = 0; i < 100; i++) {
            int x = (int) (Math.random() * c.getWidth());
            int y = (int) (Math.random() * c.getHeight());
            g.fillOval(x, y, 2, 2);
        }
    }
}