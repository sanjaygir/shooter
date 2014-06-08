package game;

import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;

import enemies.CircleEnemyUnit;
import enemies.Enemy;
import enemies.SimpleLinearEnemyUnit;
import enemies.WallCrawler;
import gamescreens.PlayState;

public class EnemyUnitGenerator {

	private float spawn_timer;	
	
	private ArrayList<HittableEntity> enemies;
		
	
	private ArrayList<Float> generate_times;
	private ArrayList<Enemy> to_generate;
	
	
	
	public EnemyUnitGenerator(){
	
		
		generate_times = new ArrayList<Float>();
		to_generate = new ArrayList<Enemy>();
				
		spawn_timer = 0;
			
		enemies = PlayState.enemies;
				
		createUnits();
				
	}
	
	
	private void createUnits(){
		
		Enemy e1 = new WallCrawler(10, 400);
		generateAt(e1, 2f);
		
				
		Enemy e2 = new WallCrawler(10, 700);
		generateAt(e2, 4f);
					
		Enemy e3 = new WallCrawler(10, -100);
		generateAt(e3, 6f);
		
		
		Enemy e4 = new WallCrawler(790, 400);
		e4.setSpeed(100);
		generateAt(e4, 8f);
				


		for(int i=0;i<100;i++){
			CircleEnemyUnit en = new CircleEnemyUnit(100, Game.GAME_HEIGHT  + i*40);
			
			generateAt(en, i*0.1f);
			
		}
		
		for(int i=0; i< 100; i++){
			
			SimpleLinearEnemyUnit enemy = new SimpleLinearEnemyUnit(1 + MathUtils.random(Game.GAME_WIDTH), Game.GAME_HEIGHT + 10);
			enemy.setSpeed(200);
			
			generateAt(enemy, i*2f);
			
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
