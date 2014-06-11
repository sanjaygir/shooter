package enemies.weapons;

import enemies.weapons.bullets.LinearLaserBullet;
import game.BulletWeaponSystem;
import gamescreens.PlayState;

public class SingleLaserGun extends BulletWeaponSystem{
		
	private int direction;
	
	
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	
	
	public SingleLaserGun(float x, float y, int direction){
		
		super(x, y);
		
		shoot_time = 1f;
		shoot_timer = 0;
		
		targets = PlayState.players;
		
		this.direction = direction;
		
	}
	
	public void setDirection(int d){
		this.direction = d;
	}
	
	
	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
		super.update(dt);
				
		if(!cooling_down && shoot){

			LinearLaserBullet b = null;
			
			if(direction == LEFT){
				b = new LinearLaserBullet(x, y, LinearLaserBullet.LEFT);
				b.setTargets(this.targets);					
			}
			else if(direction == RIGHT){
				b = new LinearLaserBullet(x, y, LinearLaserBullet.RIGHT);
				b.setTargets(this.targets);					
			}
			else if(direction == UP){
				b = new LinearLaserBullet(x, y, LinearLaserBullet.UP);
				b.setTargets(this.targets);					
			}
			else if(direction == DOWN){
				b = new LinearLaserBullet(x, y, LinearLaserBullet.DOWN);
				b.setTargets(this.targets);					
			}
			
			b.setSpeed(700);
			
			
			PlayState.enemies.add(b);
			
						
			cooling_down = true;
			
			
		}
	}


}
