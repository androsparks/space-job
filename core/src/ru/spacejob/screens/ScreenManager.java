package ru.spacejob.screens;

import com.badlogic.gdx.Screen;
import ru.spacejob.SpaceJob;

public enum ScreenManager {
    INSTANCE;

    private SpaceJob game;

    public void initialize(SpaceJob game) {
        this.game = game;
    }

    public void showScreen(ScreenEnum screenEnum, Object... params) {

        // Get current screen to dispose it
        Screen currentScreen = game.getScreen();

        // Show new screen
        Screen newScreen = screenEnum.getScreen(game, params);
        game.setScreen(newScreen);

        // Dispose previous screen
        if (currentScreen != null) {
            currentScreen.dispose();
        }
    }

    public Screen getCurrentScreen() {
        return game.getScreen();
    }
}