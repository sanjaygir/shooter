package game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	
		
	private GameStateManager gsm;
	
	public static OrthographicCamera cam;
	
	
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	
	
	
	@Override
	public void create () {
			
		gsm = new GameStateManager();
		
		cam = new OrthographicCamera(GAME_WIDTH, GAME_HEIGHT);
		cam.translate(GAME_WIDTH/2, GAME_HEIGHT/2);
		cam.update();
		
		Gdx.input.setInputProcessor(new GameInputProcessor());
		
		Jukebox.load("laser2.wav", "shoot");
		Jukebox.load("explode2.wav", "explode");
			
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
		
		gsm.update(dt);
	}
	
	public void draw(){
		
		gsm.draw();
		
	}
	
	public void updatePrevKeysState(){
		
		GameKeys.updatePrevKeys();
	}
	
	
}
