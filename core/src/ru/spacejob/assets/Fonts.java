package ru.spacejob.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Fonts {

    private BitmapFont asapMedium24;

    public Fonts() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Asap-Medium.ttf"));
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.size = 24;
        asapMedium24 = generator.generateFont(parameter);
        generator.dispose();
    }

    public BitmapFont getAsapMedium24() {
        return asapMedium24;
    }

    public void dispose() {
        asapMedium24.dispose();
    }
}
