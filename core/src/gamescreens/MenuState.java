package gamescreens;

import game.Game;
import game.GameKeys;
import game.GameStateManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;


public class MenuState extends GameState{

	private SpriteBatch batch;
	private BitmapFont font1;
	private BitmapFont font2;		
	
	public MenuState(){
		
		init();
		
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
	
		batch = new SpriteBatch();
		
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
		font1 = gen.generateFont(50);
		
		font2 = gen.generateFont(40);
		
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
		batch.setProjectionMatrix(Game.cam.combined);
		
		batch.begin();
		
			font1.draw(batch, "Line Shooter", 180, 400);
			
			font2.draw(batch, "Start", 300, 200);
			
		batch.end();
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
		if(GameKeys.isPressed(GameKeys.SHOOT_A)){
			
			Game.gsm.setState(GameStateManager.PLAY_STATE);
			
		}
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
