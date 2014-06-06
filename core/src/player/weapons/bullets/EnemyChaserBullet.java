package player.weapons.bullets;

import enemies.Enemy;
import game.Game;

import com.badlogic.gdx.math.MathUtils;

public class EnemyChaserBullet extends Bullet{

	private float angle;
		
	private Enemy target;
	
	
	public EnemyChaserBullet(float x, float y){
		
		this.x = x;
		this.y = y;
		
		speed = 500;
		
		width = 5;
		height = 10;
			
		
		this.damage = 1000;
		
		
	}
	
	
	public void setTarget(Enemy e){
		this.target = e;		
	}

	public void setAngle(float degrees){
		
		angle = degrees;
				
	}
	
	
	public void update(float dt){
	
		
		if(this.y >= Game.GAME_HEIGHT || this.target.remove){
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
					
			
			angle = MathUtils.atan2(target.getY()-this.y, target.getX()-this.x)*180f/MathUtils.PI;
			
					
			y += speed * MathUtils.sin(angle * MathUtils.PI/180f) * dt;
			x += speed * MathUtils.cos(angle * MathUtils.PI/180f) * dt;
		
			
			
		}
		
		
	}

	
	
}
