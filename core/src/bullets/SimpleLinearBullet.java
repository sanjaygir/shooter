package bullets;

import game.Entity;
import game.Game;

import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;

public class SimpleLinearBullet extends Bullet{
	
	private float angle;
	
		
	public SimpleLinearBullet(float x, float y){
		
		this.x = x;
		this.y = y;
		
		speed = 300;
		
		width = 5;
		height = 5;
					
		angle = 90;
		
	}
	
	

	public void setAngle(float degrees){
		
		angle = degrees;
				
	}
	
	
	public void update(float dt){
	
		if(this.y >= Game.GAME_HEIGHT){
			this.dead = true;
			return;
		}
		
		
		if(!dead){
						
			for(int i=0;i<targets.size();i++){
				
				//if(this.intersects(targets.get(i))){
				//	targets.get(i).getHit();
				//}
				
			}
			
			
			y += speed * MathUtils.sin(angle * MathUtils.PI/180f) * dt;
			x += speed * MathUtils.cos(angle * MathUtils.PI/180f) * dt;
		
			
			
		}
		
		
	}

	
	
	
}
