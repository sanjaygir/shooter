package player.weapons;

import game.Entity;
import gamescreens.PlayState;



public abstract class WeaponSystem extends Entity {

	protected boolean shoot;
	protected PlayState play_state;
	
			
	public void setShoot(boolean b) {
		// TODO Auto-generated method stub
		shoot = b;		
	}
	
	
	public WeaponSystem(float x, float y){
		super(x, y);
	}
	
	public void setPlayState(PlayState ps){
		this.play_state = ps;
	}
	
}
