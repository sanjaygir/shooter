package game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Game extends ApplicationAdapter {
			
	public static  GameStateManager gsm;
	
	public static OrthographicCamera cam;
		
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	
	public static final float FRAME_TIME = 1f/60f;
		
	public static ObjectInputStream ois;
	public static ObjectOutputStream oos;
	
	
	@Override
	public void create () {
			
		
		gsm = new GameStateManager();
		
		cam = new OrthographicCamera(GAME_WIDTH, GAME_HEIGHT);
		cam.translate(GAME_WIDTH/2, GAME_HEIGHT/2);
		cam.update();
		
		Gdx.input.setInputProcessor(new GameInputProcessor());
		
		if(!Save.saveFileExists()){
			Save.save(new Score(0));
		}
				
		
		//LevelLoader l = new LevelLoader("map.txt");
				
			
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		handleInput();
		update(Gdx.graphics.getDeltaTime());
		draw();		
		updatePrevKeysState();
		
	}
	
		
	public void handleInput(){
		
		gsm.handleInput();
		
	}
	
	public void update(float dt){
		
			gsm.update(FRAME_TIME);
	}
	
	public void draw(){
		
		gsm.draw();
		
	}
	
	public void updatePrevKeysState(){
		
		GameKeys.updatePrevKeys();
	}
	
	
}
