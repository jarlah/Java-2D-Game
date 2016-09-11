package com.github.jarlah.game.gfx;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

import org.junit.Test;

public class AnimationTest {
	private static final int FRAME_DELAY = 10;
	@Test
	public void animationShiftsToNextFrameAfterUpdateIfNotStoppedAndFrameDelayIsReached() {
		// Given:
		Animation animation = new Animation(new BufferedImage[3], FRAME_DELAY);
		animation.start();

		// When:
		animation.update();
		IntStream.range(0, FRAME_DELAY).forEach((i) -> {
			assertEquals(0, animation.getCurrentFrame());
			animation.update();
		});
		// Then:
		assertEquals(1, animation.getCurrentFrame());
		
		// When:
		animation.update();
		IntStream.range(0, FRAME_DELAY).forEach((i) -> {
			assertEquals(1, animation.getCurrentFrame());
			animation.update();
		});
		// Then:
		assertEquals(2, animation.getCurrentFrame());
		
		// When:
		animation.update();
		IntStream.range(0, FRAME_DELAY).forEach((i) -> {
			assertEquals(2, animation.getCurrentFrame());
			animation.update();
		});
		// Then:
		assertEquals(0, animation.getCurrentFrame());
	}

}
