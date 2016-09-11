package com.github.jarlah.game.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Sprites {
    private static Map<String, BufferedImage> spriteSheets;

    private static BufferedImage loadSprite(String file) {
        InputStream is = ClassLoader.getSystemResourceAsStream(file + ".png");
        if (is == null) {
            throw new IllegalArgumentException("Sprite " + file + " was not found");
        }
        try { return ImageIO.read(is); } catch(Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            return null;
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
