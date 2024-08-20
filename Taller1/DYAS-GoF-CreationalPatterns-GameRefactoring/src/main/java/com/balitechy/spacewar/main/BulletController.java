package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;

public class BulletController {
    private final LinkedList<Bullet> bl = new LinkedList<>();

    // Synchronize the entire method
    public synchronized void tick(){
        LinkedList<Bullet> toRemove = new LinkedList<>();
        for (Bullet b : bl) {
            if (b.getY() < 0) {
                toRemove.add(b);
            } else {
                b.tick();
            }
        }
        bl.removeAll(toRemove);
    }

    // Synchronize the entire method
    public synchronized void render(Graphics g, IBulletRenderer bulletRenderer){
        Iterator<Bullet> iterator = bl.iterator();
        while (iterator.hasNext()) {
            Bullet b = iterator.next();
            bulletRenderer.render(g, b.getX(), b.getY());
        }
    }

    public synchronized void addBullet(Bullet bullet){
        bl.add(bullet);
    }

    public synchronized void removeBullet(Bullet bullet){
        bl.remove(bullet);
    }
}
