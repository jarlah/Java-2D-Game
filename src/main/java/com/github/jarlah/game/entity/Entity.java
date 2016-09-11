package com.github.jarlah.game.entity;

import java.awt.*;

abstract class Entity {
    double x;
    double y;
    boolean left;
    boolean right;
    boolean up;
    boolean down;
    PlayerState state;

    Entity(double x, double y) {
        this.x = x;
        this.y = y;
    }

    boolean isMoving() {
        return up || down || left || right;
    }

    public void stop() {
        up = false;
        down = false;
        left = false;
        right = false;
    }

    public abstract void update();

    public abstract void render(Graphics g);
}
