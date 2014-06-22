package game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

public class ParametricCurveUnit extends Entity{

	private float accum_time;
	
	public ParametricCurveUnit(float x, float y){
		super(x, y);
		

		accum_time = 0f;
		
	}
	
	public void update(float dt){
		
		accum_time += dt;
			
		x = 400 + 1.5f*MathUtils.cos(50*accum_time*MathUtils.PI/180f)*100 - MathUtils.cos(60*5*accum_time*MathUtils.PI/180f)*100;
		y = 300 + 1.5f*MathUtils.sin(50*accum_time*MathUtils.PI/180f)*100 - MathUtils.sin(60*5*accum_time*MathUtils.PI/180f)*100;
			
	}
	
	@Override
	public void draw(ShapeRenderer sr) {
		// TODO Auto-generated method stub
		
		
		sr.begin(ShapeType.Point);
			
			sr.point(x, y, 0);
			
			//sr.rect(x - 5, y - 5, 10, 10);
		
		sr.end();
	}

	
	
}
