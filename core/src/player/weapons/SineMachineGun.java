package player.weapons;


import player.weapons.bullets.SineBullet;

public class SineMachineGun extends BulletWeaponSystem{
	
	public SineMachineGun(float x, float y){
	
		super(x, y);
		
		shoot_time = 0.05f;
		shoot_timer = 0;
		
		
	}
	

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		super.update(dt);
		
		
		if(!cooling_down && shoot){
			
			SineBullet b1 = new SineBullet(x, y);
			b1.setSpeed(800);
			b1.setTargets(this.play_state.getEnemies());
			
			
			SineBullet b2 = new SineBullet(x, y);
			b2.setSpeed(800);
			b2.setPhase(180);
			
			b2.setTargets(this.play_state.getEnemies());
			
			
			bullets.add(b1);
			bullets.add(b2);
			
			cooling_down = true;
			
		}	
		
	
		
	}

	

	
}
