package enemies.weapons;

import enemies.weapons.bullets.LinearLaserBullet;
import enemies.weapons.bullets.LinearUndestructableBullet;
import game.BulletWeaponSystem;
import gamescreens.PlayState;

public class TripleBulletAngularGun extends BulletWeaponSystem {

	private boolean facing_right;
	
	
	public TripleBulletAngularGun(float x, float y){

		super(x, y);
		shoot_time = 1f;
		shoot_timer = 0;
		
		targets = PlayState.players;
	
		facing_right = true;
		
		
	}
	
	public void setFacingRight(boolean b){
		this.facing_right = b;		
	}
	
	
	public void update(float dt){
		
		super.update(dt);
		
		
		
		if(!cooling_down && shoot){

			
			
			if(facing_right){

				LinearUndestructableBullet b1 = new LinearUndestructableBullet(x, y);
				b1.setAngle(270 + 10);
				b1.setTargets(this.targets);
					
				bullets.add(b1);
				
				
				LinearUndestructableBullet b2 = new LinearUndestructableBullet(x, y);
				b2.setAngle(270 + 10 + 30);
				b2.setTargets(this.targets);
					
				bullets.add(b2);
				
				LinearUndestructableBullet b3 = new LinearUndestructableBullet(x, y);
				b3.setAngle(270 + 10 + 60);
				b3.setTargets(this.targets);
					
				bullets.add(b3);
				
				
			}
			else
			{
			
				
				LinearUndestructableBullet b1 = new LinearUndestructableBullet(x, y);
				b1.setAngle(270 - 10);
				b1.setTargets(this.targets);
					
				bullets.add(b1);
				
				
				LinearUndestructableBullet b2 = new LinearUndestructableBullet(x, y);
				b2.setAngle(270 - 10 - 30);
				b2.setTargets(this.targets);
					
				bullets.add(b2);
				
				LinearUndestructableBullet b3 = new LinearUndestructableBullet(x, y);
				b3.setAngle(270 - 10 - 60);
				b3.setTargets(this.targets);
					
				bullets.add(b3);
				
							
				
			}
						
			
			cooling_down = true;
		
		}
		
	}
	
}
