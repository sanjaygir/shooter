package game;

import java.util.ArrayList;

import enemies.CircleEnemyUnit;
import enemies.CrossJumpEnemyUnit;
import enemies.Enemy;
import enemies.MainBoss;
import enemies.SimpleLinearEnemyUnit;
import enemies.TriangularPathEnemyUnit;
import enemies.TripleBulletEnemyUnit;
import enemies.WallCrawler;
import enemies.weapons.TripleBulletAngularGun;
import gamescreens.PlayState;

public class EnemyUnitGenerator {
	
	
	private float spawn_timer;	
	
	private ArrayList<Entity> enemies;
			
	private ArrayList<Float> generate_times;
	private ArrayList<Entity> to_generate;
	
		
	private Enemy enemy;
	
	private float time;
	
	
	public EnemyUnitGenerator(){	
		
		generate_times = new ArrayList<Float>();
		to_generate = new ArrayList<Entity>();
				
		spawn_timer = 0;
			
		enemies = PlayState.enemies;
				
		createUnits();
				
	}
	
	
	
	/*
	 * 
	 * ENEMY
	 * 
	 * SimpleLinearEnemyUnit
	 * CrossJumpEnemyUnit
	 * TripleBulletEnemyUnit
	 * WallCrawler
	 * CircleEnemyUnit
	 * TriangularPathEnemyUnit
	 * 
	 * PowerCapsule 
	 */
		
	
	private void createUnits(){
	
		PowerCapsule p;
		
		
		time = 2;
		enemy = new SimpleLinearEnemyUnit(300, 700);
		enemy.setSpeed(200);
		generateAt(enemy, time);
				
		
		time += 3;
		enemy = new SimpleLinearEnemyUnit(100, 700);
		enemy.setSpeed(200);
		generateAt(enemy, time);
				
		enemy = new SimpleLinearEnemyUnit(400, 700);
		enemy.setSpeed(200);
		generateAt(enemy, time);
		
		
		time += 5;
		
		for(int i=0;i<3;i++){
			enemy = new SimpleLinearEnemyUnit(100 + i*100, 700);
			enemy.setSpeed(200);
			generateAt(enemy, time);
		}
		
		
		time += 5;
		
		p = new PowerCapsule(300, 700, WeaponTypes.DOUBLE_LINEAR_MISSILE_GUN);
		p.setSpeed(200);
		generateAt(p, time);
		
		
		time += 5;
		
		for(int i=0;i<6;i++){
			
			enemy = new SimpleLinearEnemyUnit(200 + 100*i, 700);
			enemy.setSpeed(100);
			generateAt(enemy, time);
		}
		
		
		time += 7;
		
		for(int i=0;i<7;i++){
			
			enemy = new SimpleLinearEnemyUnit(50 + 100*i, 700);
			enemy.setSpeed(100);
			generateAt(enemy, time);
		}
		
		
		
		
		time += 3;
		
		p = new PowerCapsule(300, 700, WeaponTypes.LASER_GUN);
		p.setSpeed(200);
		generateAt(p, time);
		
		
		
		time += 7;
		
		for(int i=0;i<7;i++){
			
			enemy = new SimpleLinearEnemyUnit(50 + 100*i, 700);
			enemy.setSpeed(100);
			generateAt(enemy, time);
		}		
		
		time += 1;
		
		for(int i=0;i<7;i++){
			
			enemy = new SimpleLinearEnemyUnit(50 + 100*i, 700);
			enemy.setSpeed(100);
			generateAt(enemy, time);
		}
		
		time += 10;
		
		for(int i=0;i<12;i++){
			
			enemy = new SimpleLinearEnemyUnit(200, 700 + i*40);
			enemy.setSpeed(300);
			generateAt(enemy, time);
		
		}
		
		
		time += 5;
				
		
		p = new PowerCapsule(300, 700, WeaponTypes.TRIPLE_BARREL_MACHINE_GUN);
		p.setSpeed(200);
		generateAt(p, time);
		
		
		
		time += 5;
				
		
		for(int i=0;i<5;i++){
					
			enemy = new SimpleLinearEnemyUnit(100 + i*100, 700 + i*40);
			enemy.setSpeed(200);
			generateAt(enemy, time);
		
			
		}
		
		time += 5;
		
		
		for(int i=5;i>=0;i--){
			
			enemy = new SimpleLinearEnemyUnit(100 + i*100, 700 + i*40);
			enemy.setSpeed(200);
			generateAt(enemy, time);
		
			
		}
		
		time += 5;

		
		for(int i=0;i<10;i++){
			
			enemy = new TriangularPathEnemyUnit(300, 700);
			enemy.setSpeed(200);
			generateAt(enemy, time);
			time += 0.3;
			
		}
		
		
		time += 5;
		

		enemy = new WallCrawler(10, 700,  WallCrawler.LEFT);
		((WallCrawler)enemy).setMovesVertical(true);
		enemy.setHP(1000);
		generateAt(enemy, time);
		
		time += 2;
		
		enemy = new WallCrawler(10, -10,  WallCrawler.LEFT);
		((WallCrawler)enemy).setMovesVertical(true);
		enemy.setHP(1000);
		generateAt(enemy, time);


		
		time += 5;
		
		p = new PowerCapsule(300, 700, WeaponTypes.FIVE_BARREL_MACHINE_GUN);
		p.setSpeed(200);
		generateAt(p, time);
				
		
		time += 5;
				

		for(int i=0;i<50;i++){
			enemy = new CircleEnemyUnit(100, Game.GAME_HEIGHT  + i*40);
			generateAt(enemy, time + i*0.1f);
			
		}
		
		
		
		time += 10;
		
		
		p = new PowerCapsule(300, 700, WeaponTypes.SINE_MACHINE_GUN);
		p.setSpeed(200);
		generateAt(p, time);
		
		
		time += 5;
		
		
		for(int i=0;i<10;i++){
			
			enemy = new TriangularPathEnemyUnit(200, 700);
			enemy.setSpeed(200);
			generateAt(enemy, time);
		
			enemy = new TriangularPathEnemyUnit(500, 700);
			enemy.setSpeed(200);
			generateAt(enemy, time);
		
			time += 0.3;
			
		}
		
		
		
		time += 10;
		
		
		p = new PowerCapsule(300, 700, WeaponTypes.ENEMY_CHASER_GUN);
		p.setSpeed(200);
		generateAt(p, time);
		
		
		
		time += 5;
		
		
		enemy = new WallCrawler(10, 700,  WallCrawler.LEFT);
		((WallCrawler)enemy).setMovesVertical(true);
		enemy.setHP(1000);
		generateAt(enemy, time);
		

		enemy = new WallCrawler(10, -20,  WallCrawler.LEFT);
		((WallCrawler)enemy).setMovesVertical(true);
		enemy.setHP(1000);
		generateAt(enemy, time);
		

		enemy = new WallCrawler(780, 700,  WallCrawler.RIGHT);
		((WallCrawler)enemy).setMovesVertical(true);
		enemy.setHP(1000);
		generateAt(enemy, time);
		

		enemy = new WallCrawler(780, -50,  WallCrawler.RIGHT);
		((WallCrawler)enemy).setMovesVertical(true);
		enemy.setHP(1000);
		generateAt(enemy, time);
		
		
		time += 10;
		

		
		for(int i=0;i<10;i++){
	
			enemy = new CrossJumpEnemyUnit(10, 700, CrossJumpEnemyUnit.CROSS_RIGHT);
			generateAt(enemy, time);
						
			enemy = new CrossJumpEnemyUnit(750, 700, CrossJumpEnemyUnit.CROSS_LEFT);
			generateAt(enemy, time);
			
			time += 0.2f;			
		}
	
		
		time += 5;
		
		
		p = new PowerCapsule(300, 700, WeaponTypes.DOUBLE_LASER_GUN);
		p.setSpeed(200);
		generateAt(p, time);
		
		
		time += 5;
		
				
		enemy = new TripleBulletEnemyUnit(10, 700);
		
		((TripleBulletEnemyUnit)enemy).setDirection(TripleBulletAngularGun.RIGHT);
				
		generateAt(enemy, time);
		
				
		
		time += 5;
		
		p = new PowerCapsule(300, 700, WeaponTypes.CROSS_MACHINE_GUN);
		p.setSpeed(200);
		generateAt(p, time);
		
		
		time += 3;
		
		
		enemy = new TripleBulletEnemyUnit(300, 700);
				
		generateAt(enemy, time);
		
		
		time += 3;
		
		

		p = new PowerCapsule(300, 700, WeaponTypes.TIME_BOMB_GUN);
		p.setSpeed(200);
		generateAt(p, time);
		
		
		time += 3;
		
		

		for(int i=0;i<10;i++){
			
			enemy = new TriangularPathEnemyUnit(200, 700);
			enemy.setSpeed(200);
			generateAt(enemy, time);
		
			enemy = new TriangularPathEnemyUnit(600, 700);
			enemy.setSpeed(200);
			generateAt(enemy, time);
		
			time += 0.3;
			
		}
		
				
		
		time += 10;
		enemy = new MainBoss(370, 550);
		enemy.setHP(20000);
		
		generateAt(enemy, time);
		
		
		enemy = new WallCrawler(750, 100,  WallCrawler.RIGHT);
		((WallCrawler)enemy).setMovesVertical(true);
		enemy.setHP(5000);
		enemy.setSpeed(150);
		
		
		generateAt(enemy, time);
		
		
		enemy = new WallCrawler(10, 100, WallCrawler.LEFT);
		((WallCrawler)enemy).setMovesVertical(true);
		enemy.setHP(5000);
		enemy.setSpeed(150);
		
		generateAt(enemy, time);
						
		
		enemy = new WallCrawler(10, 550,  WallCrawler.UP);
		((WallCrawler)enemy).setMovesVertical(false);
		enemy.setHP(5000);
		enemy.setSpeed(150);
		
		generateAt(enemy, time);
		
		enemy = new WallCrawler(10, 10, WallCrawler.DOWN);
		((WallCrawler)enemy).setMovesVertical(false);
		enemy.setHP(5000);
		enemy.setSpeed(150);
		
		generateAt(enemy, time);
		
		
		
	}
	
	
	public void generateAt(Entity e, float f){
		
		to_generate.add(e);
		generate_times.add(f);
		
		
	}
	
	
	public void update(float dt){
		
		spawn_timer += dt;
		
		for(int i=0;i<generate_times.size();i++){
			
			if(generate_times.get(i) <= spawn_timer){
				
				if(to_generate.get(i) instanceof PowerCapsule){
					PlayState.capsules.add((PowerCapsule)to_generate.get(i));
					generate_times.remove(i);
					to_generate.remove(i);
					i--;
					
				}
				else{
					
					PlayState.enemies.add(to_generate.get(i));
					generate_times.remove(i);
					to_generate.remove(i);
					i--;
					
				}
				
				
			}
			
		}
				
		
	}
	
	
}
