package player.weapons.bullets;

import game.Bullet;
import game.Game;

import com.badlogic.gdx.math.MathUtils;

public class SineBullet extends Bullet{
		
	// y(t) = A sin(2 pi f t)
	
	private float frequency;
	private float amplitude;
	private float initial_x;	
	private float time_accum;			
	private float phase;
		
	public SineBullet(float x, float y){
		
		super(x, y);
		
		initial_x = x;		
		
		speed = 300;
		
		this.damage = 1000;
		
		
		width = 5;
		height = 5;
		
		
		frequency = 100;
		amplitude = 200;
		
		time_accum = 0f;
		
		phase = 0f;
		
		
	}
	
	
	public void setInitialX(float x){
		initial_x = x;
	}
	
	public float getInitialX(){
		return initial_x;
	}
	
	public void setAmplitude(float a){
		amplitude = a;
	}
	
	public float getAmplitude(){
		return amplitude;		
	}
	
	public void setFrequency(float f){
		frequency = f;
	}
	
	public float getFrequency(){
		return frequency;		
	}
	
	public void setPhase(float p){
		phase = p;		
	}
	
	public float getPhase(){
		return phase;
	}
	
	
	
	// y(t) = A sin(2 pi f t)
	
	
	public void update(float dt){
	
		time_accum += dt;
				
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
			
	
			y += speed * dt;
			x = initial_x + amplitude * MathUtils.sin((2 * MathUtils.PI*frequency*time_accum + phase) * MathUtils.PI/180f);
			
			
			
		}
		
		
	}

	
	
	
}
