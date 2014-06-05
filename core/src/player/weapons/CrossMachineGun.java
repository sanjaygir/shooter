package player.weapons;

import gamescreens.PlayState;

import java.util.ArrayList;

import player.weapons.bullets.SimpleLinearBullet;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class CrossMachineGun extends BulletWeaponSystem{

	
	private float shoot_time;
	private float shoot_timer;
	
	public CrossMachineGun(){
	
		shoot_time = 0.05f;
		shoot_timer = 0;
				
	}
	
	@Override
	public void setShoot(boolean b) {
		// TODO Auto-generated method stub
		shoot = b;		
	}

	
	
	
	
	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
		
		
		if(shoot){
			
			
			shoot_timer += dt;
			
			
			if(shoot_timer >= shoot_time){
				
				SimpleLinearBullet b1 = new SimpleLinearBullet(x, y);
				b1.setTargets(PlayState.enemies);
				
				b1.setSpeed(800);
				b1.setAngle(45);
				bullets.add(b1);
		
				SimpleLinearBullet b2 = new SimpleLinearBullet(x, y);
				b2.setTargets(PlayState.enemies);
				
				b2.setSpeed(800);
				b2.setAngle(45 + 90);
				bullets.add(b2);
		
				
				SimpleLinearBullet b3 = new SimpleLinearBullet(x, y);
				
				b3.setTargets(PlayState.enemies);
				b3.setSpeed(800);
				b3.setAngle(45 + 180);
				bullets.add(b3);
		
				
				SimpleLinearBullet b4 = new SimpleLinearBullet(x, y);
				b4.setTargets(PlayState.enemies);
				
				b4.setSpeed(800);
				b4.setAngle(45 + 270);
				bullets.add(b4);
		
				
				shoot_timer = 0;
				
				
			}
			
		}
		else{
			
			shoot_timer = 0.05f;
			
		}
		
		
		super.update(dt);
		
	
	
		
	}	
}