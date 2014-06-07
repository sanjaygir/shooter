package player.weapons;


import game.BulletWeaponSystem;
import player.weapons.bullets.SimpleLinearBullet;

public class DoubleLinearMissileGun extends BulletWeaponSystem{
	
	
	public DoubleLinearMissileGun(float x, float y){
			
		super(x, y);
		
		shoot_time = 0.4f;
		shoot_timer = 0;
		
		
	}
	
	

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
	
		
		super.update(dt);
		
		if(!cooling_down && shoot){
			
			SimpleLinearBullet b1 = new SimpleLinearBullet(x-10, y);
			b1.setTargets(targets);
			b1.setSpeed(500);
			b1.setDriftLeft(50);
			b1.setHeight(50);
			
			
			bullets.add(b1);
			
			
			SimpleLinearBullet b2 = new SimpleLinearBullet(x+10, y);
			b2.setTargets(targets);
			b2.setSpeed(500);
			b2.setDriftRight(50);
			
			b2.setHeight(50);
			
			bullets.add(b2);
			
			cooling_down = true;
			
		}
		
	
	
		
	}

	
	
	

}
