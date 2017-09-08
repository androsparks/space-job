package ru.spacejob.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.spacejob.SpaceJob;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "my-gdx-game";
		config.useGL30 = true;
		config.width = 768;
		config.height = 320;

		new LwjglApplication(new SpaceJob(), config);
	}
}
