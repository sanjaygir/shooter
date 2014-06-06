package gamescreens;

import java.util.ArrayList;

import player.Player;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

import enemies.Enemy;
import enemies.SimpleLinearEnemyUnit;

import game.Game;
import game.GameKeys;


public class PlayState extends GameState{

	private ShapeRenderer sr;
	private Player player;
	private SimpleLinearEnemyUnit enemy;
	
	private  ArrayList<Enemy> enemies;
	
	private float spawn_time;
	private float spawn_timer;
	
	
	public PlayState(){
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
				
		enemies = new ArrayList<Enemy>();
				
		sr = new ShapeRenderer();
		player = new Player(this);
		
		spawn_time = 2;
		spawn_timer = 0;
		
		
		player.setSpeed(300);
		
		
	}
	
	
	public ArrayList<Enemy> getEnemies(){
		
		return this.enemies;
		
	}
	

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
		spawn_timer += dt;
		
		if(spawn_timer >= spawn_time){
			
			enemy = new SimpleLinearEnemyUnit();
			enemy.setSpeed(200);
			
			enemy.setX(1 + MathUtils.random(Game.GAME_WIDTH));
			enemy.setY(Game.GAME_HEIGHT + 10);
			
			enemies.add(enemy);
			
			
			spawn_timer = 0;
		}
		
		player.update(dt);

		
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
				
		player.draw(sr);
		
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
