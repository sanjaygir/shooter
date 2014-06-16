package game;

import java.util.ArrayList;

import enemies.CircleEnemyUnit;
import enemies.MarchAndThrowEnemyUnit;
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
	
	private PowerCapsule p;
	
	
	
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
		

		
		
		time = 2;
		enemy = new SimpleLinearEnemyUnit(300, 700);
		enemy.setSpeed(250);
		generateAt(enemy, time);
						
		time += 3;
		enemy = new SimpleLinearEnemyUnit(100, 700);
		enemy.setSpeed(250);
		generateAt(enemy, time);
				
		enemy = new SimpleLinearEnemyUnit(300, 700);
		enemy.setSpeed(200);
		generateAt(enemy, time);
				
				
		time += 3;
		
		p = new PowerCapsule(300, 700, WeaponTypes.DOUBLE_LINEAR_MISSILE_GUN);
		p.setSpeed(250);
		generateAt(p, time);
		
		time += 3;
		
		for(int i=0;i<10;i++){
			
			if(i % 2 == 0){
				enemy = new SimpleLinearEnemyUnit(50 + i*70, 700);
				enemy.setSpeed(250);
				
			}
			else
			{
				enemy = new SimpleLinearEnemyUnit(50 + i*70, 700);
				enemy.setSpeed(200);
				
			}
						
			generateAt(enemy, time);
		}
		
		
		time += 3;
		
		
		p  = new PowerCapsule(400, 700, WeaponTypes.TRIPLE_BARREL_MACHINE_GUN);
		p.setSpeed(250);
		generateAt(p, time);
		
		
		time += 3;
		
		for(int i=0;i<10;i++){
			
			enemy = new TriangularPathEnemyUnit(350, 700);		
			enemy.setSpeed(300);
			generateAt(enemy, time);
			time += 0.2;
		}
		
		time += 3;
		
		p = new PowerCapsule(200, 700, WeaponTypes.LASER_GUN);
		p.setSpeed(250);
		generateAt(p, time);
		
		time += 3;
		
		for(int i=0;i<10;i++){
			
			enemy = new CircleEnemyUnit(100, 700);
			((CircleEnemyUnit)enemy).setAngleAmount(1);
			((CircleEnemyUnit)enemy).setTurnDistance(250);
			generateAt(enemy, time);
			
						
			time += 0.1;			
		}
		
		
		time += 3;
		
		p = new PowerCapsule(500, 700, WeaponTypes.CROSS_MACHINE_GUN);
		p.setSpeed(250);
		generateAt(p, time);
		
		time += 3;
		
		for(int i=0; i<10;i++){
			enemy = new SimpleLinearEnemyUnit(100, 700);
			enemy.setSpeed(250);
			generateAt(enemy, time);
			
			
			enemy = new SimpleLinearEnemyUnit(400, 700);
			enemy.setSpeed(200);
			generateAt(enemy, time);
			
			
			enemy = new SimpleLinearEnemyUnit(700, 700);
			enemy.setSpeed(250);
			generateAt(enemy, time);
			
			
			time += 0.1;
			
		}
		
		
		time += 3;
		
		
		p = new PowerCapsule(200, 700, WeaponTypes.SINE_MACHINE_GUN);
		p.setSpeed(250);
		generateAt(p, time);
		
		time += 3;
		
		

		
		for(int i=0; i<10;i++){
			enemy = new TriangularPathEnemyUnit(200, 700);
			enemy.setSpeed(200);
			generateAt(enemy, time);
			
			
			enemy = new TriangularPathEnemyUnit(400, 700);
			enemy.setSpeed(200);
			generateAt(enemy, time);
			
			
			enemy = new TriangularPathEnemyUnit(600, 700);
			enemy.setSpeed(200);
			generateAt(enemy, time);
						
			time += 0.2;
			
		}
		
		
		time += 3;
		
		
		p = new PowerCapsule(200, 700, WeaponTypes.DOUBLE_LASER_GUN);
		p.setSpeed(250);
		generateAt(p, time);
		
		time += 3;
		
				

		for(int i=0;i<10;i++){
			
			enemy = new SimpleLinearEnemyUnit(50 + i*70, 700);
			enemy.setSpeed(250);
							
			generateAt(enemy, time);
				
			enemy = new SimpleLinearEnemyUnit(50 + i*70, 750);
			enemy.setSpeed(250);
			
			generateAt(enemy, time);
			
			time += 0.4;
		}
		
		
		
		time += 3;
		

		p = new PowerCapsule(400, 700, WeaponTypes.ENEMY_CHASER_GUN);
		p.setSpeed(250);
		generateAt(p, time);
		
		time += 3;
		
		
		enemy = new WallCrawler(WallCrawler.SIT_LEFT, WallCrawler.ENTRY_FROM_DOWN);
		generateAt(enemy, time);
		
		
		time += 1;
		
		enemy = new WallCrawler(WallCrawler.SIT_RIGHT, WallCrawler.ENTRY_FROM_UP);
		generateAt(enemy, time);
		
		
		time += 3;
						
		
		p = new PowerCapsule(400, 700, WeaponTypes.TIME_BOMB_GUN);
		p.setSpeed(250);
		generateAt(p, time);
		
		time += 3;
		
		

		for(int i=0;i<20;i++){
			
			enemy = new SimpleLinearEnemyUnit(50 + i*70, 700);
			enemy.setSpeed(250);
							
			generateAt(enemy, time);
				
			enemy = new SimpleLinearEnemyUnit(50 + i*70, 750);
			enemy.setSpeed(250);
			
			generateAt(enemy, time);
			
			time += 0.4;
		}
		
		
		time += 3;
		

		p = new PowerCapsule(400, 700, WeaponTypes.FIVE_BARREL_MACHINE_GUN);
		p.setSpeed(250);
		generateAt(p, time);
		
		time += 3;
		
		enemy = new TripleBulletEnemyUnit(300, 700);
		((TripleBulletEnemyUnit)enemy).setShootDirection(TripleBulletEnemyUnit.DOWN);
		generateAt(enemy, time);
		
		
		time += 3;
		
		
		

		
		
			
	////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////BOSS//////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
		
		time += 10;
		enemy = new MainBoss(370, 550);
		enemy.setHP(20000);
		
		generateAt(enemy, time);
		
		
		enemy = new WallCrawler(WallCrawler.SIT_RIGHT, WallCrawler.ENTRY_FROM_DOWN);
		enemy.setHP(5000);
		enemy.setSpeed(150);
		
		
		generateAt(enemy, time);
		
		
		enemy = new WallCrawler(WallCrawler.SIT_LEFT, WallCrawler.ENTRY_FROM_UP);
		enemy.setHP(5000);
		enemy.setSpeed(150);
		
		generateAt(enemy, time);
						
		
		enemy = new WallCrawler(WallCrawler.SIT_UP, WallCrawler.ENTRY_FROM_LEFT);
		enemy.setHP(5000);
		enemy.setSpeed(150);
		
		
		
		generateAt(enemy, time);
		
		enemy = new WallCrawler(WallCrawler.SIT_DOWN, WallCrawler.ENTRY_FROM_LEFT);
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
