package gamescreens;

import enemies.MainBoss;
import game.EnemyUnitGenerator;
import game.Entity;
import game.Game;
import game.GameKeys;
import game.GameStateManager;
import game.PowerCapsule;

import java.util.ArrayList;

import player.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;


public class PlayState extends GameState{

	private ShapeRenderer sr;
	
		
	public static  ArrayList<Entity> enemies;
	public static  ArrayList<Entity> players;
	public static ArrayList<PowerCapsule> capsules;
	
	private SpriteBatch batch;
	private BitmapFont font1;
	
	
	private EnemyUnitGenerator generator;
	
	public static Player player;
	
	public static int total_kills;
	
	
	
	public PlayState(){
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
				
		
				
		batch = new SpriteBatch();
		
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
		font1 = gen.generateFont(15);
		
		
		enemies = new ArrayList<Entity>();
		players = new ArrayList<Entity>();
		capsules = new ArrayList<PowerCapsule>();
		
		
		generator = new EnemyUnitGenerator();
		
		total_kills = 0;
		
		
		sr = new ShapeRenderer();
			
		player = new Player(300, 10, this);
		player.setHP(1);
		player.setSpeed(300);
		players.add(player);		
				
		
	}
	
	
	

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
				
		if(player.lives < 0){
			Game.gsm.setState(GameStateManager.GAME_OVER_STATE);
		}
		
		generator.update(dt);
		
		
		if(!player.remove){
			player.update(dt);
		}
		
		
		for(int i=0;i<enemies.size();i++){
		
			if(enemies.get(i).remove){
				

				if(enemies.get(i) instanceof MainBoss){
					
					Game.gsm.setState(GameStateManager.MISSION_COMPLETE_STATE);
											
				}
					
				enemies.remove(i);
				i--;				
				
			}
			else{
				enemies.get(i).update(dt);
				
			}
			
			
		}
		
		
		
		for(int i=0;i<capsules.size();i++){
			
		
			if(capsules.get(i).remove){
				
				capsules.remove(i);
				i--;				
			}
			else{
				capsules.get(i).update(dt);
				
			}
			
			
		}
		
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
		sr.setProjectionMatrix(Game.cam.combined);
			
		
		if(!player.remove){
			player.draw(sr);
		}
		
		for(int i=0;i<enemies.size();i++){
			enemies.get(i).draw(sr);
		}
		
		for(int i=0;i<capsules.size();i++){
			capsules.get(i).draw(sr);
		}
		
		
		batch.setProjectionMatrix(Game.cam.combined);
		
		batch.begin();
		
			font1.draw(batch, "LIVES", 10, 590);
						
		batch.end();
		
		sr.begin(ShapeType.Line);
			
			for(int i=0;i<player.lives;i++){
				
				sr.line(10 + i*10, 560, 10 + i*10, 570);
				
			}
		
		sr.end();
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
			
			player.setDown(GameKeys.getState(GameKeys.DOWN));
			player.setUp(GameKeys.getState(GameKeys.UP));
			player.setLeft(GameKeys.getState(GameKeys.LEFT));
			player.setRight(GameKeys.getState(GameKeys.RIGHT));
			player.setShootA(GameKeys.getState(GameKeys.SHOOT_A));
			player.setShootB(GameKeys.getState(GameKeys.SHOOT_B));
		
		
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
