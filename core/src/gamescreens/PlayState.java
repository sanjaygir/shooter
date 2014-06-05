package gamescreens;

import enemies.SimpleLinearEnemyUnit;
import game.Entity;
import game.Game;
import game.GameKeys;
import game.Player;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;


public class PlayState extends GameState{

	private ShapeRenderer sr;
	private Player player;
	private SimpleLinearEnemyUnit enemy;
	
	private ArrayList<Entity> enemies;
	
	
	
	public PlayState(){
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
				
		enemies = new ArrayList<Entity>();
				
		sr = new ShapeRenderer();
		player = new Player();
		
		player.setSpeed(300);
	
		for(int i=0;i<1000;i++){
		
			enemy = new SimpleLinearEnemyUnit();
			enemy.setSpeed(MathUtils.random(500) + 100);
			enemy.setX(1 + MathUtils.random(Game.GAME_WIDTH));
			enemy.setY(MathUtils.random(10000) + Game.GAME_HEIGHT);
			
			enemies.add(enemy);
					
			
		}
		
		
		
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
		player.update(dt);
		enemy.update(dt);
		
		for(int i=0;i<enemies.size();i++){
			enemies.get(i).update(dt);
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
