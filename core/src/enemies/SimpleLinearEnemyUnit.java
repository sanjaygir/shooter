package enemies;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import game.Entity;

public class SimpleLinearEnemyUnit extends Enemy{

	
	private float speed;
	private float hp;
	
	
	
	public SimpleLinearEnemyUnit(){
		
		this.x = 400;
		this.y = 800;		
		
		this.width = 20;
		this.height = 20;
		
		
		speed = 200f;
				
	}
	
	public void setSpeed(float s){
		this.speed = s;
		
	}
	
	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
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
