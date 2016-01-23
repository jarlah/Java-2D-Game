package com.github.jarlah.game.entity;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import org.junit.Test;

public class PlayerTest {

	double speed = 1.4;
	double x = 230.0;
	double y = 124.0;
	
	@Test
	public void playerCanMoveLeft() {
		// Given:
		Player player = new Player(speed, x, y);
		
		// When:
		assertTrue(player.animation.isStopped());
		player.keyPressed(KeyEvent.VK_LEFT);
		player.update();
		
		// Then:
		assertEquals(x - speed, player.x, 0); 
		assertEquals(player.animation, player.walkLeftAn);
		assertFalse(player.animation.isStopped());
	}
	
	@Test
	public void playerCanMoveRight() {
		// Given:
		Player player = new Player(speed, x, y);
		
		// When:
		assertTrue(player.animation.isStopped());
		player.keyPressed(KeyEvent.VK_RIGHT);
		player.update();
		
		// Then:
		assertEquals(x + speed, player.x, 0); 
		assertEquals(player.animation, player.walkRightAn);
		assertFalse(player.animation.isStopped());
	}
	
	@Test
	public void playerCanMoveUp() {
		// Given:
		Player player = new Player(speed, x, y);
		
		// When:
		assertTrue(player.animation.isStopped());
		player.keyPressed(KeyEvent.VK_UP);
		player.update();
		
		// Then:
		assertEquals(y - speed, player.y, 0); 
		assertEquals(player.animation, player.walkUpAn);
		assertFalse(player.animation.isStopped());
	}
	
	@Test
	public void playerCanMoveDown() {
		// Given:
		Player player = new Player(speed, x, y);
		
		// When:
		assertTrue(player.animation.isStopped());
		player.keyPressed(KeyEvent.VK_DOWN);
		player.update();
		
		// Then:
		assertEquals(y + speed, player.y, 0); 
		assertEquals(player.animation, player.walkDownAn);
		assertFalse(player.animation.isStopped());
	}
}
