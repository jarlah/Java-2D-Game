package com.github.jarlah.game.entity;

import java.awt.Graphics;

import com.github.jarlah.game.gfx.Animation;


public enum PlayerStateEngine implements PlayerState {
	STANDING(0, 0, STANDING_STILL_ANIMATION) {
		@Override
		public void reset(Entity context) {
			if (context.up && context.left && !context.right && !context.down) {
				context.state = WALKING_UP_LEFT;
			} else if (context.down && context.left && !context.right && !context.up) {
				context.state = WALKING_DOWN_LEFT;
			} else if (context.up && context.right && !context.left && !context.down) {
				context.state = WALKING_UP_RIGHT;
			} else if (context.down && context.right && !context.left && !context.up) {
				context.state = WALKING_DOWN_RIGHT;
			} else if (context.up) {
				context.state = WALKING_UP;
			} else if (context.down) {
				context.state = WALKING_DOWN;
			} else if (context.left) {
				context.state = WALKING_LEFT;
			} else if (context.right) {
				context.state = WALKING_RIGHT;
			}
		}
	},
	WALKING_LEFT(-SPEED, 0, WALKING_LEFT_ANIMATION) {},
	WALKING_RIGHT(SPEED, 0, WALKING_RIGHT_ANIMATION) {},
	WALKING_UP(0, -SPEED, WALKING_UP_ANIMATION) {},
	WALKING_DOWN(0, SPEED, WALKING_DOWN_ANIMATION) {},
	WALKING_UP_LEFT(-SPEED, -SPEED, WALKING_LEFT_ANIMATION) {
		@Override
		public void reset(Entity context) {
			if (!context.up && context.left) {
				context.state = WALKING_LEFT;
			}
			if (context.up && !context.left) {
				context.state = WALKING_UP;
			}
			if (!context.up && !context.left) {
				context.state = STANDING;
				context.state.reset(context);
			}
		}
	},
	WALKING_UP_RIGHT(SPEED, -SPEED, WALKING_RIGHT_ANIMATION) {
		@Override
		public void reset(Entity context) {
			if (!context.up && context.right) {
				context.state = WALKING_RIGHT;
			}
			if (context.up && !context.right) {
				context.state = WALKING_UP;
			}
			if (!context.up && !context.right) {
				context.state = STANDING;
				context.state.reset(context);
			}
		}
	},
	WALKING_DOWN_LEFT(-SPEED, SPEED, WALKING_LEFT_ANIMATION) {
		@Override
		public void reset(Entity context) {
			if (!context.down && context.left) {
				context.state = WALKING_LEFT;
			}
			if (context.down && !context.left) {
				context.state = WALKING_DOWN;
			}
			if (!context.down && !context.left) {
				context.state = STANDING;
				context.state.reset(context);
			}
		}
	},
	WALKING_DOWN_RIGHT(SPEED, SPEED, WALKING_RIGHT_ANIMATION) {
		@Override
		public void reset(Entity context) {
			if (!context.down && context.right) {
				context.state = WALKING_RIGHT;
			}
			if (context.down && !context.right) {
				context.state = WALKING_DOWN;
			}
			if (!context.down && !context.right) {
				context.state = STANDING;
				context.state.reset(context);
			}
		}
	};
	
	private final Animation animation;
	private final double speedX, speedY;

	private PlayerStateEngine(double speedX, double speedY, Animation animation) {
		this.animation = animation;
		this.speedX = speedX;
		this.speedY = speedY;
	}
	
	@Override
	public void reset(Entity context) {
		context.state = STANDING;
		context.state.reset(context);
	}
	
	public void update(Entity context) {
		animation.update();
		if (animation.getFrameDelay() > 0) {
			animation.start();
		}
		context.x += speedX;
		context.y += speedY;
	}

	@Override
	public void render(Entity context, Graphics g) {
		g.drawImage(animation.getSprite(), (int) context.x, (int) context.y, null);
	}
}
