package player.weapons;


import game.BulletWeaponSystem;
import gamescreens.PlayState;
import player.weapons.bullets.SimpleLinearBullet;


public class TripleBarrelMachineGun extends BulletWeaponSystem{
	
	public TripleBarrelMachineGun(float x, float y){
		super(x, y);
		shoot_time = 0.2f;
		shoot_timer = 0;
		targets = PlayState.enemies;
		
		
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		super.update(dt);
		
		if(!cooling_down && shoot){
			
			SimpleLinearBullet b1 = new SimpleLinearBullet(x, y);
			b1.setSpeed(800);
			bullets.add(b1);
			
			SimpleLinearBullet b2 = new SimpleLinearBullet(x-20, y);
			b2.setSpeed(800);
			bullets.add(b2);
			
			SimpleLinearBullet b3 = new SimpleLinearBullet(x+20, y);
			b3.setSpeed(800);
			bullets.add(b3);
			
			cooling_down = true;
			
			
		}
		
	
		
	}

	

	
}
