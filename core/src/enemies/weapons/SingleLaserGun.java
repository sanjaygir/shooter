package enemies.weapons;

import game.BulletWeaponSystem;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class SingleLaserGun extends BulletWeaponSystem{
	
	
	public SingleLaserGun(float x, float y){
		
		super(x, y);
		
		shoot_time = 0.05f;
		shoot_timer = 0;
				
	}
	
	
	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(ShapeRenderer sr) {
		// TODO Auto-generated method stub
		
	}

}
