package enemies.weapons;

import enemies.weapons.bullets.LinearLaserBullet;
import game.BulletWeaponSystem;
import gamescreens.PlayState;

public class SingleLaserGun extends BulletWeaponSystem{
		
	public SingleLaserGun(float x, float y){
		
		super(x, y);
		
		shoot_time = 1f;
		shoot_timer = 0;
		
		targets = PlayState.players;
		
	}
	
	
	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
		super.update(dt);
				
		if(!cooling_down && shoot){

			LinearLaserBullet b = new LinearLaserBullet(x, y);
			b.setTargets(this.targets);
			
			if(this.targets.size() != 0){
			
			if(this.targets.get(0).getX() < this.x){
				b.setSpeed(-1000);
						
			}
			else{
				b.setSpeed(1000);
				
			}
			
			}
			
			
			PlayState.enemies.add(b);
			
						
			cooling_down = true;
			
			
		}
	}


}
