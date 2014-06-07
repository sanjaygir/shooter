package player.weapons;


import game.BulletWeaponSystem;
import player.weapons.bullets.SimpleLinearBullet;

public class FiveBarrelMachineGun extends BulletWeaponSystem{
	
	
	public FiveBarrelMachineGun(float x, float y){
	
		
		super(x, y);
		
		shoot_time = 0.05f;
		shoot_timer = 0;
				
	}
	

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		super.update(dt);
		
		if(!cooling_down && shoot){
			
			SimpleLinearBullet b1 = new SimpleLinearBullet(x, y);
			b1.setTargets(targets);
			
			b1.setSpeed(1000);
			bullets.add(b1);
			
			SimpleLinearBullet b2 = new SimpleLinearBullet(x-20, y);
			b2.setTargets(targets);
			
			b2.setSpeed(1000);
			bullets.add(b2);
			
			SimpleLinearBullet b3 = new SimpleLinearBullet(x+20, y);
			b3.setTargets(targets);
			
			b3.setSpeed(1000);
			bullets.add(b3);
			
			SimpleLinearBullet b4 = new SimpleLinearBullet(x+40, y);
			b4.setTargets(targets);
			
			b4.setSpeed(1000);
			bullets.add(b4);
			
			SimpleLinearBullet b5 = new SimpleLinearBullet(x-40, y);
			b5.setTargets(targets);
			
			b5.setSpeed(1000);
			bullets.add(b5);
			
			cooling_down = true;
			
		}
		
		
		
	
		
	}

	

	
}
