package enemies;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

public class CrossJumpEnemyUnit extends Enemy{

	public static final int CROSS_RIGHT = 0;
	public static final int CROSS_LEFT = 1;
	
	
	private int direction;
	private float angle;
	
	private float timer;
	private float time;
	
	
	private float x_vel;
	private float y_vel;
	
	private float gravity;
	
	
	public CrossJumpEnemyUnit(float x, float y, int direction){
		
		super(x, y);
				
		this.direction = direction;
				
		angle = 120;
		
		
		remove = false;

		
		this.x = x;
		this.y = y;		
		
		this.width = 20;
		this.height = 20;
		
		this.hp = 200;
		
		speed = 300f;
				
		timer = 0f;
		time = 2f;
		
		gravity = 300;
		
		if(direction == CROSS_RIGHT){
			angle = 120;
		}
		else{
			angle = 60;
		}
		
		x_vel = 1.5f*speed * MathUtils.cos(angle * MathUtils.PI/180f);
		y_vel = 1.5f*speed * MathUtils.sin(angle * MathUtils.PI/180f);
		
	}
	
	
	public void update(float dt){		
		
		super.update(dt);
		
		timer += dt;				
		
		
		if(direction == CROSS_RIGHT){
		
		
			if(timer < time){
				this.y -= speed * dt;
				this.x += speed * dt;
				
			}
			else{					
				
				y_vel  = y_vel - gravity*dt;
							
				this.x += dt*x_vel;
				this.y += dt*y_vel;
							
				
			}
						
			
		}
		else{
			
			
			if(timer < time){
				this.y -= speed * dt;
				this.x -= speed * dt;
				
			}
			else{					
				
				y_vel  = y_vel - gravity*dt;
							
				this.x += dt*x_vel;
				this.y += dt*y_vel;
							
				
			}
			
			
		}
		
		
		
		
		
	}
	
	@Override
	public void draw(ShapeRenderer sr) {
		// TODO Auto-generated method stub
			
		sr.begin(ShapeType.Line);
		
		sr.rect(x - width/2, y - height/2, width, height);
		
		sr.end();

		
	}

	
	

}
