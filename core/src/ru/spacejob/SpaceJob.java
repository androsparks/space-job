package ru.spacejob;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

import ru.spacejob.assets.Assets;
import ru.spacejob.screens.ScreenEnum;
import ru.spacejob.screens.ScreenManager;

public class SpaceJob extends Game {

	private int screenWidth;
	private int screenHeight;

	private SpriteBatch batch;
	private Assets assets;

	@Override
	public void create () {

		TexturePacker.Settings settings = new TexturePacker.Settings();
		settings.maxWidth = 4096;
		settings.maxHeight = 2048;
		TexturePacker.process(settings, "sprite_source", "textures", "textures");

		screenWidth = 768;
		screenHeight = screenWidth * Gdx.graphics.getHeight() / Gdx.graphics.getWidth();

		batch = new SpriteBatch();
		assets = new Assets();

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
		assets.dispose();
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

	public Assets getAssets() {
		return assets;
	}

}