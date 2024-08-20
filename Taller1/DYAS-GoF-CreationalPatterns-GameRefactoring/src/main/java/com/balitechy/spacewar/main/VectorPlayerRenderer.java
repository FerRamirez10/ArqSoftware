package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;

public class VectorPlayerRenderer implements IPlayerRenderer {

    @Override
    public void render(Graphics g, double x, double y) {
        // Define player shape
        g.setColor(Color.GREEN);
        g.fillPolygon(new int[] {(int) x, (int) (x + 30), (int) (x + 15)}, 
                      new int[] {(int) y, (int) y, (int) (y - 30)}, 3);
        
        // Draw border
        g.setColor(Color.ORANGE);
        g.drawPolygon(new int[] {(int) x, (int) (x + 30), (int) (x + 15)}, 
                      new int[] {(int) y, (int) y, (int) (y - 30)}, 3);
    }
}
