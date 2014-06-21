package player.weapons;

import game.BulletWeaponSystem;
import game.Entity;
import game.GameCharacterProperties;
import gamescreens.PlayState;

import java.util.ArrayList;

import player.weapons.bullets.SimpleLinearBullet;

public class CrossMachineGun extends BulletWeaponSystem{
	
		
	public CrossMachineGun(float x, float y){
			
		super(x, y);
		shoot_time = GameCharacterProperties.CROSS_MACHINE_GUN_SHOOT_DELAY;
		shoot_timer = 0;
		
		targets = PlayState.enemies;
		
				
	}
	

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
			
		
		super.update(dt);				

		
		SimpleLinearBullet b;
		
		
		if(!cooling_down && shoot){
			
			b = new SimpleLinearBullet(x, y);
			b.setTargets(targets);
			b.setSpeed(GameCharacterProperties.CROSS_MACHINE_GUN_BULLET_SPEED);
			b.setAngle(90);
			b.setDamage(GameCharacterProperties.CROSS_MACHINE_GUN_BULLET_DAMAGE);			
			bullets.add(b);
						
			
			b = new SimpleLinearBullet(x, y);
			b.setTargets(targets);
			b.setSpeed(GameCharacterProperties.CROSS_MACHINE_GUN_BULLET_SPEED);
			b.setAngle(0);
			b.setDamage(GameCharacterProperties.CROSS_MACHINE_GUN_BULLET_DAMAGE);			
			bullets.add(b);						

			b = new SimpleLinearBullet(x, y);
			b.setTargets(targets);
			b.setSpeed(GameCharacterProperties.CROSS_MACHINE_GUN_BULLET_SPEED);
			b.setAngle(180);
			b.setDamage(GameCharacterProperties.CROSS_MACHINE_GUN_BULLET_DAMAGE);			
			bullets.add(b);
						

			b = new SimpleLinearBullet(x, y);
			b.setTargets(targets);
			b.setSpeed(GameCharacterProperties.CROSS_MACHINE_GUN_BULLET_SPEED);
			b.setAngle(270);
			b.setDamage(GameCharacterProperties.CROSS_MACHINE_GUN_BULLET_DAMAGE);			
			bullets.add(b);
						
			
			cooling_down = true;
		}
	
	
		
	
		
	}	
}
