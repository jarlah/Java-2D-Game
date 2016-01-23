package com.github.jarlah.game.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.github.jarlah.game.gfx.Animation;
import com.github.jarlah.game.gfx.Sprites;

public interface PlayerState {
	public static final String SPRITESHEET = "player";
	public static final int SPRITE_WIDTH = 32;
	public static final int SPRITE_HEIGHT = 32;
	public static final double SPEED = 1.4;

	// The animation states
	public static final Animation WALKING_UP_ANIMATION = new Animation(
			new BufferedImage[] {
					Sprites.getSprite(SPRITESHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 0, 3),
					Sprites.getSprite(SPRITESHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 2, 3) }, 10);
	public static final Animation WALKING_DOWN_ANIMATION = new Animation(
			new BufferedImage[] {
					Sprites.getSprite(SPRITESHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 0, 0),
					Sprites.getSprite(SPRITESHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 2, 0) }, 10);
	public static final Animation WALKING_LEFT_ANIMATION = new Animation(
			new BufferedImage[] {
					Sprites.getSprite(SPRITESHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 0, 1),
					Sprites.getSprite(SPRITESHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 2, 1) }, 10);
	public static final Animation WALKING_RIGHT_ANIMATION = new Animation(
			new BufferedImage[] {
					Sprites.getSprite(SPRITESHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 0, 2),
					Sprites.getSprite(SPRITESHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 2, 2) }, 10);
	public static final Animation STANDING_STILL_ANIMATION = new Animation(
			new BufferedImage[] { 
					Sprites.getSprite(SPRITESHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 1, 0) }, 10);

	public void reset(Entity context);

	public void update(Entity context);

	public void render(Entity context, Graphics g);
}
