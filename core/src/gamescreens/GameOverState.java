package gamescreens;

import game.Game;
import game.GameKeys;
import game.GameStateManager;
import game.Save;
import game.Score;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;


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
		
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
		font = gen.generateFont(50);
		
		
		kills = PlayState.total_kills;
		
		
		if(kills > Save.load()){
			Save.save(new Score(kills));
		}
		
		
		
		kills_str = Integer.toString(Save.load());
		kills_str2 = Integer.toString(kills);
		
		System.out.println(kills_str);
		System.out.println(kills_str2);
		
		
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
			font.draw(batch, kills_str, 320, 420);
			
			font.draw(batch, "Current Kills", 160, 300);
			font.draw(batch, kills_str2, 320, 220);
			
			
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
