package com.balitechy.spacewar.main;

public class VectorRendererFactory implements GameRendererFactory {

    @Override
    public IPlayerRenderer createPlayerRenderer() {
        return new VectorPlayerRenderer();
    }

    @Override
    public IBulletRenderer createBulletRenderer() {
        return new VectorBulletRenderer();
    }

    @Override
    public IBackgroundRenderer createBackgroundRenderer() {
        return new VectorBackgroundRenderer();
    }
}