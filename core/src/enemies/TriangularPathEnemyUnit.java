package enemies;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

public class TriangularPathEnemyUnit extends Enemy {
	

	/*
	 * 
	 * 
	 * THIS CLASS TURNS OR MAKES A SHARP TURN EVERY CHANGE_PATH_TIME SECOND..YOU CAN SPECIFY THE TURN ANGLE
	 *  
	 * 
	 * 
	 */
	
	
	private float timer;
	private float change_path_time;
	private boolean right_direction;
	private float angle;
	
	private float turn_angle;
	
	
	private float initial_direction;
	
	
	
	public TriangularPathEnemyUnit(float x, float y){
		super(x, y);
		
		timer = 0f;
		change_path_time = 1f;		
		right_direction = true;		
		angle = 0f;		
		speed = 200f;		
		width = 20;
		height = 20;
		
		turn_angle = 45;
		
		initial_direction = 270+45;
		
		angle = initial_direction;
						
	}
	
	
	
	public void setInitialDirection(float d){
		
		initial_direction = d;
		
	}
	
	public void setChangePathTime(float t){
		change_path_time = t;
	}
	
	

	public void setTurnAngle(float a){
		
		turn_angle = a;
		
	}
	
	
	
	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
		super.update(dt);		
		
		timer += dt;
		
		if(timer >= change_path_time){
			
			timer = 0f;
			
			if(right_direction){
				right_direction = false;
			}
			else{
				right_direction = true;
			}
			
		}		
		
		if(right_direction){
			angle = initial_direction - turn_angle;
		}
		else{
			angle = initial_direction + turn_angle;
			
		}

		y += speed * MathUtils.sin(angle * MathUtils.PI/180f) * dt;
		x += speed * MathUtils.cos(angle * MathUtils.PI/180f) * dt;
	
		
		
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
