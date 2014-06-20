package enemies;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

public class MarchAndThrowEnemyUnit extends Enemy{

	

	/*
	 * 
	 * 
	 * THE BEHAVIOR OF THIS CLASS IS IT TRAVELS FOR CERTAIN TIME GIVEN BY TRANSITION TIME AND THEN IT PROPELS
	 * OR THROWS TO CERTAIN ANGLE...LIKE THROWING A BALL TO CERTAIN ANGLE FROM GROUND 
	 * 
	 * 
	 * 
	 */
	
	
	private float timer;
	private float transition_time;
	
	
	private float gravity;
	
	private float jump_velocity;
	
	private float march_angle;
	private float jump_angle;
	
	
	private float march_x_vel;
	private float march_y_vel;
	
	private float jump_x_vel;
	private float jump_y_vel;
	
	private float angle;
	
	
	
	public MarchAndThrowEnemyUnit(float x, float y){
		
		super(x, y);
				
		
		march_angle = 60;
		jump_angle = 60;
		
		
		this.width = 20;
		this.height = 20;
		
		this.hp = 200;
		
		speed = 300f;
		jump_velocity = 400f;
		
		timer = 0f;
		transition_time = 1f;
		
		gravity = 300;
		
		
		march_x_vel = speed * MathUtils.cos(march_angle * MathUtils.PI/180f);
		march_y_vel = speed * MathUtils.sin(march_angle * MathUtils.PI/180f);
		
		jump_x_vel = jump_velocity * MathUtils.cos(jump_angle * MathUtils.PI/180f);
		jump_y_vel = jump_velocity * MathUtils.sin(jump_angle * MathUtils.PI/180f);
		
		angle = 0;
		
	}	
	
	
	
	public void setJumpAngle(float a){
		jump_angle = a;
	
		jump_x_vel = jump_velocity * MathUtils.cos(jump_angle * MathUtils.PI/180f);
		jump_y_vel = jump_velocity * MathUtils.sin(jump_angle * MathUtils.PI/180f);
	
	}
	
	public void setJumpVelocity(float v){
		jump_velocity = v;
	
		jump_x_vel = jump_velocity * MathUtils.cos(jump_angle * MathUtils.PI/180f);
		jump_y_vel = jump_velocity * MathUtils.sin(jump_angle * MathUtils.PI/180f);
	
	}
	
	public void setGravity(float g){
		gravity = g;
	}
	
	public void setTransitionTime(float t){
		
		transition_time = t;		
		
	}
	
	
	public void setSpeed(float s){
		
		speed = s;
		
		march_x_vel = speed * MathUtils.cos(march_angle * MathUtils.PI/180f);
		march_y_vel = speed * MathUtils.sin(march_angle * MathUtils.PI/180f);
	
		
	}
	
	public void setMarchAngle(float a){
		march_angle = a;
	
		march_x_vel = speed * MathUtils.cos(march_angle * MathUtils.PI/180f);
		march_y_vel = speed * MathUtils.sin(march_angle * MathUtils.PI/180f);
	
	}
	
	
	public void update(float dt){		
		
		super.update(dt);
		
		timer += dt;				
	
	

		if(timer < transition_time){
			
			
			this.x += dt* march_x_vel;
			this.y += dt* march_y_vel;
			
	
			angle = MathUtils.atan2(march_y_vel, march_x_vel) * 180f/MathUtils.PI;
			
		}
		else{					
			
			jump_y_vel  = jump_y_vel - gravity*dt;
			
			this.x += dt*jump_x_vel;
			this.y += dt*jump_y_vel;
			
			angle = MathUtils.atan2(jump_y_vel, jump_x_vel) * 180f/MathUtils.PI;
			
			
		}
			
		
				
		
	}
	
	@Override
	public void draw(ShapeRenderer sr) {
		// TODO Auto-generated method stub

		sr.begin(ShapeType.Line);
		
		 sr.identity();
		 sr.translate(x, y, 0);
		 sr.rotate(0, 0, 1, angle);
		 sr.rect(- width/2,  - height/2, width, height);						
		 sr.identity();
		 
		sr.end();

		
	}

	
	

}
