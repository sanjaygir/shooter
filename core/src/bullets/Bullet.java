package bullets;

import game.Entity;
import game.Hittable;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public abstract class Bullet extends Entity{
	
	protected float speed;
	protected boolean dead;
	protected float damage;
	
	protected ArrayList<Hittable> targets;
	
	
	public Bullet(){
				
	}
		
	
	public void setTargets(ArrayList<Hittable> e){
	
		this.targets = e;
				
	}
	
	
		
	
	public void setSpeed(float s){
		
		this.speed = s;
		
	}
	
	public boolean getDead(){
		return dead;
	}
	
	public void setDead(boolean b){
		dead = b;
	}
	
	public void update(float dt){
	
		
	}

	
	public void draw(ShapeRenderer sr){
		
		sr.begin(ShapeType.Filled);
		
		sr.rect(x - width/2, y - height/2, width, height);
		
		sr.end();
		
	}
	
	
	
}
