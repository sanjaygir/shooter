package player.weapons;


import player.weapons.bullets.SimpleLinearBullet;

public class SingleBarrelMachineGun extends BulletWeaponSystem{
	
	
	public SingleBarrelMachineGun(float x, float y){
	
		
		super(x, y);
		
		shoot_time = 0.05f;
		shoot_timer = 0;
		
		
	}
	

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		super.update(dt);
		
		
		if(!cooling_down && shoot){

			SimpleLinearBullet b = new SimpleLinearBullet(x, y);
			b.setTargets(this.play_state.getEnemies());
			b.setSpeed(1000);
			bullets.add(b);
			
			cooling_down = true;
			
			
		}
		
		
	
		
	}

	

	
}
