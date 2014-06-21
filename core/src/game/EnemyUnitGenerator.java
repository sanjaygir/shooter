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
	
	private LevelLoader level_loader;
	
	
	private ArrayList<ToGenerateToken> tokens_to_generate;
	
		
	public EnemyUnitGenerator(){	
		
		level_loader = new LevelLoader("level1.txt");
		tokens_to_generate = level_loader.getToGenerateTokens();
		
		
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
		
		for(int i=0;i<tokens_to_generate.size();i++){
			
			ToGenerateToken token = tokens_to_generate.get(i);
			
			switch(token.type){
			
				
			case ToGenerateTokenTypes.SL:
				
				time += token.time_delay;
								
				enemy = new SimpleLinearEnemyUnit(token.x, token.y);
				enemy.setWidth(token.width);
				enemy.setHeight(token.height);
				enemy.setSpeed(token.speed);
				enemy.setHP(token.hp);
								
				generateAt(enemy, time);
				
				break;

			case ToGenerateTokenTypes.SLG:

				time += token.time_delay;
				
				
				for(int j=0;j<token.num_units;j++){
				
					enemy = new SimpleLinearEnemyUnit(token.x, token.y);
					enemy.setWidth(token.width);
					enemy.setHeight(token.height);
					enemy.setSpeed(token.speed);
					enemy.setHP(token.hp);

					generateAt(enemy, time);
					
					
					time += token.time_between_units;
									
					
				}		

				
				break;

			case ToGenerateTokenTypes.C:
				
				
				time += token.time_delay;
				
				enemy = new CircleEnemyUnit(token.x, token.y);
				enemy.setWidth(token.width);
				enemy.setHeight(token.height);
				enemy.setSpeed(token.speed);
				enemy.setHP(token.hp);
				
				((CircleEnemyUnit)enemy).setInitialAngle(token.init_angle);
				((CircleEnemyUnit)enemy).setAngleAmount(token.angle_turn_amount);
				((CircleEnemyUnit)enemy).setTurnStartTime(token.turn_start_time);
				((CircleEnemyUnit)enemy).setTurnStopAngle(token.turn_stop_angle);
												
				generateAt(enemy, time);
				
				break;

			case ToGenerateTokenTypes.CG:

				time += token.time_delay;

				for(int j=0;j<token.num_units;j++){

					enemy = new CircleEnemyUnit(token.x, token.y);
					enemy.setWidth(token.width);
					enemy.setHeight(token.height);
					enemy.setSpeed(token.speed);
					enemy.setHP(token.hp);
					
					((CircleEnemyUnit)enemy).setInitialAngle(token.init_angle);
					((CircleEnemyUnit)enemy).setAngleAmount(token.angle_turn_amount);
					((CircleEnemyUnit)enemy).setTurnStartTime(token.turn_start_time);
					((CircleEnemyUnit)enemy).setTurnStopAngle(token.turn_stop_angle);
													
					generateAt(enemy, time);
					
					time += token.time_between_units;

				}
				
				break;

				
				
			case ToGenerateTokenTypes.MAT:

				time += token.time_delay;
				
				enemy = new MarchAndThrowEnemyUnit(token.x, token.y);
				enemy.setWidth(token.width);
				enemy.setHeight(token.height);
				enemy.setSpeed(token.speed);
				enemy.setHP(token.hp);
				
				((MarchAndThrowEnemyUnit)enemy).setMarchAngle(token.march_angle);
				((MarchAndThrowEnemyUnit)enemy).setTransitionTime(token.transition_time);
				((MarchAndThrowEnemyUnit)enemy).setGravity(token.gravity);
				((MarchAndThrowEnemyUnit)enemy).setJumpVelocity(token.jump_velocity);
				((MarchAndThrowEnemyUnit)enemy).setJumpAngle(token.jump_angle);
				
												
				generateAt(enemy, time);
				
				break;

			case ToGenerateTokenTypes.MATG:


				time += token.time_delay;
				
				for(int j=0;j<token.num_units;j++){
				
					enemy = new MarchAndThrowEnemyUnit(token.x, token.y);
					enemy.setWidth(token.width);
					enemy.setHeight(token.height);
					enemy.setSpeed(token.speed);
					enemy.setHP(token.hp);
					
					((MarchAndThrowEnemyUnit)enemy).setMarchAngle(token.march_angle);
					((MarchAndThrowEnemyUnit)enemy).setTransitionTime(token.transition_time);
					((MarchAndThrowEnemyUnit)enemy).setGravity(token.gravity);
					((MarchAndThrowEnemyUnit)enemy).setJumpVelocity(token.jump_velocity);
					((MarchAndThrowEnemyUnit)enemy).setJumpAngle(token.jump_angle);
					
													
					generateAt(enemy, time);
					
					
					time += token.time_between_units;
					
				}
				
				
				break;

			case ToGenerateTokenTypes.TB:
				
				time += token.time_delay;
				
				enemy = new TripleBulletEnemyUnit(token.x, token.y);
				enemy.setWidth(token.width);
				enemy.setHeight(token.height);
				enemy.setSpeed(token.speed);
				enemy.setHP(token.hp);
				
				((TripleBulletEnemyUnit)enemy).setShootTime(token.shoot_interval);
				
				if(token.shoot_direction.equals("DOWN")){
				
					((TripleBulletEnemyUnit)enemy).setShootDirection(TripleBulletEnemyUnit.DOWN);
					
					
				}
				else if(token.shoot_direction.equals("LEFT")){
					
					((TripleBulletEnemyUnit)enemy).setShootDirection(TripleBulletEnemyUnit.LEFT);
					
				}
				else if(token.shoot_direction.equals("RIGHT")){
					
					((TripleBulletEnemyUnit)enemy).setShootDirection(TripleBulletEnemyUnit.RIGHT);
					
					
				}
				else if(token.shoot_direction.equals("RIGHT_DOWN")){
					
					((TripleBulletEnemyUnit)enemy).setShootDirection(TripleBulletEnemyUnit.RIGHT_DOWN);
					
					
				}
				else if(token.shoot_direction.equals("LEFT_DOWN")){
					
					((TripleBulletEnemyUnit)enemy).setShootDirection(TripleBulletEnemyUnit.LEFT_DOWN);
					
					
				}

							
												
				generateAt(enemy, time);
				
				break;

			case ToGenerateTokenTypes.TBG:

				
				
				time += token.time_delay;
				
				for(int j=0;j<token.num_units;j++){
					
					enemy = new TripleBulletEnemyUnit(token.x, token.y);
					enemy.setWidth(token.width);
					enemy.setHeight(token.height);
					enemy.setSpeed(token.speed);
					enemy.setHP(token.hp);
					
					((TripleBulletEnemyUnit)enemy).setShootTime(token.shoot_interval);
					
					if(token.shoot_direction.equals("DOWN")){
					
						((TripleBulletEnemyUnit)enemy).setShootDirection(TripleBulletEnemyUnit.DOWN);
						
						
					}
					else if(token.shoot_direction.equals("LEFT")){
						
						((TripleBulletEnemyUnit)enemy).setShootDirection(TripleBulletEnemyUnit.LEFT);
						
					}
					else if(token.shoot_direction.equals("RIGHT")){
						
						((TripleBulletEnemyUnit)enemy).setShootDirection(TripleBulletEnemyUnit.RIGHT);
						
						
					}
					else if(token.shoot_direction.equals("RIGHT_DOWN")){
						
						((TripleBulletEnemyUnit)enemy).setShootDirection(TripleBulletEnemyUnit.RIGHT_DOWN);
						
						
					}
					else if(token.shoot_direction.equals("LEFT_DOWN")){
						
						((TripleBulletEnemyUnit)enemy).setShootDirection(TripleBulletEnemyUnit.LEFT_DOWN);
						
						
					}
	
								
													
					generateAt(enemy, time);
					
					
					time += token.time_between_units;
					
				}
				

								
				break;

				
			case ToGenerateTokenTypes.TP:
				
				time += token.time_delay;
				
				enemy = new TriangularPathEnemyUnit(token.x, token.y);
				enemy.setWidth(token.width);
				enemy.setHeight(token.height);
				enemy.setSpeed(token.speed);
				enemy.setHP(token.hp);
				
				((TriangularPathEnemyUnit)enemy).setInitialDirection(token.init_direction);
				((TriangularPathEnemyUnit)enemy).setChangePathTime(token.path_change_time);
				((TriangularPathEnemyUnit)enemy).setTurnAngle(token.turn_angle);
				
												
				generateAt(enemy, time);
				
				
				
				break;

			case ToGenerateTokenTypes.TPG:
				
				time += token.time_delay;
				
				for(int j=0;j<token.num_units;j++){
				
					enemy = new TriangularPathEnemyUnit(token.x, token.y);
					enemy.setWidth(token.width);
					enemy.setHeight(token.height);
					enemy.setSpeed(token.speed);
					enemy.setHP(token.hp);
					
					((TriangularPathEnemyUnit)enemy).setInitialDirection(token.init_direction);
					((TriangularPathEnemyUnit)enemy).setChangePathTime(token.path_change_time);
					((TriangularPathEnemyUnit)enemy).setTurnAngle(token.turn_angle);
					
													
					generateAt(enemy, time);
					
					
					time += token.time_between_units;
					
				}
				
				
				break;

			case ToGenerateTokenTypes.B:
				
				time += token.time_delay;
				
				createBoss();
				
				
				break;

			case ToGenerateTokenTypes.WC:
				
				time += token.time_delay;
				
				int place = 0;
				int enter_from = 0;
				
				if(token.place.equals("UP")){
					place = WallCrawler.SIT_UP;
				}
				else if(token.place.equals("DOWN")){
					place = WallCrawler.SIT_DOWN;
				}
				else if(token.place.equals("LEFT")){
					place = WallCrawler.SIT_LEFT;
				}
				else if(token.place.equals("RIGHT")){
					place = WallCrawler.SIT_RIGHT;
				}
				
								
				enemy = new WallCrawler(place, enter_from);
				enemy.setWidth(token.width);
				enemy.setHeight(token.height);
				enemy.setSpeed(token.speed);
				enemy.setHP(token.hp);
				
												
				generateAt(enemy, time);
				

				break;

				
			case ToGenerateTokenTypes.P_SBMG:
				
				time += token.time_delay;
				
				p = new PowerCapsule(token.x, token.y, WeaponTypes.SINGLE_BARREL_MACHINE_GUN);
				p.setWidth(token.width);
				p.setHeight(token.height);
				p.setSpeed(token.speed);
				
				generateAt(p, time);
				
				break;

			case ToGenerateTokenTypes.P_CMG:

				time += token.time_delay;
				
				p = new PowerCapsule(token.x, token.y, WeaponTypes.CROSS_MACHINE_GUN);
				p.setWidth(token.width);
				p.setHeight(token.height);
				p.setSpeed(token.speed);
				
				generateAt(p, time);
				
				break;

			case ToGenerateTokenTypes.P_ECG:
				time += token.time_delay;
				
				p = new PowerCapsule(token.x, token.y, WeaponTypes.ENEMY_CHASER_GUN);
				p.setWidth(token.width);
				p.setHeight(token.height);
				p.setSpeed(token.speed);
				
				generateAt(p, time);

				
				break;

			case ToGenerateTokenTypes.P_DLMG:
				time += token.time_delay;
				
				p = new PowerCapsule(token.x, token.y, WeaponTypes.DOUBLE_LINEAR_MISSILE_GUN);
				p.setWidth(token.width);
				p.setHeight(token.height);
				p.setSpeed(token.speed);
				
				generateAt(p, time);

				
				break;

			case ToGenerateTokenTypes.P_TBMG:

				time += token.time_delay;
				
				p = new PowerCapsule(token.x, token.y, WeaponTypes.TRIPLE_BARREL_MACHINE_GUN);
				p.setWidth(token.width);
				p.setHeight(token.height);
				p.setSpeed(token.speed);
				
				generateAt(p, time);
				
				break;

			case ToGenerateTokenTypes.P_FBMG:

				time += token.time_delay;
				
				p = new PowerCapsule(token.x, token.y, WeaponTypes.FIVE_BARREL_MACHINE_GUN);
				p.setWidth(token.width);
				p.setHeight(token.height);
				p.setSpeed(token.speed);
				
				generateAt(p, time);
				
				break;

			case ToGenerateTokenTypes.P_TBG:

				time += token.time_delay;
				
				p = new PowerCapsule(token.x, token.y, WeaponTypes.TIME_BOMB_GUN);
				p.setWidth(token.width);
				p.setHeight(token.height);
				p.setSpeed(token.speed);
				
				generateAt(p, time);
				
				break;

			case ToGenerateTokenTypes.P_SMG:

				time += token.time_delay;
				
				p = new PowerCapsule(token.x, token.y, WeaponTypes.SINE_MACHINE_GUN);
				p.setWidth(token.width);
				p.setHeight(token.height);
				p.setSpeed(token.speed);
				
				generateAt(p, time);
				
				break;

			case ToGenerateTokenTypes.P_LG:
				time += token.time_delay;
				
				p = new PowerCapsule(token.x, token.y, WeaponTypes.LASER_GUN);
				p.setWidth(token.width);
				p.setHeight(token.height);
				p.setSpeed(token.speed);
				
				generateAt(p, time);

				break;

			case ToGenerateTokenTypes.P_DLG:

				time += token.time_delay;
				
				p = new PowerCapsule(token.x, token.y, WeaponTypes.DOUBLE_LASER_GUN);
				p.setWidth(token.width);
				p.setHeight(token.height);
				p.setSpeed(token.speed);
				
				generateAt(p, time);
				
				break;
							
			
			}
			
		}
	
		
	}
	
		
	public void createBoss(){
		
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
