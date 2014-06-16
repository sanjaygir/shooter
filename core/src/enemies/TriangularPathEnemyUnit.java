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
		
				
	}
	
	public void setChangePathTime(float t){
		change_path_time = t;
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
			angle = 360 - turn_angle;
		}
		else{
			angle = 180 + turn_angle;
			
		}

		y += speed * MathUtils.sin(angle * MathUtils.PI/180f) * dt;
		x += speed * MathUtils.cos(angle * MathUtils.PI/180f) * dt;
	
		
		
	}
	
	
	
	public void setTurnAngle(float a){
		
		turn_angle = a;
		
	}

	@Override
	public void draw(ShapeRenderer sr) {
		// TODO Auto-generated method stub
		sr.begin(ShapeType.Line);
		
			sr.rect(x - width/2, y - height/2, width, height);
		
		sr.end();
	
	}

	
}
