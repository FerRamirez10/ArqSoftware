package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;

public class VectorBulletRenderer implements IBulletRenderer {

    @Override
    public void render(Graphics g, double x, double y) {
        // Draw bullet as a small rectangle
        g.setColor(Color.YELLOW);
        g.fillRect((int) x, (int) y, 4, 10);
        
        // Add border for better visibility
        g.setColor(Color.BLACK);
        g.drawRect((int) x, (int) y, 4, 10);
    }
}