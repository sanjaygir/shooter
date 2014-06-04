package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		
		//Main entry point
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "SHOOTER";
		config.width = 800;
		config.height = 600;
		config.resizable = false;
		
		new LwjglApplication(new Game(), config);
		
		
	}
}
