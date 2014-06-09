package enemies;


import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

public class CircleEnemyUnit extends Enemy{


	private float angle;
	private float angle_amount;
	
	
	
	public CircleEnemyUnit(float x, float y){
		
		super(x, y);
		
		remove = false;
		
		this.x = x;
		this.y = y;	
		
		this.width = 20;
		this.height = 20;
		
		this.hp = 200;
		
		speed = 300f;
				
		angle = 0f;
		
		angle_amount = 1f;
			
		angle = 270;
		
		
	}
	

	
	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
		super.update(dt);
		
		
		if(this.y < 400){
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
