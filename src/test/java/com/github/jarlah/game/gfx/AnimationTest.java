package com.github.jarlah.game.gfx;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;

import org.junit.Test;

public class AnimationTest {

	@Test
	public void animationShiftsToNextFrameAfterUpdateIfNotStoppedAndFrameDelayIsReached() {
		// Given:
		Animation animation = new Animation(new BufferedImage[3], 10);

		// When:
		animation.start();
		assertEquals(0, animation.getCurrentFrame());
		animation.update();
		assertEquals(0, animation.getCurrentFrame());
		animation.update();
		assertEquals(0, animation.getCurrentFrame());
		animation.update();
		assertEquals(0, animation.getCurrentFrame());
		animation.update();
		assertEquals(0, animation.getCurrentFrame());
		animation.update();
		assertEquals(0, animation.getCurrentFrame());
		animation.update();
		assertEquals(0, animation.getCurrentFrame());
		animation.update();
		assertEquals(0, animation.getCurrentFrame());
		animation.update();
		assertEquals(0, animation.getCurrentFrame());
		animation.update();
		assertEquals(0, animation.getCurrentFrame());
		animation.update();
		assertEquals(0, animation.getCurrentFrame());
		animation.update();
		
		// Then:
		assertEquals(1, animation.getCurrentFrame());
		
		// When:
		animation.update();
		assertEquals(1, animation.getCurrentFrame());
		animation.update();
		assertEquals(1, animation.getCurrentFrame());
		animation.update();
		assertEquals(1, animation.getCurrentFrame());
		animation.update();
		assertEquals(1, animation.getCurrentFrame());
		animation.update();
		assertEquals(1, animation.getCurrentFrame());
		animation.update();
		assertEquals(1, animation.getCurrentFrame());
		animation.update();
		assertEquals(1, animation.getCurrentFrame());
		animation.update();
		assertEquals(1, animation.getCurrentFrame());
		animation.update();
		assertEquals(1, animation.getCurrentFrame());
		animation.update();
		assertEquals(1, animation.getCurrentFrame());
		animation.update();
		
		// Then:
		assertEquals(2, animation.getCurrentFrame());
		
		// When:
		animation.update();
		assertEquals(2, animation.getCurrentFrame());
		animation.update();
		assertEquals(2, animation.getCurrentFrame());
		animation.update();
		assertEquals(2, animation.getCurrentFrame());
		animation.update();
		assertEquals(2, animation.getCurrentFrame());
		animation.update();
		assertEquals(2, animation.getCurrentFrame());
		animation.update();
		assertEquals(2, animation.getCurrentFrame());
		animation.update();
		assertEquals(2, animation.getCurrentFrame());
		animation.update();
		assertEquals(2, animation.getCurrentFrame());
		animation.update();
		assertEquals(2, animation.getCurrentFrame());
		animation.update();
		assertEquals(2, animation.getCurrentFrame());
		animation.update();
	
		// Then:
		assertEquals(0, animation.getCurrentFrame());
	}

}
