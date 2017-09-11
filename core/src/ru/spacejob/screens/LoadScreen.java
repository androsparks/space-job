package ru.spacejob.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.spacejob.SpaceJob;
import ru.spacejob.assets.Assets;

class LoadScreen implements Screen {

    private final SpaceJob game;

    private Viewport viewport;
    private OrthographicCamera camera;
    private SpriteBatch batch;

    private TextureRegion background;

    private Assets assets;

    LoadScreen(final SpaceJob game) {
        this.game = game;
        assets = game.getAssets();
    }

    @Override
    public void show() {
        batch = game.getSpriteBatch();

        camera = new OrthographicCamera();
        camera.position.set(game.getScreenWidth() / 2, game.getScreenHeight() / 2, 0);
        viewport = new FitViewport(game.getScreenWidth(), game.getScreenHeight(), camera);

        background = new TextureRegion(new Texture(Gdx.files.internal("textures/load_screen.png")));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(background, 0, 0, 0, 0, background.getRegionWidth(), background.getRegionHeight(), 2,  2, 0);
        batch.end();

        if (assets.isLoadingComplete()) {
            assets.create();
            ScreenManager.INSTANCE.showScreen(ScreenEnum.LEVEL_LIST);
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
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