package player.weapons;


import game.BulletWeaponSystem;
import gamescreens.PlayState;
import player.weapons.bullets.SimpleLinearBullet;

public class SingleBarrelMachineGun extends BulletWeaponSystem{
	
	
	public SingleBarrelMachineGun(float x, float y){
			
		super(x, y);
		
		shoot_time = 0.05f;
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
			b.setSpeed(800);
			bullets.add(b);
			
			cooling_down = true;
			
			
		}
		
		
	
		
	}

	

	
}
