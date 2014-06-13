package enemies;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;


public class SimpleLinearEnemyUnit extends Enemy{
	
	public SimpleLinearEnemyUnit(float x, float y){
		
		super(x, y);
		
		this.width = 20;
		this.height = 20;
		
		this.hp = 200;
		
		speed = 100f;
				
	}
	

	
	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
				
		super.update(dt);
		
		if(this.y < 0){
			this.remove = true;
			return;
		}
			
		this.y -= speed * dt;
				
		
	}
	

	@Override
	public void draw(ShapeRenderer sr) {
		// TODO Auto-generated method stub
			
		sr.begin(ShapeType.Line);
		
		sr.rect(x - width/2, y - height/2, width, height);
		
		sr.end();

		
	}

	

	
	
}