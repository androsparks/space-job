package ru.spacejob.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader.FreeTypeFontLoaderParameter;

public class Assets {

    public static Fonts fonts;
    public static Player player;

    private AssetManager assetManager;

    public Assets() {

        assetManager = new AssetManager();

        assetManager.load("textures/textures.atlas", TextureAtlas.class);

        FileHandleResolver resolver = new InternalFileHandleResolver();
        assetManager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        assetManager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
        assetManager.load(createFontDescriptor("fonts/Lato-Regular-32.ttf", 32, Color.WHITE, Color.BLACK, 1));
        assetManager.load(createFontDescriptor("fonts/Lato-Regular-64.ttf", 64, Color.WHITE, Color.BLACK, 1));
    }

    private AssetDescriptor createFontDescriptor(String fontPath, int fontSize, Color fontColor, Color borderColor, int borderSize) {
        FreeTypeFontLoaderParameter parameter = new FreeTypeFontLoaderParameter();
        parameter.fontFileName = fontPath;
        parameter.fontParameters.size = fontSize;
        parameter.fontParameters.color = fontColor;
        parameter.fontParameters.borderColor = borderColor;
        parameter.fontParameters.borderWidth = borderSize;
        return new AssetDescriptor<>(parameter.fontFileName, BitmapFont.class, parameter);
    }

    public boolean isLoadingComplete() {
        return assetManager.update();
    }

    public void create() {
        fonts = new Fonts();
        fonts.latoRegular32 = assetManager.get("fonts/Lato-Regular-32.ttf", BitmapFont.class);
        fonts.latoRegular64 = assetManager.get("fonts/Lato-Regular-64.ttf", BitmapFont.class);

        TextureAtlas atlas = assetManager.get("textures/textures.atlas", TextureAtlas.class);
        player = new Player(atlas);
    }

    public void dispose () {
        assetManager.dispose();
    }
}