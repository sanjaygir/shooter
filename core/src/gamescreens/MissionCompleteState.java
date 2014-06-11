package gamescreens;

import game.Game;
import game.GameKeys;
import game.GameStateManager;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MissionCompleteState extends GameState{

	private SpriteBatch batch;
	private BitmapFont font;
			
	public MissionCompleteState(){
		
		init();
		
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
	
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		
		font.setScale(5);
		
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
		
			font.draw(batch, "Mission Complete!!", 100, 400);
			font.draw(batch, "You're Great!", 180, 200);
			
		batch.end();
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
		if(GameKeys.isPressed(GameKeys.SHOOT_A)){
			
			Game.gsm.setState(GameStateManager.GAME_OVER_STATE);
			
		}
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
