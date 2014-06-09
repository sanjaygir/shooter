package player.weapons.bullets;

import game.Bullet;
import game.Entity;
import game.Game;

import com.badlogic.gdx.math.MathUtils;

public class EnemyChaserBullet extends Bullet{

	private float angle;		
	private Entity target;
	
	private float target_angle;
	
		
	public EnemyChaserBullet(float x, float y){
		
		super(x, y);		
		
		speed = 500;
		
		width = 5;
		height = 10;
		
		this.damage = 100;
		
		target_angle = 0f;
		angle = 0f;
		
		
	
	}
	
	
	public void setTarget(Entity e){
		this.target = e;		
	}

	
	
	public void update(float dt){
			
		if(this.y >= Game.GAME_HEIGHT || this.y <= 0  ||  this.x <= 0 || this.x >= Game.GAME_WIDTH){
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
					
			
			

			float x_comp = target.getX() - this.x;
			float y_comp = target.getY() - this.y;
			
			
			if((x_comp < 0 && y_comp < 0) || (x_comp >= 0 && y_comp < 0)){
				
				target_angle = MathUtils.atan2(y_comp, x_comp)*180f/MathUtils.PI;
				target_angle = 180 + (180 + target_angle);
				
				
			}
			else{
			
				target_angle = MathUtils.atan2(y_comp, x_comp)*180f/MathUtils.PI;
			}
			
			
			
			if(angle > target_angle){
				angle -= 5;
			}
			else if(angle < target_angle){
				angle += 5;
			}
			
			
			y += speed * MathUtils.sin(angle * MathUtils.PI/180f) * dt;
			x += speed * MathUtils.cos(angle * MathUtils.PI/180f) * dt;
		
			
			
		}
		
		
	}

	
	
}
