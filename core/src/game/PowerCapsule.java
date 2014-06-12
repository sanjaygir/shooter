package game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class PowerCapsule extends Entity{
	
	private int type;
	
	public PowerCapsule(float x, float y, int type){
		
		super(x, y);
		
		this.type = type;
		
		this.width = 100;
		this.height = 10;
		
		
	}
	
	
	public int getType(){
		return type;
	}

	
	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
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
		
		
		if(this.type == WeaponTypes.CROSS_MACHINE_GUN){
		
			sr.line(x-20, y-20, x+20, y+20);
			sr.line(x+20, y-20, x-20, y+20);
				
			
		}
		else if(this.type == WeaponTypes.ENEMY_CHASER_GUN){
			
			sr.circle(x, y, 20);
			
		}
		else if(this.type == WeaponTypes.DOUBLE_LINEAR_MISSILE_GUN){
			
			sr.rect(x-width/2, y, width, 5);
			sr.rect(x-width/2, y-10, width, 5);
			
			
		}
		else if(type == WeaponTypes.TRIPLE_BARREL_MACHINE_GUN){
			
			sr.rect(x-30, y, 5, 10);
			sr.rect(x, y, 5, 10);
			sr.rect(x+30, y, 5, 10);
				
		}
		else if(type == WeaponTypes.FIVE_BARREL_MACHINE_GUN){
			
			sr.rect(x-60, y, 5, 10);
			
			sr.rect(x-30, y, 5, 10);
			sr.rect(x, y, 5, 10);
			sr.rect(x+30, y, 5, 10);
			
			sr.rect(x+60, y, 5, 10);
			
		}
		else if(type == WeaponTypes.TIME_BOMB_GUN){
			
			sr.rect(x-20, y, 40, 20);
			
		}
		else if(type == WeaponTypes.SINE_MACHINE_GUN){
		
			sr.ellipse(x-width/2, y, width, 20);
			sr.ellipse(x-width/2, y+20, width, 20);
		
		}
		else if(type == WeaponTypes.LASER_GUN){
			
			sr.rect(x-width/2, y, width, 5);
			
		}
		else if(type == WeaponTypes.DOUBLE_LASER_GUN){
			
			sr.rect(x-width/2, y+10, width+5, 5);
			sr.rect(x-width/2, y-10, width+5, 5);
			
		}
		
		sr.end();

		
	}
	
	

}
