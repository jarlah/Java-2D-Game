package com.github.jarlah.game.state;

import com.github.jarlah.game.Resolution;
import com.github.jarlah.game.entity.Player;

import java.awt.*;
import java.awt.event.KeyEvent;

public enum GameState {
    MENU {
        public void render(Graphics g) {
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, Resolution.PIXEL_WIDTH, Resolution.PIXEL_HEIGHT);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 48));
            g.drawString("START", 70, 100);
        }

        public void keyPressed(int code) {
            if (code == KeyEvent.VK_ENTER) {
                GameStateManager.getInstance().setState(LEVEL1);
            }
        }
    }, PAUSED {
        public void render(Graphics g) {
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, Resolution.PIXEL_WIDTH, Resolution.PIXEL_HEIGHT);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 28));
            g.drawString("PAUSED...", 70, 100);
        }

        public void keyPressed(int code) {
            if (code == KeyEvent.VK_ENTER) {
                GameStateManager.getInstance().setState(LEVEL1);
            }
        }
    }, LEVEL1 {
        Player player = new Player(100, 100);

        public void update() {
            player.update();
        }

        public void render(Graphics g) {
            player.render(g);
        }

        public void focusLost() {
            player.stop();
        }

        public void keyPressed(int code) {
            if (code == KeyEvent.VK_ESCAPE) {
                player.stop();
                GameStateManager.getInstance().setState(GameState.PAUSED);
            } else {
                player.keyPressed(code);
            }
        }

        public void keyReleased(int code) {
            player.keyReleased(code);
        }
    };

    public void update() {
    }

    public abstract void render(Graphics g);

    public void keyPressed(int code) {
    }

    public void keyReleased(int code) {
    }

    public void focusLost() {
    }

    public void focusGained() {
    }
}
