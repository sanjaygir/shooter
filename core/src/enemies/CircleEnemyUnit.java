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
	 * 
	 * 
	 * 
	 */
	
	
	//THE ANGLE IT IS TRAVELING -> 0 MEANS GOING RIGHT, 180 GOING LEFT, 90 GOING UP
	private float angle;
	
	//HOW MUCH TO TURN THE ANGLE BY .. RATE OF CHANGE OF ANGLE OR ANGULAR SPEED
	private float angle_amount;
	
	//WHEN TO START TURNING
	private int turn_distance;
	
	
	
	public CircleEnemyUnit(float x, float y){
		
		super(x, y);
		
		
		this.width = 20;
		this.height = 20;
		
		this.hp = 200;
		
		speed = 300f;
		angle_amount = 1f;
		angle = 270;
		
		turn_distance = 400;
		
	}
	
	public void setAngleAmount(float d){
		
		angle_amount = d;
		
	}
	
	public void setTurnDistance(int d){
		
		turn_distance = d;
		
	}
	

	
	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
		super.update(dt);
		
		
		if(this.y < turn_distance){
			angle += angle_amount;
		}
		
		this.x += speed * dt * MathUtils.cos(angle * MathUtils.PI/180f);
		this.y += speed * dt * MathUtils.sin(angle * MathUtils.PI/180f);
	
	}
	

	@Override
	public void draw(ShapeRenderer sr) {
		// TODO Auto-generated method stub
			
		sr.begin(ShapeType.Line);
		
			sr.rect(x - width/2, y - height/2, width, height);
		
		sr.end();

		
	}

	

	

}
