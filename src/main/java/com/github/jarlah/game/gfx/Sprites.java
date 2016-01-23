package com.github.jarlah.game.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Sprites {
    private static final int TILE_SIZE = 32;

    private static Map<String, BufferedImage> spriteSheets;

    public static BufferedImage loadSprite(String file) {

        BufferedImage sprite = null;

        try {
            sprite = ImageIO.read(new File("res/" + file + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sprite;
    }

    public static BufferedImage getSprite(String path, int xGrid, int yGrid) {

        if (spriteSheets == null) {
        	spriteSheets = new HashMap<>();
            spriteSheets.put(path, loadSprite(path));
        }

        return spriteSheets.get(path).getSubimage(xGrid * TILE_SIZE, yGrid * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

}
