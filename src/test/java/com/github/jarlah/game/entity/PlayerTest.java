package com.github.jarlah.game.entity;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import org.junit.Test;

public class PlayerTest {

	double speed = 1.4;
	double x = 230.0;
	double y = 124.0;
	
	@Test
	public void pressingRightAndLeftAtSameTimeHasNoEfect() {
		// Given:
		Player player = new Player(speed, x, y);
		
		// When:
		assertEquals(PlayerState.STANDING_DOWN, player.state);
		player.keyPressed(KeyEvent.VK_LEFT);
		player.keyPressed(KeyEvent.VK_RIGHT);
		player.update();
		
		// Then:
		assertEquals(x, player.x, 0); 
		assertEquals(PlayerState.STANDING_DOWN, player.state);
	}
	
	@Test
	public void pressingDownAndUpAtSameTimeHasNoEfect() {
		// Given:
		Player player = new Player(speed, x, y);
		
		// When:
		assertEquals(PlayerState.STANDING_DOWN, player.state);
		player.keyPressed(KeyEvent.VK_UP);
		player.keyPressed(KeyEvent.VK_DOWN);
		player.update();
		
		// Then:
		assertEquals(y, player.y, 0); 
		assertEquals(PlayerState.STANDING_DOWN, player.state);
	}
	
	@Test
	public void playerCanMoveLeft() {
		// Given:
		Player player = new Player(speed, x, y);
		
		// When:
		player.keyPressed(KeyEvent.VK_LEFT);
		player.update();
		
		// Then:
		assertEquals(x - speed, player.x, 0); 
		assertEquals(PlayerState.WALKING_LEFT, player.state);
		player.keyReleased(KeyEvent.VK_LEFT);
		player.update();
		assertEquals(PlayerState.STANDING_LEFT, player.state);
	}
	
	@Test
	public void playerCanMoveRight() {
		// Given:
		Player player = new Player(speed, x, y);
		
		// When:
		player.keyPressed(KeyEvent.VK_RIGHT);
		player.update();
		
		// Then:
		assertEquals(x + speed, player.x, 0); 
		assertEquals(PlayerState.WALKING_RIGHT, player.state);
		player.keyReleased(KeyEvent.VK_RIGHT);
		player.update();
		assertEquals(PlayerState.STANDING_RIGHT, player.state);
	}
	
	@Test
	public void playerCanMoveUp() {
		// Given:
		Player player = new Player(speed, x, y);
		
		// When:
		player.keyPressed(KeyEvent.VK_UP);
		player.update();
		
		// Then:
		assertEquals(y - speed, player.y, 0); 
		assertEquals(PlayerState.WALKING_UP, player.state);
		player.keyReleased(KeyEvent.VK_UP);
		player.update();
		assertEquals(PlayerState.STANDING_UP, player.state);
	}
	
	@Test
	public void playerCanMoveDown() {
		// Given:
		Player player = new Player(speed, x, y);
		
		// When:
		player.keyPressed(KeyEvent.VK_DOWN);
		player.update();
		
		// Then:
		assertEquals(y + speed, player.y, 0); 
		assertEquals(PlayerState.WALKING_DOWN, player.state);
		player.keyReleased(KeyEvent.VK_DOWN);
		player.update();
		assertEquals(PlayerState.STANDING_DOWN, player.state);
	}
}
