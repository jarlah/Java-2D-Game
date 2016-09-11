package com.github.jarlah.game;

abstract class Loop implements Runnable {
	private static final double GAME_HERTZ = 60.0;
	private static final double TIME_BETWEEN_UPDATES = 1000000000.0 / GAME_HERTZ;
	private static final double TARGET_FPS = 60.0;
	private static final double TARGET_TIME_BETWEEN_RENDERS = 1000000000.0 / TARGET_FPS;
	private static final double MAX_UPDATES_BEFORE_RENDER = 5;
	
	private final String name;
	private Thread thread;
	private boolean running, paused;
	private int fps, ups;
	
	Loop(String name) {
		this.name = name;
		this.running = false;
	}
	
	synchronized void start() {
		this.running = true;
		this.thread = new Thread(this, name);
		this.thread.start();
	}
	
	private synchronized void stop() {
		this.running = false;
		try {
			this.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		int frameCount = 0;
		
		double lastUpdateTime = System.nanoTime();
		double lastRenderTime;
		
		int lastSecondTime = (int) (lastUpdateTime / 1000000000);

		while (running) {
			if (!paused) {
	 			lastRenderTime = System.nanoTime();
				int updateCount = 0;
	
				while (lastRenderTime - lastUpdateTime > TIME_BETWEEN_UPDATES
						&& updateCount < MAX_UPDATES_BEFORE_RENDER) {
					update();
					lastUpdateTime += TIME_BETWEEN_UPDATES;
					updateCount++;
				}
	
				if (lastRenderTime - lastUpdateTime > TIME_BETWEEN_UPDATES) {
					lastUpdateTime = lastRenderTime - TIME_BETWEEN_UPDATES;
				}
	
				render();
				
				frameCount ++;
	
				int thisSecond = (int) (lastUpdateTime / 1000000000);
				if (thisSecond > lastSecondTime) {
					fps = frameCount;
					frameCount = 0;
					ups = updateCount;
					lastSecondTime = thisSecond;
				}
	
				while ((lastRenderTime - lastRenderTime) < TARGET_TIME_BETWEEN_RENDERS
						&& (lastRenderTime - lastUpdateTime) < TIME_BETWEEN_UPDATES) {
					Thread.yield();
					try {Thread.sleep(1);} catch (Exception ignored) {}
					lastRenderTime = System.nanoTime();
				}
			} else {
				try {Thread.sleep(250);} catch (Exception ignored) {}
			}
		}
		stop();
	}
	
	public abstract void update();
	public abstract void render();

	int getFps() {
		return fps;
	}
	
	int getUps() {
		return ups;
	}
	
	void pause() {
		paused = true;
	}

	void resume() {
		paused = false;
	}

}
