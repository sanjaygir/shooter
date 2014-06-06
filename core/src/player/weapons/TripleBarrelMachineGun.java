package player.weapons;


import player.weapons.bullets.SimpleLinearBullet;


public class TripleBarrelMachineGun extends BulletWeaponSystem{
	
	public TripleBarrelMachineGun(float x, float y){
		super(x, y);
		shoot_time = 0.2f;
		shoot_timer = 0;
		
		
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
				
				
				shoot_timer = 0;
				
				
			}
			
		}
		else{
			
			shoot_timer = 0.2f;
			
		}
		
		
		super.update(dt);
		
		
	
		
	}

	

	
}
