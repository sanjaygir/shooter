package gamescreens;

import game.EnemyUnitGenerator;
import game.Entity;
import game.Game;
import game.GameKeys;

import java.util.ArrayList;

import player.Player;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class PlayState extends GameState{

	private ShapeRenderer sr;
		
	public static  ArrayList<Entity> enemies;
	public static  ArrayList<Entity> players;
	private EnemyUnitGenerator generator;
	
	public static Player player;
	
	
	public PlayState(){
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
				
		enemies = new ArrayList<Entity>();
		players = new ArrayList<Entity>();
		
		generator = new EnemyUnitGenerator();
		
		
		sr = new ShapeRenderer();
			
		player = new Player(300, 10, this);
		player.setHP(1);
		player.setSpeed(300);
		players.add(player);		
				
		
	}
	
	
	

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
		
		generator.update(dt);
		
		
		if(!player.remove){
			player.update(dt);
		}
		
		
		for(int i=0;i<enemies.size();i++){
		
			if(enemies.get(i).remove){
				
				enemies.remove(i);
				i--;				
			}
			else{
				enemies.get(i).update(dt);
				
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
