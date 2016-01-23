package com.github.jarlah.game.entity;

import java.awt.Graphics;

public abstract class Entity {
	protected double speed;
	protected double x;
	protected double y;
	protected boolean left;
	protected boolean right;
	protected boolean up;
	protected boolean down;
	
	public Entity(double speed, double x, double y) {
		this.speed = speed;
		this.x = x;
		this.y = y;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
}