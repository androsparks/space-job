package ru.spacejob.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.spacejob.SpaceJob;
import ru.spacejob.assets.Fonts;

class PlayScreen implements Screen {

    private final SpaceJob game;

    private OrthographicCamera camera;

    PlayScreen(final SpaceJob game, boolean onePlayer, int level) {
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
        Fonts fonts = game.getFonts();

        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        fonts.getAsapMedium24().draw(batch, "PlayScreen of Space Job!!! ", 100, 150);
        batch.end();

        if (Gdx.input.isTouched()) {
            ScreenManager.INSTANCE.showScreen(ScreenEnum.COLOR_PICKER);
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