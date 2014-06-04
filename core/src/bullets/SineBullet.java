package bullets;

import game.Game;

import com.badlogic.gdx.math.MathUtils;

public class SineBullet extends Bullet{
		
	// y(t) = A sin(2 pi f t)
	
	private float frequency;
	private float amplitude;
	private float initial_x;
	private float time_accum;
	
		
	public SineBullet(float x, float y){
		
		this.x = x;
		this.y = y;
		
		initial_x = x;
		
		speed = 300;
		
		width = 5;
		height = 5;
		
		
		frequency = 100;
		amplitude = 100;
		
		time_accum = 0f;
		
		
	}
	
	
	
	// y(t) = A sin(2 pi f t)
	
	
	public void update(float dt){
	
		time_accum += dt;
				
		if(this.y >= Game.GAME_HEIGHT){
			this.dead = true;
			return;
		}
		
		
		if(!dead){
			
			y += speed * dt;
			x = initial_x + amplitude * MathUtils.sin((2 * MathUtils.PI*frequency*time_accum) * MathUtils.PI/180f);
												
			
		}
		
		
	}

	
	
	
}
