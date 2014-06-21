package game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import enemies.Enemy;
import gamescreens.PlayState;

public abstract class Entity {

	protected float x;
	protected float y;
	protected float width;
	protected float height;
	
	public boolean remove;
	
	protected float hp;
	protected float speed;
		
	
	public abstract void draw(ShapeRenderer sr);
	
	public Entity(float x, float y){
		
		this.x = x;
		this.y = y;
		
		this.width = 50;
		this.height = 50;
		
		remove = false;
		
		speed = 200;
		hp = 500;
		
		
	}
	
	
	public void setHP(float h){
		hp = h;
	}
	
	public float getHP(){
		return hp;
	}
	
	
	public float getSpeed(){
		return speed;
	}

	public void setSpeed(float s){
		
		speed = s;
		
	}
	
	public void getHit(float d) {
		// TODO Auto-generated method stub
		if(remove) return;
		
		this.hp -= d;		
		
		if(this.hp < 0){
			this.remove = true;
			
			if(this instanceof Enemy){
				PlayState.total_kills++;
			}
			
		}
		
	}	
	
	public void update(float dt){
			
		if(this.x < -Game.GAME_WIDTH || this.x > (Game.GAME_WIDTH + Game.GAME_WIDTH) || this.y < -Game.GAME_HEIGHT || this.y > (Game.GAME_HEIGHT + Game.GAME_HEIGHT)){
			this.remove = true;
		}
				
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
