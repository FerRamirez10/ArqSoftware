package com.balitechy.spacewar.main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpritesImageLoader {
    
    private BufferedImage spriteSheet;
    private String path;

    public SpritesImageLoader(String path) {
        this.path = path;
    }

    public void loadImage() throws IOException {
        spriteSheet = ImageIO.read(getClass().getResource(path));
    }

    public BufferedImage getImage(int x, int y, int width, int height) {
        return spriteSheet.getSubimage(x, y, width, height);
    }
}
