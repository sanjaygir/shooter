package player.weapons;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import game.WeaponSystem;
import gamescreens.PlayState;

public class DoubleLaserGun extends WeaponSystem{
	
	private LaserGun gun1;
	private LaserGun gun2;
	
	
	public DoubleLaserGun(float x, float y){
				
		super(x, y);
		
		
		gun1 = new LaserGun(x-30, y);
		gun2 = new LaserGun(x+30, y);
		
		
	}
	

	public void setShoot(boolean b) {
		// TODO Auto-generated method stub
		gun1.setShoot(b);
		gun2.setShoot(b);
		
	}
	
	
	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
	
		
		
		gun1.setX(this.x-30);
		gun1.setY(this.y);
		gun2.setX(this.x+30);
		gun2.setY(this.y);
		
		
		
		gun1.update(dt);
		gun2.update(dt);
		
		
	}

	@Override
	public void draw(ShapeRenderer sr) {
		// TODO Auto-generated method stub
		gun1.draw(sr);
		gun2.draw(sr);
		
		
	}
	
	

}
