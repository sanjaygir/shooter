package player.weapons;


import game.BulletWeaponSystem;
import game.GameCharacterProperties;
import gamescreens.PlayState;
import player.weapons.bullets.SineBullet;

public class SineMachineGun extends BulletWeaponSystem{
	
	public SineMachineGun(float x, float y){
	
		super(x, y);
		
		shoot_time = GameCharacterProperties.SINE_MACHINE_GUN_SHOOT_DELAY;
		shoot_timer = 0;
		targets = PlayState.enemies;
		
		
	}
	

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		super.update(dt);
		
		
		if(!cooling_down && shoot){
			
			SineBullet b1 = new SineBullet(x, y);
			b1.setSpeed(GameCharacterProperties.SINE_MACHINE_GUN_BULLET_SPEED);
			b1.setDamage(GameCharacterProperties.SINE_MACHINE_GUN_BULLET_DAMAGE);
			b1.setTargets(targets);
			
			
			SineBullet b2 = new SineBullet(x, y);
			b2.setSpeed(GameCharacterProperties.SINE_MACHINE_GUN_BULLET_SPEED);
			b2.setPhase(180);
			b2.setDamage(GameCharacterProperties.SINE_MACHINE_GUN_BULLET_DAMAGE);
			b2.setTargets(targets);
			
			
			bullets.add(b1);
			bullets.add(b2);
			
			cooling_down = true;
			
		}	
		
	
		
	}

	

	
}
