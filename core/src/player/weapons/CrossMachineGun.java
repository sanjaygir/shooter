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
		
		
		SimpleLinearBullet b;
		
		
		if(!cooling_down && shoot){
						
			b = new SimpleLinearBullet(x, y);
			b.setTargets(targets);
			b.setSpeed(800);
			b.setAngle(45);
			bullets.add(b);
						
						
	
			b = new SimpleLinearBullet(x, y);
			b.setTargets(targets);
			b.setSpeed(800);
			b.setAngle(45 + 90);
			bullets.add(b);
	
				
			b = new SimpleLinearBullet(x, y);
			b.setTargets(targets);
			b.setSpeed(800);
			b.setAngle(45 + 180);
			bullets.add(b);
	
			
			b = new SimpleLinearBullet(x, y);
			b.setTargets(targets);
			
			b.setSpeed(800);
			b.setAngle(45 + 270);
			bullets.add(b);
	
			cooling_down = true;
		}
	
	
	
		
	}	
}
