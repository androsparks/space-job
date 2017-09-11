package ru.spacejob.assets;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player {

    public TextureRegion body;
    public TextureRegion bodyTop;
    public TextureRegion indicator;
    public TextureRegion glass;
    public TextureRegion soot;

    public Player(TextureAtlas atlas) {
        body = new TextureRegion(atlas.findRegion("player"), 0, 0, 64, 128);
        bodyTop = new TextureRegion(atlas.findRegion("player"), 64, 0, 64, 128);
        indicator = new TextureRegion(atlas.findRegion("player"), 128, 0, 64, 128);
        glass = new TextureRegion(atlas.findRegion("player"), 192, 0, 64, 128);
        soot = new TextureRegion(atlas.findRegion("player"), 256, 0, 64, 128);
    }
}
