package player.weapons;


import game.BulletWeaponSystem;
import game.GameCharacterProperties;
import gamescreens.PlayState;
import player.weapons.bullets.SimpleLinearBullet;

public class FiveBarrelMachineGun extends BulletWeaponSystem{
	
	
	public FiveBarrelMachineGun(float x, float y){
	
		
		super(x, y);
		
		shoot_time = GameCharacterProperties.FIVE_BARREL_MACHINE_GUN_SHOOT_DELAY;
		shoot_timer = 0;
		targets = PlayState.enemies;
				
	}
	

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		super.update(dt);
		
		if(!cooling_down && shoot){
			
			SimpleLinearBullet b1 = new SimpleLinearBullet(x, y);
			b1.setTargets(targets);			
			b1.setSpeed(GameCharacterProperties.FIVE_BARREL_MACHINE_GUN_BULLET_SPEED);
			b1.setDamage(GameCharacterProperties.FIVE_BARREL_MACHINE_GUN_BULLET_DAMAGE);
			bullets.add(b1);
			
			SimpleLinearBullet b2 = new SimpleLinearBullet(x-20, y);
			b2.setTargets(targets);			
			b2.setSpeed(GameCharacterProperties.FIVE_BARREL_MACHINE_GUN_BULLET_SPEED);
			b2.setDamage(GameCharacterProperties.FIVE_BARREL_MACHINE_GUN_BULLET_DAMAGE);
			bullets.add(b2);
			
			SimpleLinearBullet b3 = new SimpleLinearBullet(x+20, y);
			b3.setTargets(targets);			
			b3.setSpeed(GameCharacterProperties.FIVE_BARREL_MACHINE_GUN_BULLET_SPEED);
			b3.setDamage(GameCharacterProperties.FIVE_BARREL_MACHINE_GUN_BULLET_DAMAGE);
			bullets.add(b3);
			
			SimpleLinearBullet b4 = new SimpleLinearBullet(x+40, y);
			b4.setTargets(targets);			
			b4.setSpeed(GameCharacterProperties.FIVE_BARREL_MACHINE_GUN_BULLET_SPEED);
			b4.setDamage(GameCharacterProperties.FIVE_BARREL_MACHINE_GUN_BULLET_DAMAGE);
			bullets.add(b4);
			
			SimpleLinearBullet b5 = new SimpleLinearBullet(x-40, y);
			b5.setTargets(targets);			
			b5.setSpeed(GameCharacterProperties.FIVE_BARREL_MACHINE_GUN_BULLET_SPEED);
			b5.setDamage(GameCharacterProperties.FIVE_BARREL_MACHINE_GUN_BULLET_DAMAGE);
			bullets.add(b5);
			
			cooling_down = true;
			
		}
		
				
	
		
	}

	

	
}
