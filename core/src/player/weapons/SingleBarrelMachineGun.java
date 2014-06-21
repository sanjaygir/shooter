package player.weapons;


import game.BulletWeaponSystem;
import game.GameCharacterProperties;
import gamescreens.PlayState;
import player.weapons.bullets.SimpleLinearBullet;

public class SingleBarrelMachineGun extends BulletWeaponSystem{
	
	
	public SingleBarrelMachineGun(float x, float y){
			
		super(x, y);
		
		shoot_time = GameCharacterProperties.SINGLE_BARREL_MACHINE_GUN_SHOOT_DELAY;
		shoot_timer = 0;
		targets = PlayState.enemies;
		
		
	}
	

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		super.update(dt);
		
		
		if(!cooling_down && shoot){

			SimpleLinearBullet b = new SimpleLinearBullet(x, y);
			b.setTargets(this.targets);
			b.setDamage(GameCharacterProperties.SINGLE_BARREL_MACHINE_GUN_BULLET_DAMAGE);
			b.setSpeed(GameCharacterProperties.SINGLE_BARREL_MACHINE_GUN_BULLET_SPEED);
			bullets.add(b);
			
			cooling_down = true;
			
			
		}
		
		
	
		
	}

	

	
}
