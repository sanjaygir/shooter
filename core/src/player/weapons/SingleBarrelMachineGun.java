package player.weapons;


import player.weapons.bullets.SimpleLinearBullet;

public class SingleBarrelMachineGun extends BulletWeaponSystem{
	
	private float shoot_time;
	private float shoot_timer;
	
	public SingleBarrelMachineGun(){
	
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
				
				SimpleLinearBullet b = new SimpleLinearBullet(x, y);
				b.setTargets(this.play_state.getEnemies());
				b.setSpeed(1000);
				bullets.add(b);
				
				
				shoot_timer = 0;
				
				
			}
			
		}
		else{
			
			shoot_timer = 0.05f;
			
		}
		
		
		super.update(dt);
		
		
	
		
	}

	

	
}
