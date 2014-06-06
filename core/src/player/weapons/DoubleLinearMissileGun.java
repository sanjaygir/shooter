package player.weapons;


import player.weapons.bullets.SimpleLinearBullet;

public class DoubleLinearMissileGun extends BulletWeaponSystem{

	
	
	public DoubleLinearMissileGun(float x, float y){
			
		super(x, y);
		
		shoot_time = 1f;
		shoot_timer = 0;
		
		
	}
	
	

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
	
		
		super.update(dt);
		
		if(!cooling_down && shoot){
			

			SimpleLinearBullet b1 = new SimpleLinearBullet(x-30, y);
			b1.setTargets(this.play_state.getEnemies());
			b1.setSpeed(500);
			bullets.add(b1);
			
			
			SimpleLinearBullet b2 = new SimpleLinearBullet(x+30, y);
			b2.setTargets(this.play_state.getEnemies());
			b2.setSpeed(500);
			bullets.add(b2);
			
			cooling_down = true;
			
		}
		
	
	
		
	}

	
	
	

}
