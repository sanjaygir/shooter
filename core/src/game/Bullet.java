package game;


import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public abstract class Bullet extends Entity{
	
	protected float speed;
	protected float damage;
	
	protected ArrayList<Entity> targets;
		
	public Bullet(float x, float y){
		super(x, y);
	}		
	
	public void setTargets(ArrayList<Entity> e){
	
		this.targets = e;
				
	}
	
	
	public void setSpeed(float s){
		this.speed = s;
	}
	
	public float getSpeed(){
		return this.speed;		
	}
	
	
	public void setDamage(float d){
		this.damage = d;
	}
	
	public float getDamage(){
		return this.damage;
	}
	
	public void update(float dt){
			
		super.update(dt);
		
	}

	
	public void draw(ShapeRenderer sr){
		
		sr.begin(ShapeType.Filled);		
			sr.rect(x - width/2, y - height/2, width, height);
		sr.end();
		
	}
	
	
	
}
