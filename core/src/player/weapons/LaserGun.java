package player.weapons;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import enemies.Enemy;

import game.Game;

public class LaserGun extends WeaponSystem{


	private float target_y;
	
	private float speed;
	
	private ArrayList<Enemy> targets;
	
	private boolean hitting_target;
	
	
	public LaserGun(){
		
	
		target_y = this.y;
		
		speed = 3000;
		
		targets = this.play_state.getEnemies();
	
		hitting_target = false;
	}
	
	@Override
	public void setShoot(boolean b) {
		// TODO Auto-generated method stub
		shoot = b;
		
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
		Enemy min = null;
		float min_dis = 1000;
		
		for(int i=0;i<targets.size();i++){
			Enemy temp = targets.get(i);
			
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
			
			min.getHit(5);
			
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
		
		sr.begin(ShapeType.Line);
		
		sr.line(this.x, this.y, 0, this.x, target_y, 0);
		
		sr.end();
		
		
	}
	

}
