package player.weapons.bullets;

import game.Bullet;
import game.Game;

import com.badlogic.gdx.math.MathUtils;

public class SimpleLinearBullet extends Bullet{
	
	protected float angle;
	
	protected float drift_left_speed;
	protected float drift_right_speed;
	
		
	public SimpleLinearBullet(float x, float y){
		super(x, y);
		
		speed = 500;
		
		width = 5;
		height = 10;
					
		angle = 90;
		
		this.damage = 30;
		
		drift_left_speed = 0;
		drift_right_speed = 0;
		
		
	}
	
	public void setHeight(float h){
		height = h;
	}
	
	
	public void setDriftLeft(float s){
		drift_left_speed = s;
	}
	
	public void setDriftRight(float s){
		drift_right_speed = s;
	}
	
	
	

	public void setAngle(float degrees){
		
		angle = degrees;
				
	}
	
	
	public void update(float dt){
	
		if(this.y >= Game.GAME_HEIGHT){
			this.remove = true;
			return;
		}
		
		
		if(!remove){
						
			for(int i=0;i<targets.size();i++){
				
				if( this.intersects(targets.get(i))){
					this.remove = true;
					targets.get(i).getHit(this.damage);
				}
				
			}
			
			
			y += speed * MathUtils.sin(angle * MathUtils.PI/180f) * dt;
			x += speed * MathUtils.cos(angle * MathUtils.PI/180f) * dt - drift_left_speed*dt + drift_right_speed*dt;
		
			
			
		}
		
		
	}

	
	
	
}
