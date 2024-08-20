package com.balitechy.spacewar.main;

public class SpriteRendererFactory implements GameRendererFactory {
    
    private Game game;

    public SpriteRendererFactory(Game game) {
        this.game = game;
    }

    @Override
    public IPlayerRenderer createPlayerRenderer() {
        return new SpritePlayerRenderer(game);
    }

    @Override
    public IBulletRenderer createBulletRenderer() {
        return new SpriteBulletRenderer(game);
    }

    @Override
    public IBackgroundRenderer createBackgroundRenderer() {
        return new BitmapBackgroundRenderer();
    }
}