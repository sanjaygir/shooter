package weapons;

import java.util.ArrayList;

import bullets.SimpleLinearBullet;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class FiveBarrelMachineGun extends BulletWeaponSystem{
	
	private float shoot_time;
	private float shoot_timer;
	
	public FiveBarrelMachineGun(){
	
		shoot_time = 0.2f;
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
				b1.setSpeed(800);
				bullets.add(b1);
				
				SimpleLinearBullet b2 = new SimpleLinearBullet(x-20, y);
				b2.setSpeed(800);
				bullets.add(b2);
				
				SimpleLinearBullet b3 = new SimpleLinearBullet(x+20, y);
				b3.setSpeed(800);
				bullets.add(b3);
				
				SimpleLinearBullet b4 = new SimpleLinearBullet(x+40, y);
				b4.setSpeed(800);
				bullets.add(b4);
				
				SimpleLinearBullet b5 = new SimpleLinearBullet(x-40, y);
				b5.setSpeed(800);
				bullets.add(b5);
				
				
				shoot_timer = 0;
				
				
			}
			
		}
		else{
			
			shoot_timer = 0.2f;
			
		}
		
		
		super.update(dt);
		
		
	
		
	}

	

	
}
