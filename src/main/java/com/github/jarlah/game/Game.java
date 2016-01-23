package com.github.jarlah.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.github.jarlah.game.entity.Player;

public class Game extends Loop implements KeyListener, MouseListener, MouseMotionListener, FocusListener {
	private final static String TITLE = "Rain";
	
	private final JFrame window;
	private final Canvas canvas;
	private final BufferedImage image;
	private final Player player;
	
	public Game(String title) {
		super(TITLE);
		this.canvas = new Canvas();
		this.canvas.setPreferredSize(Resolution.getDimension());
		this.canvas.setMinimumSize(Resolution.getDimension());
		this.canvas.setMaximumSize(Resolution.getDimension());
		this.image = new BufferedImage(Resolution.PIXEL_WIDTH, Resolution.PIXEL_HEIGHT, BufferedImage.TYPE_INT_RGB);
		this.window = new JFrame(title);
		this.window.setResizable(false);
		this.window.add(canvas);
		this.window.pack();
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setLocationRelativeTo(null);
		this.window.setVisible(true);
		this.canvas.addKeyListener(this);
		this.canvas.addMouseListener(this);
		this.canvas.addMouseMotionListener(this);
		this.player = new Player(1.4, 100, 100);
		this.canvas.requestFocus();
		this.canvas.addFocusListener(this);
	}
	
	public static void main(String[] args) {
		Game game = new Game("Rain");
		game.start();
	}

	@Override
	public void update() {
		player.update();
	}

	@Override
	public void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		
		Graphics g2d = image.getGraphics();
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		player.render(g2d);
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		window.setTitle(TITLE + " | " + getFps() + " fps, " + getUps() + " update" + (getUps() > 1 ? " catchup" : "") + " per render");
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
		bs.show();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		player.keyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		player.keyReleased(e.getKeyCode());
	}

	@Override
	public void focusGained(FocusEvent e) {
		resume();
	}

	@Override
	public void focusLost(FocusEvent e) {
		player.stop();
		pause();
	}

}
