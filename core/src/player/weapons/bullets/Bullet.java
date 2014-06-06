package player.weapons.bullets;

import enemies.Enemy;
import game.Entity;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public abstract class Bullet extends Entity{
	
	protected float speed;
	protected float damage;
	
	protected ArrayList<Enemy> targets;
		
	public Bullet(float x, float y){
		super(x, y);
	}		
	
	public void setTargets(ArrayList<Enemy> e){
	
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
			
	}

	
	public void draw(ShapeRenderer sr){
		
		sr.begin(ShapeType.Filled);		
			sr.rect(x - width/2, y - height/2, width, height);
		sr.end();
		
	}
	
	
	
}
