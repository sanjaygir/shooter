package player.weapons;


import game.BulletWeaponSystem;
import game.GameCharacterProperties;
import gamescreens.PlayState;
import player.weapons.bullets.SimpleLinearBullet;

public class DoubleLinearMissileGun extends BulletWeaponSystem{
	
	
	public DoubleLinearMissileGun(float x, float y){
			
		super(x, y);
		
		shoot_time = GameCharacterProperties.DOUBLE_LINEAR_MISSILE_GUN_SHOOT_DELAY;
		shoot_timer = 0;
		
		targets = PlayState.enemies;
		
	}
	
	

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
	
		
		super.update(dt);
		
		if(!cooling_down && shoot){
			
			SimpleLinearBullet b1 = new SimpleLinearBullet(x-10, y);
			b1.setTargets(targets);
			b1.setSpeed(GameCharacterProperties.DOUBLE_LINEAR_MISSILE_GUN_BULLET_SPEED);
			b1.setDriftLeft(GameCharacterProperties.DOUBLE_LINEAR_MISSILE_GUN_BULLET_DRIFT_LEFT_SPEED);
			b1.setHeight(GameCharacterProperties.DOUBLE_LINEAR_MISSILE_GUN_BULLET_HEIGHT);
			b1.setDamage(GameCharacterProperties.DOUBLE_LINEAR_MISSILE_GUN_BULLET_DAMAGE);
			bullets.add(b1);
			
			
			SimpleLinearBullet b2 = new SimpleLinearBullet(x+10, y);
			b2.setTargets(targets);
			b2.setSpeed(GameCharacterProperties.DOUBLE_LINEAR_MISSILE_GUN_BULLET_SPEED);
			b2.setDriftRight(GameCharacterProperties.DOUBLE_LINEAR_MISSILE_GUN_BULLET_DRIFT_RIGHT_SPEED);
			b2.setDamage(GameCharacterProperties.DOUBLE_LINEAR_MISSILE_GUN_BULLET_DAMAGE);
			b2.setHeight(GameCharacterProperties.DOUBLE_LINEAR_MISSILE_GUN_BULLET_HEIGHT);
			bullets.add(b2);
			
			
			cooling_down = true;
			
		}
		
	
	
		
	}

	
	
	

}
