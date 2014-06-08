package player.weapons;

import game.BulletWeaponSystem;
import gamescreens.PlayState;
import player.weapons.bullets.TimeBombBullet;

public class TimeBombGun extends BulletWeaponSystem{

	
	
	private TimeBombBullet bullet;
	
	
	public TimeBombGun(float x, float y){
		
		super(x, y);
	
		shoot_time = 3f;
		shoot_timer = 0;
		
		targets = PlayState.enemies;
		
	}
	

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		super.update(dt);
		
		
		if(!cooling_down && shoot){
			
			bullet = new TimeBombBullet(x, y);
			bullet.setTargets(targets);
			bullet.setSpeed(1000);
			bullets.add(bullet);
			
			cooling_down = true;
			
		}
	
		
	
		
	}

	

}
