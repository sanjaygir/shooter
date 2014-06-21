package player.weapons;


import game.BulletWeaponSystem;
import game.GameCharacterProperties;
import gamescreens.PlayState;
import player.weapons.bullets.SimpleLinearBullet;


public class TripleBarrelMachineGun extends BulletWeaponSystem{
	
	public TripleBarrelMachineGun(float x, float y){
		super(x, y);
		shoot_time = GameCharacterProperties.TRIPLE_BARREL_MACHINE_GUN_SHOOT_DELAY;
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
			b1.setSpeed(GameCharacterProperties.TRIPLE_BARREL_MACHINE_GUN_BULLET_SPEED);
			b1.setDamage(GameCharacterProperties.TRIPLE_BARREL_MACHINE_GUN_BULLET_DAMAGE);
			bullets.add(b1);
			
			SimpleLinearBullet b2 = new SimpleLinearBullet(x-20, y);
			b2.setTargets(targets);			
			b2.setSpeed(GameCharacterProperties.TRIPLE_BARREL_MACHINE_GUN_BULLET_SPEED);
			b2.setDamage(GameCharacterProperties.TRIPLE_BARREL_MACHINE_GUN_BULLET_DAMAGE);
			bullets.add(b2);
			
			SimpleLinearBullet b3 = new SimpleLinearBullet(x+20, y);
			b3.setTargets(targets);
			b3.setSpeed(GameCharacterProperties.TRIPLE_BARREL_MACHINE_GUN_BULLET_SPEED);
			b3.setDamage(GameCharacterProperties.TRIPLE_BARREL_MACHINE_GUN_BULLET_DAMAGE);
			bullets.add(b3);
			
			cooling_down = true;
			
			
		}
		
	
		
	}

	

	
}
