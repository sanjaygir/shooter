package weapons;

import java.util.ArrayList;

import bullets.SimpleLinearBullet;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class SingleBarrelMachineGun extends BulletWeaponSystem{
	
	private float shoot_time;
	private float shoot_timer;
	
	public SingleBarrelMachineGun(){
	
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
				
				SimpleLinearBullet b = new SimpleLinearBullet(x, y);
				b.setSpeed(800);
				bullets.add(b);
				
				
				shoot_timer = 0;
				
				
			}
			
		}
		else{
			
			shoot_timer = 0.2f;
			
		}
		
		
		super.update(dt);
		
		
	
		
	}

	

	
}
