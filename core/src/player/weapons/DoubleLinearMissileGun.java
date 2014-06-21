package player.weapons;


import game.BulletWeaponSystem;
import gamescreens.PlayState;
import player.weapons.bullets.SimpleLinearBullet;

public class DoubleLinearMissileGun extends BulletWeaponSystem{
	
	
	public DoubleLinearMissileGun(float x, float y){
			
		super(x, y);
		
		shoot_time = 0.3f;
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
			b1.setSpeed(500);
			b1.setDriftLeft(100);
			b1.setHeight(50);
			b1.setDamage(100);
						
			
			bullets.add(b1);
			
			
			SimpleLinearBullet b2 = new SimpleLinearBullet(x+10, y);
			b2.setTargets(targets);
			b2.setSpeed(500);
			b2.setDriftRight(100);
			b2.setDamage(100);
			
			b2.setHeight(50);
			
			bullets.add(b2);
			
			cooling_down = true;
			
		}
		
	
	
		
	}

	
	
	

}
