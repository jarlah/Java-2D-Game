package com.github.jarlah.game.entity;

import com.github.jarlah.game.gfx.Animation;

import java.awt.*;

/**
 * Having individual speeds for x and y for some animations is good.
 *
 * @author jarlah
 */
enum PlayerState implements PlayerAnimations {
    STANDING_LEFT(0, 0, STANDING_LEFT_ANIMATION),
    STANDING_RIGHT(0, 0, STANDING_RIGHT_ANIMATION),
    STANDING_DOWN(0, 0, STANDING_DOWN_ANIMATION),
    STANDING_UP(0, 0, STANDING_UP_ANIMATION),
    WALKING_LEFT(-SPEED, 0, WALKING_LEFT_ANIMATION),
    WALKING_RIGHT(SPEED, 0, WALKING_RIGHT_ANIMATION),
    WALKING_UP(0, -SPEED, WALKING_UP_ANIMATION),
    WALKING_DOWN(0, SPEED, WALKING_DOWN_ANIMATION),
    WALKING_UP_LEFT(-SPEED, -SPEED, WALKING_LEFT_ANIMATION),
    WALKING_UP_RIGHT(SPEED, -SPEED, WALKING_RIGHT_ANIMATION),
    WALKING_DOWN_LEFT(-SPEED, SPEED, WALKING_LEFT_ANIMATION),
    WALKING_DOWN_RIGHT(SPEED, SPEED, WALKING_RIGHT_ANIMATION);

    private final Animation animation;
    private final double speedX, speedY;

    PlayerState(double speedX, double speedY, Animation animation) {
        this.animation = animation;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public void reset(Entity context) {
        if (!context.isMoving()) {
            switch (context.state) {
                case WALKING_DOWN_LEFT:
                case WALKING_UP_LEFT:
                case WALKING_LEFT:
                    context.state = STANDING_LEFT;
                    break;
                case WALKING_DOWN_RIGHT:
                case WALKING_UP_RIGHT:
                case WALKING_RIGHT:
                    context.state = STANDING_RIGHT;
                    break;
                case WALKING_UP:
                    context.state = STANDING_UP;
                    break;
                case WALKING_DOWN:
                    context.state = STANDING_DOWN;
                    break;
                default:
                    break;
            }
        } else {
            if (context.up && context.left && !context.right && !context.down) {
                context.state = WALKING_UP_LEFT;
            } else if (context.down && context.left && !context.right && !context.up) {
                context.state = WALKING_DOWN_LEFT;
            } else if (context.up && context.right && !context.left && !context.down) {
                context.state = WALKING_UP_RIGHT;
            } else if (context.down && context.right && !context.left && !context.up) {
                context.state = WALKING_DOWN_RIGHT;
            } else if (context.up && !context.down) {
                context.state = WALKING_UP;
            } else if (context.down && !context.up) {
                context.state = WALKING_DOWN;
            } else if (context.left && !context.right) {
                context.state = WALKING_LEFT;
            } else if (context.right && !context.left) {
                context.state = WALKING_RIGHT;
            }
        }
    }

    public void update(Entity context) {
        animation.update();
        animation.start();
        context.x += speedX;
        context.y += speedY;
    }

    public void render(Entity context, Graphics g) {
        g.drawImage(animation.getSprite(), (int) context.x, (int) context.y, null);
    }
}
