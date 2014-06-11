package gamescreens;

import game.Game;
import game.GameKeys;
import game.GameStateManager;
import game.Save;
import game.Score;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameOverState extends GameState{

	private SpriteBatch batch;
	private BitmapFont font;
		
	private int kills;
	private String kills_str;
	private String kills_str2;
	
	
	
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
		
		
		if(kills > Save.load()){
			Save.save(new Score(kills));
		}
		
		
		
		kills_str = Integer.toString(Save.load());
		kills_str2 = Integer.toString(kills);
		
		
		
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
		
			font.draw(batch, "Best Kills", 200, 400+100);
			font.draw(batch, kills_str, 310, 420);
			
			font.draw(batch, "Current Kills", 160, 300);
			font.draw(batch, kills_str2, 310, 220);
			
			
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
