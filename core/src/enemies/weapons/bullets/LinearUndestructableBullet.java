package enemies.weapons.bullets;

import player.weapons.bullets.SimpleLinearBullet;

public class LinearUndestructableBullet extends SimpleLinearBullet{
	
	
	public LinearUndestructableBullet(float x, float y){
		super(x, y);
		
		speed = 500;
		
		width = 5;
		height = 10;
					
		angle = 90;
		
		this.damage = 30;
		
		drift_left_speed = 0;
		drift_right_speed = 0;
		
		
	}
	
	
	

	
	
}
