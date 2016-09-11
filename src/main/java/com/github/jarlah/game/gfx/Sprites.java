package com.github.jarlah.game.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Sprites {
    private static Map<String, BufferedImage> spriteSheets;

    private static BufferedImage loadSprite(String file) {
        try {
            return ImageIO.read(ClassLoader.getSystemResourceAsStream(file + ".png"));
        } catch (IOException e) {
            throw new IllegalArgumentException("Sprite " + file + " was not found");
        }
    }

    public static BufferedImage getSprite(String path, int width, int height, int xGrid, int yGrid) {
        if (spriteSheets == null) {
            spriteSheets = new HashMap<>();
            spriteSheets.put(path, loadSprite(path));
        }
        return spriteSheets.get(path).getSubimage(xGrid * width, yGrid * height, width, height);
    }

}
