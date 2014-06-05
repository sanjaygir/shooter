package player.weapons.bullets;

import game.Entity;
import game.Game;

import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;

public class SimpleLinearBullet extends Bullet{
	
	private float angle;
	
		
	public SimpleLinearBullet(float x, float y){
		
		this.x = x;
		this.y = y;
		
		speed = 500;
		
		width = 5;
		height = 10;
					
		angle = 90;
		
		this.damage = 30;
		
		
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
				
				if(this.intersects(targets.get(i))){
					this.remove = true;
					targets.get(i).getHit(this.damage);
				}
				
			}
			
			
			y += speed * MathUtils.sin(angle * MathUtils.PI/180f) * dt;
			x += speed * MathUtils.cos(angle * MathUtils.PI/180f) * dt;
		
			
			
		}
		
		
	}

	
	
	
}
