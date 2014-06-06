package player.weapons;

import player.weapons.bullets.TimeBombBullet;

public class TimeBombGun extends BulletWeaponSystem{

	
	
	private TimeBombBullet bullet;
	
	
	public TimeBombGun(float x, float y){
		
		super(x, y);
	
		shoot_time = 3f;
		shoot_timer = 0;
		
		
	}
	

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
	
		if(shoot){
						
			shoot_timer += dt;
						
			if(shoot_timer >= shoot_time && (bullet == null || bullet.remove == true)){
				
				bullet = new TimeBombBullet(x, y);
				bullet.setTargets(this.play_state.getEnemies());
				bullet.setSpeed(1000);
				bullets.add(bullet);
								
				shoot_timer = 0;
				
				
			}
			
		}
		else{
			
			shoot_timer = 3f;
			
		}
		
		
		super.update(dt);
		
		
	
		
	}

	

}
