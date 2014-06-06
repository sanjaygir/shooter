package player.weapons;


import player.weapons.bullets.SimpleLinearBullet;

public class DoubleLinearMissileGun extends BulletWeaponSystem{

	
	private float shoot_time;
	private float shoot_timer;
	
	public DoubleLinearMissileGun(){
	
		
		shoot_time = 1f;
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
				
				SimpleLinearBullet b1 = new SimpleLinearBullet(x-30, y);
				b1.setTargets(this.play_state.getEnemies());
				b1.setSpeed(500);
				bullets.add(b1);
				
				
				SimpleLinearBullet b2 = new SimpleLinearBullet(x+30, y);
				b2.setTargets(this.play_state.getEnemies());
				b2.setSpeed(500);
				bullets.add(b2);
				
				
				shoot_timer = 0;
				
				
			}
			
		}
		else{
			
			shoot_timer = 1;
			
		}
		
		
		super.update(dt);
		
		
	
		
	}

	
	
	

}
