package enemies;


import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

public class CircleEnemyUnit extends Enemy{


	/*
	 * 
	 * 
	 * THE BEHAVIOR OF THIS CLASS IS IT TRAVELS TO CERTAIN DISTANCE GIVEN BY SCREEN Y COORDINATE AND IT STARTS 
	 * TURNING GIVEN BY THE TURN RATE OR ANGLE_AMOUNT* 
	 * 	
	 * 
	 */
	
	
	//THE ANGLE IT IS TRAVELING -> 0 MEANS GOING RIGHT, 180 GOING LEFT, 90 GOING UP
	private float angle;
	
	//HOW MUCH TO TURN THE ANGLE BY .. RATE OF CHANGE OF ANGLE OR ANGULAR SPEED
	private float angle_amount;
		
	private float turn_start_time;
	private float turn_stop_angle;
	
	
	private float timer;
	
	public CircleEnemyUnit(float x, float y){
		
		super(x, y);
		
		
		this.width = 20;
		this.height = 20;
		
		this.hp = 200;
		
		speed = 300f;
		angle_amount = 1f;
		angle = 270;
		
		turn_start_time = 2f;
		
		timer = 0;
		
	}
	
	public void setTurnStartTime(float t){
		turn_start_time = t;
	}	

	public void setTurnStopAngle(float t){
		turn_stop_angle = t;
	}
	
	public void setInitialAngle(float t){
		angle = t;
	}
		
	public void setAngleAmount(float d){
		
		angle_amount = d;
		
	}
	

	
	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
		super.update(dt);

		timer += dt;
		
		if(timer > turn_start_time){
	
				if(angle < turn_stop_angle){
					angle += angle_amount;
				}
			
		}
	
		
		this.x += speed * dt * MathUtils.cos(angle * MathUtils.PI/180f);
		this.y += speed * dt * MathUtils.sin(angle * MathUtils.PI/180f);
	
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
