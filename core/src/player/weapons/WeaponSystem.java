package player.weapons;

import game.Entity;
import gamescreens.PlayState;

public abstract class WeaponSystem extends Entity {

	protected boolean shoot;
			
	protected PlayState play_state;
	
	public abstract void setShoot(boolean b);
	
	
	public void setPlayState(PlayState ps){
		this.play_state = ps;
	}
	
}
