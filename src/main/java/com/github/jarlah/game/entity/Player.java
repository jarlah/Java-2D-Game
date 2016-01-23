package com.github.jarlah.game.entity;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.github.jarlah.game.gfx.Animation;
import com.github.jarlah.game.gfx.Sprites;

public class Player extends Entity {
	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;
	
	// Images for each animation
	private BufferedImage[] walkingDown = {Sprites.getSprite("player", WIDTH, HEIGHT, 0, 0), Sprites.getSprite("player", WIDTH, HEIGHT, 2, 0)};
	private BufferedImage[] walkingUp = {Sprites.getSprite("player", WIDTH, HEIGHT, 0, 3), Sprites.getSprite("player", WIDTH, HEIGHT, 2, 3)};
	private BufferedImage[] walkingLeft = {Sprites.getSprite("player", WIDTH, HEIGHT, 0, 1), Sprites.getSprite("player", WIDTH, HEIGHT, 2, 1)};
	private BufferedImage[] walkingRight = {Sprites.getSprite("player", WIDTH, HEIGHT, 0, 2), Sprites.getSprite("player", WIDTH, HEIGHT, 2, 2)};
	private BufferedImage[] standing = {Sprites.getSprite("player", WIDTH, HEIGHT, 1, 0)};

	// The animation states
	protected Animation walkUpAn = new Animation(walkingUp, 10);
	protected Animation walkDownAn = new Animation(walkingDown, 10);
	protected Animation walkLeftAn = new Animation(walkingLeft, 10);
	protected Animation walkRightAn = new Animation(walkingRight, 10);
	protected Animation standingAn = new Animation(standing, 10);

	// The actual animation
	protected Animation animation = standingAn;
	
	public Player(double speed, double x, double y) {
		super(speed, x, y);
	}
	
	public void keyPressed(int code) {
		onKeyEvent(code, false);
	}
	
	public void keyReleased(int code) {
		onKeyEvent(code, true);
	}

	private void onKeyEvent(int code, boolean released) {
		switch(code) {
			case KeyEvent.VK_A:
			case KeyEvent.VK_LEFT:
				if (left = !released) {
					animation = walkLeftAn;
				    animation.start();
				} else {
					resetAnimation();
				}
				break;
			case KeyEvent.VK_D:
			case KeyEvent.VK_RIGHT:
				if (right = !released) {
					animation = walkRightAn;
				    animation.start();
				} else {
					resetAnimation();
				}
				break;
			case KeyEvent.VK_W:
			case KeyEvent.VK_UP:
				if (up = !released) {
					animation = walkUpAn;
				    animation.start();
				} else {
					resetAnimation();
				}
				break;
			case KeyEvent.VK_S:
			case KeyEvent.VK_DOWN:
				if (down = !released) {
					animation = walkDownAn;
				    animation.start();
				} else {
					resetAnimation();
				}
				break;
			default:
				resetAnimation();
				break;
		}
	}

	/**
	 * Reset animation to the active direction or set animation to standing
	 */
	private void resetAnimation() {
		if (left) {
			onKeyEvent(KeyEvent.VK_LEFT, false);
			return;
		}
		if (right) {
			onKeyEvent(KeyEvent.VK_RIGHT, false);
			return;
		}
		if (up) {
			onKeyEvent(KeyEvent.VK_UP, false);
			return;
		}
		if (down) {
			onKeyEvent(KeyEvent.VK_DOWN, false);
			return;
		}

		setStandingAnimation();
	}

	private void setStandingAnimation() {
		animation.stop();
		animation.reset();
		animation = standingAn;
	}

	public void update() {
		animation.update();
		
		double xa = 0, ya = 0;
		
		if (left) xa += -speed;
		if (right) xa += speed;
		if (up) ya += -speed;
		if (down) ya += speed;
		
		if (xa != 0 || ya != 0) {
			x += xa;
			y += ya;
			animation.start();
		} else {
			animation.stop();
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(animation.getSprite(), (int) x, (int) y, null);
	}

}
