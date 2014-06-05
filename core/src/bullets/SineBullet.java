package bullets;

import game.Game;

import com.badlogic.gdx.math.MathUtils;

public class SineBullet extends Bullet{
		
	// y(t) = A sin(2 pi f t)
	
	private float frequency;
	private float amplitude;
	private float initial_x;
	private float initial_y;

	private float time_accum;
	
		
	private float phase;
	
	
	public SineBullet(float x, float y){
		
		this.x = x;
		this.y = y;
		
		initial_x = x;
		initial_y = y;
		
		
		speed = 300;
		
		width = 5;
		height = 5;
		
		
		frequency = 100;
		amplitude = 200;
		
		time_accum = 0f;
		
		phase = 0f;
		
		
	}
	
	
	
	public void setPhase(float p){
		this.phase = p;
		
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
			x = initial_x + amplitude * MathUtils.sin((2 * MathUtils.PI*frequency*time_accum + phase) * MathUtils.PI/180f);
				
			
			//x = initial_x + amplitude * MathUtils.cos(time_accum*200 * MathUtils.PI/180f)* MathUtils.cos(time_accum*200 * MathUtils.PI/180f)* MathUtils.cos(time_accum*200 * MathUtils.PI/180f);
			//y = initial_y + amplitude * MathUtils.sin(time_accum *200* MathUtils.PI/180f)* MathUtils.sin(time_accum *200* MathUtils.PI/180f)* MathUtils.sin(time_accum *200* MathUtils.PI/180f);
			
			
			
			
		}
		
		
	}

	
	
	
}
