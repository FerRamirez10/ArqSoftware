package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.io.IOException;

// IBackgroundRenderer.java
public interface IBackgroundRenderer {
    void render(Graphics g, Canvas c) throws IOException;
}