package player.weapons;

import game.Entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class WeaponSystem extends Entity {

	protected boolean shoot;
			
	public abstract void setShoot(boolean b);
	
	
}
