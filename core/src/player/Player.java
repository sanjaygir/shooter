package player;


import game.HittableEntity;
import gamescreens.PlayState;
import player.weapons.EnemyChaserGun;
import player.weapons.SingleBarrelMachineGun;
import player.weapons.WeaponSystem;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

public class Player extends HittableEntity{

	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
			
	private WeaponSystem weapon1;
	private WeaponSystem weapon2;

	private PlayState play_state;
	
		
	public Player(float x, float y, PlayState p){
		
				
		super(x, y);		
						
		this.play_state = p;
		
		width = 100;
		height = 10;
		
		speed = 300;		
		
		weapon1 = new SingleBarrelMachineGun(x, y);	
		weapon2 = new EnemyChaserGun(x, y);
				
		weapon1.setPlayState(play_state);
		weapon2.setPlayState(play_state);
		
		
		remove = false;
		
	}
		

	

	public void update(float dt){
		
		
		weapon1.setX(x);
		weapon1.setY(y);
		
		weapon2.setX(x);
		weapon2.setY(y);
			
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
			
		
		weapon1.update(dt);
		weapon2.update(dt);
		
	}
	
	
	public void draw(ShapeRenderer sr){
		
		sr.begin(ShapeType.Line);
		
		sr.rect(x - width/2, y - height/2, width, height);
		
		sr.end();
		
		weapon1.draw(sr);
		weapon2.draw(sr);
		
	}
	

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////SETTERS AND GETTERS//////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
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
				
		weapon1.setShoot(b);
		
	}
	
	public void setShootB(boolean b){
		
		weapon2.setShoot(b);
		
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
