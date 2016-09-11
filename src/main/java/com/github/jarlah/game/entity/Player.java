package com.github.jarlah.game.entity;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player extends Entity {
	public Player(double x, double y) {
		super(x, y);
		state = PlayerState.STANDING_DOWN;
	}

	public void keyPressed(int code) {
		onKeyEvent(code, false);
	}

	public void keyReleased(int code) {
		onKeyEvent(code, true);
	}

	private void onKeyEvent(int code, boolean released) {
		if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
			this.left = !released;
		}
		if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
			this.right = !released;
		}
		if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
			this.up = !released;
		}
		if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
			this.down = !released;
		}
	}

	public void stop() {
		this.down = false;
		this.up = false;
		this.left = false;
		this.right = false;
	}

	public void update() {
		state.reset(this);
		state.update(this);
	}

	@Override
	public void render(Graphics g) {
		state.render(this, g);
	}

}
