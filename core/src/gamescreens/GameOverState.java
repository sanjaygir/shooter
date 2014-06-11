package gamescreens;

import game.Game;
import game.GameKeys;
import game.GameStateManager;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameOverState extends GameState{

	private SpriteBatch batch;
	private BitmapFont font;
		
	private int kills;
	private String kills_str;
	
	
	public GameOverState(){
		
		init();
		
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
	
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		
		font.setScale(5);
		
		kills = PlayState.total_kills;
		
		
		kills_str = Integer.toString(kills);
		
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
		
			font.draw(batch, "Total Kills", 200, 400);
			font.draw(batch, kills_str, 310, 200);
			
		batch.end();
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
		if(GameKeys.isPressed(GameKeys.SHOOT_A)){
			
			Game.gsm.setState(GameStateManager.MENU_STATE);
			
		}
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
