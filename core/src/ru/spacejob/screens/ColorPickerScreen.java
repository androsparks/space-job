package ru.spacejob.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.spacejob.SpaceJob;
import ru.spacejob.assets.Assets;
import ru.spacejob.assets.Fonts;

class ColorPickerScreen implements Screen {

    private final SpaceJob game;

    private OrthographicCamera camera;

    ColorPickerScreen(final SpaceJob game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, game.getScreenWidth(), game.getScreenHeight());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        camera.update();

        SpriteBatch batch = game.getSpriteBatch();

        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        Assets.fonts.latoRegular32.draw(batch, "ColorPickerScreen of Space Job!!! ", 100, 150);
        batch.end();

        if (Gdx.input.isTouched()) {
            ScreenManager.INSTANCE.showScreen(ScreenEnum.LOADING);
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}