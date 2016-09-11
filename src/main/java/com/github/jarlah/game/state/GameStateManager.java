package com.github.jarlah.game.state;

import com.github.jarlah.game.Resolution;

import java.awt.*;

public class GameStateManager {
    private static GameStateManager instance;

    private GameState state;

    private GameStateManager() {
        setState(GameState.MENU);
    }

    public static GameStateManager getInstance() {
        if (instance == null) {
            instance = new GameStateManager();
        }
        return instance;
    }

    public void update() {
        state.update();
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Resolution.PIXEL_WIDTH, Resolution.PIXEL_HEIGHT);
        state.render(g);
    }

    public void keyPressed(int code) {
        state.keyPressed(code);
    }

    public void keyReleased(int code) {
        state.keyReleased(code);
    }

    public void focusLost() {
        state.focusLost();
    }

    public void focusGained() {
        state.focusGained();
    }

    public void setState(GameState newState) {
        state = newState;
    }
}
