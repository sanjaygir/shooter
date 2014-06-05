package player;


import game.HittableEntity;
import player.weapons.LaserGun;
import player.weapons.WeaponSystem;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Player extends HittableEntity{

	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
		
	private float x;
	private float y;
	
	private float width;
	private float height;
	
	private float speed;
	
	private WeaponSystem weapon;

		
	public Player(){
		
		x = 300;
		y = 10;
		
		width = 100;
		height = 10;
		
		speed = 300;
		
		weapon = new LaserGun();
		weapon.setX(x);
		weapon.setY(y);
		
		remove = false;
		
	}
		

	@Override
	public void getHit(float h) {
		// TODO Auto-generated method stub
		
	}
	
	

	public void update(float dt){
		
		
		weapon.setX(x);
		weapon.setY(y);
		
		
		
		if(left){
			x -= speed*dt;
		}
		
		if(right){
			x += speed*dt;
		}
		
		if(up){
			y += speed*dt;
		}
		
		if(down){
			y-=speed*dt;
			
		}
			
		
		weapon.update(dt);
		
	}
	
	
	public void draw(ShapeRenderer sr){
		
		sr.begin(ShapeType.Line);
		
		sr.rect(x - width/2, y - height/2, width, height);
		
		sr.end();
		
		weapon.draw(sr);
	}
	

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////SETTERS AND GETTERS//////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	

	public void setSpeed(float s){
		
		this.speed = s;
		
	}
	
	public void setUp(boolean b){
		up = b;
		
	}
	
	public void setDown(boolean b){
		
		down = b;
		
	}
	
	public void setLeft(boolean b){
		
		left = b;
		
	}
	
	public void setRight(boolean b){
		
		right = b;
		
	}
	
	public void setShootA(boolean b){
				
		weapon.setShoot(b);
		
	}
	
	public void setShootB(boolean b){
		
	}
	

	
	
	
	public boolean getUp(){
		return up;
	}
	
	public boolean getDown(){
		return down;	
	}
		
	public boolean getLeft(){
		return left;
	}
	
	public boolean getRight(){
		return right;
	}

	
}
