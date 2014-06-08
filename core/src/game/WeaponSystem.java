package game;

import game.Entity;

import java.util.ArrayList;

public abstract class WeaponSystem extends Entity {

	protected boolean shoot;
	protected ArrayList<HittableEntity> targets;
	
			
	public void setShoot(boolean b) {
		// TODO Auto-generated method stub
		shoot = b;		
	}
	
	public WeaponSystem(float x, float y){
		super(x, y);
		
	}


}
