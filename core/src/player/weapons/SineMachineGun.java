package player.weapons;


import player.weapons.bullets.SineBullet;

public class SineMachineGun extends BulletWeaponSystem{
	
	
	private float shoot_time;
	private float shoot_timer;
	
	public SineMachineGun(){
	
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
				
				SineBullet b1 = new SineBullet(x, y);
				b1.setSpeed(800);
				b1.setTargets(this.play_state.getEnemies());
				
				
				SineBullet b2 = new SineBullet(x, y);
				b2.setSpeed(800);
				b2.setPhase(180);
				
				b2.setTargets(this.play_state.getEnemies());
				
				
				bullets.add(b1);
				bullets.add(b2);
				
				
				shoot_timer = 0;
				
				
			}
			
		}
		else{
			
			shoot_timer = 0.05f;
			
		}
		
		
		super.update(dt);
		
		
	
		
	}

	

	
}
