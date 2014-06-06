package game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Entity {

	protected float x;
	protected float y;
	protected float width;
	protected float height;
	
	public boolean remove;
	
	
	public abstract void update(float dt);
	public abstract void draw(ShapeRenderer sr);
	
	public Entity(float x, float y){
		this.x = x;
		this.y = y;
	}
	

	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	public void setWidth(float w){
		this.width = w;
	}
	
	public void setHeight(float h){
		this.height = h;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public float getWidth(){
		return this.width;
	}
	
	public float getHeight(){
		return this.height;
	}
	
		
	
	public boolean intersects(Entity p){
		
		if((this.x-this.width/2) > (p.getX() + p.getWidth()/2)) return false;
		
		if((this.x+this.width/2) < (p.getX() - p.getWidth()/2)) return false;
		
		
		if((this.y + this.height/2) < (p.getY()-p.getHeight()/2)) return false;
		
		
		if((this.y - this.height/2) > (p.getY()+p.getHeight()/2)) return false;
		
		
		return true;	
		
	}
	
	
	
}
