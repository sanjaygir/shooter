package enemies.weapons;

import enemies.weapons.bullets.LinearLaserBullet;
import enemies.weapons.bullets.LinearUndestructableBullet;
import game.BulletWeaponSystem;
import gamescreens.PlayState;

public class TripleBulletAngularGun extends BulletWeaponSystem {

	private int direction;
	
	public static final int RIGHT_DOWN = 0;
	public static final int LEFT_DOWN = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;
	
	
	
	
	public TripleBulletAngularGun(float x, float y){

		super(x, y);
		shoot_time = 1f;
		shoot_timer = 0;
		
		targets = PlayState.players;
	
		direction = DOWN;
		
	}
	
	
	public void setShootDirection(int b){
		this.direction = b;
	}
	
	
	public void update(float dt){
		
		super.update(dt);
		
		
		
		if(!cooling_down && shoot){

			
			if(direction == RIGHT){
			
				LinearUndestructableBullet b1 = new LinearUndestructableBullet(x, y);
				b1.setAngle(0);
				b1.setTargets(this.targets);
					
				bullets.add(b1);
				
				
				LinearUndestructableBullet b2 = new LinearUndestructableBullet(x, y);
				b2.setAngle(45);
				b2.setTargets(this.targets);
					
				bullets.add(b2);
				
				LinearUndestructableBullet b3 = new LinearUndestructableBullet(x, y);
				b3.setAngle(270 + 45);
				b3.setTargets(this.targets);
					
				bullets.add(b3);
				
			
				
			}
			else if(direction == RIGHT_DOWN){

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
			else if(direction == LEFT){
			
				LinearUndestructableBullet b1 = new LinearUndestructableBullet(x, y);
				b1.setAngle(180);
				b1.setTargets(this.targets);
					
				bullets.add(b1);
				
				
				LinearUndestructableBullet b2 = new LinearUndestructableBullet(x, y);
				b2.setAngle(90+45);
				b2.setTargets(this.targets);
					
				bullets.add(b2);
				
				LinearUndestructableBullet b3 = new LinearUndestructableBullet(x, y);
				b3.setAngle(180 + 45);
				b3.setTargets(this.targets);
					
				bullets.add(b3);
				
			
				
			}
			else if(direction == LEFT_DOWN)
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
			else if(direction == DOWN){
				
			
				
				LinearUndestructableBullet b1 = new LinearUndestructableBullet(x, y);
				b1.setAngle(270);
				b1.setTargets(this.targets);
					
				bullets.add(b1);
				
				
				LinearUndestructableBullet b2 = new LinearUndestructableBullet(x, y);
				b2.setAngle(270 - 10 - 30);
				b2.setTargets(this.targets);
					
				bullets.add(b2);
				
				LinearUndestructableBullet b3 = new LinearUndestructableBullet(x, y);
				b3.setAngle(270 + 10 + 30);
				b3.setTargets(this.targets);
					
				bullets.add(b3);
				
				
				
				
			}
						
			
			cooling_down = true;
		
		}
		
	}
	
}
