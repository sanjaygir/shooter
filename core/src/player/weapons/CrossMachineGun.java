package player.weapons;

import game.BulletWeaponSystem;
import game.Entity;
import gamescreens.PlayState;

import java.util.ArrayList;

import player.weapons.bullets.SimpleLinearBullet;

public class CrossMachineGun extends BulletWeaponSystem{
	
	
	private ArrayList<Entity> targets;
	
	
	public CrossMachineGun(float x, float y){
			
		super(x, y);
		shoot_time = 0.1f;
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
			
			b1.setSpeed(800);
			b1.setAngle(45);
			bullets.add(b1);
	
			SimpleLinearBullet b2 = new SimpleLinearBullet(x, y);
			b2.setTargets(targets);
			
			b2.setSpeed(800);
			b2.setAngle(45 + 90);
			bullets.add(b2);
	
			
			SimpleLinearBullet b3 = new SimpleLinearBullet(x, y);
			
			b3.setTargets(targets);
			b3.setSpeed(800);
			b3.setAngle(45 + 180);
			bullets.add(b3);
	
			
			SimpleLinearBullet b4 = new SimpleLinearBullet(x, y);
			b4.setTargets(targets);
			
			b4.setSpeed(800);
			b4.setAngle(45 + 270);
			bullets.add(b4);
	
			cooling_down = true;
		}
	
	
	
		
	}	
}
