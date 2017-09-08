package ru.spacejob.screens;

import com.badlogic.gdx.Screen;

import ru.spacejob.SpaceJob;

public enum ScreenEnum {

    LOADING {
        public Screen getScreen(SpaceJob game, Object... params) {
            return new LoadScreen(game);
        }
    },
    LEVEL_LIST {
        public Screen getScreen(SpaceJob game, Object... params) {
            return new LevelListScreen(game);
        }
    },
    COLOR_PICKER {
        public Screen getScreen(SpaceJob game, Object... params) {
            return new ColorPickerScreen(game);
        }
    },
    PLAY {
        public Screen getScreen(SpaceJob game, Object... params) {
            return new PlayScreen(game, (Boolean) params[0], (Integer) params[1]);
        }
    };

    public abstract Screen getScreen(SpaceJob game, Object... params);
}