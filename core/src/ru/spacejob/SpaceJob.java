package ru.spacejob;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.spacejob.assets.Fonts;
import ru.spacejob.screens.ScreenEnum;
import ru.spacejob.screens.ScreenManager;

public class SpaceJob extends Game {

	private int screenWidth;
	private int screenHeight;

	private SpriteBatch batch;
	private Fonts fonts;

	@Override
	public void create () {
		screenWidth = 768;
		screenHeight = screenWidth * Gdx.graphics.getHeight() / Gdx.graphics.getWidth();

		batch = new SpriteBatch();
		fonts = new Fonts();

		ScreenManager.INSTANCE.initialize(this);
		ScreenManager.INSTANCE.showScreen(ScreenEnum.LOADING);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fonts.dispose();
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	public SpriteBatch getSpriteBatch() {
		return batch;
	}

	public Fonts getFonts() {
		return fonts;
	}
}