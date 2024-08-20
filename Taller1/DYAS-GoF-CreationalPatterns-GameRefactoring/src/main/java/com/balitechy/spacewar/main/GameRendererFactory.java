package com.balitechy.spacewar.main;

public interface GameRendererFactory {
    IPlayerRenderer createPlayerRenderer();
    IBulletRenderer createBulletRenderer();
    IBackgroundRenderer createBackgroundRenderer();
}
