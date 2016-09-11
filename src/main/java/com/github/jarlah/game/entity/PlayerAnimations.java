package com.github.jarlah.game.entity;

import java.awt.image.BufferedImage;

import com.github.jarlah.game.gfx.Animation;
import com.github.jarlah.game.gfx.Sprites;

interface PlayerAnimations {
    String SPRITE_SHEET = "player";
    int SPRITE_WIDTH = 32;
    int SPRITE_HEIGHT = 32;
    double SPEED = 1.4;

    // The animation states
    Animation WALKING_UP_ANIMATION = new Animation(
            new BufferedImage[]{
                Sprites.getSprite(SPRITE_SHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 0, 3),
                Sprites.getSprite(SPRITE_SHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 2, 3)
            }, 10);

    Animation STANDING_UP_ANIMATION = new Animation(
            new BufferedImage[]{
                    Sprites.getSprite(SPRITE_SHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 1, 3)}, 0);

    Animation WALKING_DOWN_ANIMATION = new Animation(
            new BufferedImage[]{
                    Sprites.getSprite(SPRITE_SHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 0, 0),
                    Sprites.getSprite(SPRITE_SHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 2, 0)}, 10);
    Animation STANDING_DOWN_ANIMATION = new Animation(
            new BufferedImage[]{
                    Sprites.getSprite(SPRITE_SHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 1, 0)}, 0);
    Animation WALKING_LEFT_ANIMATION = new Animation(
            new BufferedImage[]{
                    Sprites.getSprite(SPRITE_SHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 0, 1),
                    Sprites.getSprite(SPRITE_SHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 2, 1)}, 10);
    Animation STANDING_LEFT_ANIMATION = new Animation(
            new BufferedImage[]{
                    Sprites.getSprite(SPRITE_SHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 1, 1)}, 0);
    Animation WALKING_RIGHT_ANIMATION = new Animation(
            new BufferedImage[]{
                    Sprites.getSprite(SPRITE_SHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 0, 2),
                    Sprites.getSprite(SPRITE_SHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 2, 2)}, 10);
    Animation STANDING_RIGHT_ANIMATION = new Animation(
            new BufferedImage[]{
                    Sprites.getSprite(SPRITE_SHEET, SPRITE_WIDTH, SPRITE_HEIGHT, 1, 2)}, 0);
}
