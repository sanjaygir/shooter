package game;

import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;

import enemies.CircleEnemyUnit;
import enemies.CrossJumpEnemyUnit;
import enemies.Enemy;
import enemies.SimpleLinearEnemyUnit;
import enemies.TriangularPathEnemyUnit;
import enemies.TripleBulletEnemyUnit;
import enemies.WallCrawler;
import gamescreens.PlayState;

public class EnemyUnitGenerator {
	

	private float spawn_timer;	
	
	private ArrayList<Entity> enemies;
			
	private ArrayList<Float> generate_times;
	private ArrayList<Enemy> to_generate;
	
	
	
	private Enemy enemy;
	
	
	
	public EnemyUnitGenerator(){
	
		
		generate_times = new ArrayList<Float>();
		to_generate = new ArrayList<Enemy>();
				
		spawn_timer = 0;
			
		enemies = PlayState.enemies;
				
		createUnits();
				
	}
	
	
	private void createUnits(){
		
		for(int i=0;i<10;i++){
	
			enemy = new CrossJumpEnemyUnit(10, 700, CrossJumpEnemyUnit.CROSS_RIGHT);
			generateAt(enemy, 20f + i*0.3f);
					
		}
	
		for(int i=0;i<10;i++){
			
			enemy = new CrossJumpEnemyUnit(750, 700, CrossJumpEnemyUnit.CROSS_LEFT);
			generateAt(enemy, 20f + i*0.3f);
					
		}
		
		
		
		
		enemy = new TripleBulletEnemyUnit(10, 700);
		generateAt(enemy, 1f);
		
		enemy = new TripleBulletEnemyUnit(100, 700);
		generateAt(enemy, 3f);
		
		enemy = new TripleBulletEnemyUnit(200, 700);
		generateAt(enemy, 7f);
		
		
		enemy = new TripleBulletEnemyUnit(750, 700);
		((TripleBulletEnemyUnit)enemy).setFacingRight(false);
		generateAt(enemy, 10f);
						
		enemy = new WallCrawler(10, 400);
		generateAt(enemy, 2f);
		
				
		enemy = new WallCrawler(10, 700);
		generateAt(enemy, 4f);
					
		enemy = new WallCrawler(10, -100);
		generateAt(enemy, 6f);
		
		
		enemy = new WallCrawler(790, 400);
		enemy.setSpeed(100);
		generateAt(enemy, 8f);
			


		for(int i=0;i<100;i++){
			enemy = new CircleEnemyUnit(100, Game.GAME_HEIGHT  + i*40);
			generateAt(enemy, i*0.1f);
			
		}
		
		for(int i=0; i< 100; i++){
			
			enemy = new SimpleLinearEnemyUnit(1 + MathUtils.random(Game.GAME_WIDTH), Game.GAME_HEIGHT + 10);
			enemy.setSpeed(200);
			
			generateAt(enemy, i*2f);
			
		}
		
		
		for(int i=0; i<10; i++){
			
			enemy = new TriangularPathEnemyUnit(400, Game.GAME_HEIGHT + 10);
			enemy.setSpeed(300);
			generateAt(enemy, 10 + i*0.2f);
			
			
		}
		
	}
	
	
	public void generateAt(Enemy e, float f){
		
		to_generate.add(e);
		generate_times.add(f);
		
		
	}
	
	
	public void update(float dt){
		
		spawn_timer += dt;
		
		for(int i=0;i<generate_times.size();i++){
			
			if(generate_times.get(i) <= spawn_timer){
				enemies.add(to_generate.get(i));
				generate_times.remove(i);
				to_generate.remove(i);
				i--;
			}
			
		}
				
		
	}
	
	
}
