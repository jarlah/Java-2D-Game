package com.github.jarlah.game;

import java.awt.Dimension;

public class Resolution {
	public static int PIXEL_WIDTH = 300;
	public static int PIXEL_HEIGHT = 168;
	public static int SCALE = 3;

	static Dimension getDimension() {
		return new Dimension(PIXEL_WIDTH * SCALE, PIXEL_HEIGHT * SCALE);
	}
}
