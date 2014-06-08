package player;


import game.Game;
import game.HittableEntity;
import game.WeaponSystem;
import gamescreens.PlayState;
import player.weapons.EnemyChaserGun;
import player.weapons.FiveBarrelMachineGun;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Player extends HittableEntity{

	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
			
	private WeaponSystem weapon1;
	private WeaponSystem weapon2;

	
	public Player(float x, float y, PlayState p){
						
		super(x, y);		
		
		width = 100;
		height = 10;
		
		speed = 300;		
		
		weapon1 = new FiveBarrelMachineGun(x, y);	
		weapon2 = new EnemyChaserGun(x, y);
						
		remove = false;
		
	}
		

	

	public void update(float dt){
		
		
		weapon1.setX(x);
		weapon1.setY(y);
		
		weapon2.setX(x);
		weapon2.setY(y);
			
		if(left && ((x - speed*dt - this.width/2) > 0)){
			x -= speed*dt;
		}
		
		if(right && ((x + speed*dt + this.width/2) < Game.GAME_WIDTH)){
			x += speed*dt;
		}
		
		if(up && ((y + speed*dt + this.height/2) < Game.GAME_HEIGHT)){
			y += speed*dt;
		}
		
		if(down && ((y - speed*dt - this.height/2) > 0)){
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
