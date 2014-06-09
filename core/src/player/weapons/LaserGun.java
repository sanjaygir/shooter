package player.weapons;

import game.Entity;
import game.Game;
import game.WeaponSystem;
import gamescreens.PlayState;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class LaserGun extends WeaponSystem{

	private float target_y;
	private float speed;
	
	
	private boolean hitting_target;
	
	
	public LaserGun(float x, float y){
				
		super(x, y);
		
	
		target_y = this.y;
		
		speed = 3000;
		
	
		hitting_target = false;
		targets = PlayState.enemies;
		
	}
	

	
	
	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
		Entity min = null;
		float min_dis = 1000;
		
		for(int i=0;i<targets.size();i++){
			Entity temp = targets.get(i);
			
			if(this.x >= (temp.getX() - temp.getWidth()/2) && this.x <= (temp.getX() + temp.getWidth()/2)){
				
				
				if(this.target_y >= temp.getY() && temp.getY() > this.y){
				
								
					if(temp.getY() < min_dis){
						min = temp;
						min_dis = temp.getY();
					}
					
				}
				
			}
			
		}	
		
		
		
		if(min != null && shoot){
			this.target_y = min.getY();
			hitting_target = true;
		}
		else{
			hitting_target = false;
		}
		
		
		
		if(hitting_target){
			
			min.getHit(50);
			
		}
		
		
		if(shoot && !hitting_target){
				
		
			if(target_y > Game.GAME_HEIGHT){
				target_y = Game.GAME_HEIGHT;
			}
			else{
		
				target_y += speed*dt;
			}
			
		
		}
		
		else if(!hitting_target){
			target_y = this.y;
		}
		
		
			
		
	}

	@Override
	public void draw(ShapeRenderer sr) {
		// TODO Auto-generated method stub
		
		sr.begin(ShapeType.Filled);
		
			sr.rectLine(this.x, this.y, this.x, target_y, 5);
				
		sr.end();
		
		
	}
	

}
