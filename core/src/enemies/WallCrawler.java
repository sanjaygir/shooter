package enemies;

import enemies.weapons.SingleLaserGun;
import game.Game;
import game.WeaponSystem;
import gamescreens.PlayState;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class WallCrawler extends Enemy{
	
	/*
	 * 
	 * THIS ENEMY TYPE CRAWLS WALL, FOLLOWS THE PLAYER AND SHOOTS A LASER MISSILE
	 * 
	 * 
	 */
	
	//IT POSSESSES A WEAPON
	private WeaponSystem weapon;
	
	
	//SOME CLASS CONSTANTS FOR THE BEHAVIOR OF THIS CLASS
	
	public static final int SIT_UP = 0;
	public static final int SIT_DOWN = 1;
	public static final int SIT_LEFT = 2;
	public static final int SIT_RIGHT = 3;		
	
	public static final int ENTRY_FROM_UP = 4;
	public static final int ENTRY_FROM_DOWN = 5;
	public static final int ENTRY_FROM_LEFT = 6;
	public static final int ENTRY_FROM_RIGHT = 7;
	
	//WHERE DOES IT STICK IN THE WALL - > UP, DOWN, LEFT OR RIGHT
	private int place;
	//WHERE DOES IT ENTER TO SCREEN FROM
	private int entry_from;
	
	
	
	
	public WallCrawler(int p, int e){
		
		super(-50, -50);
		
		place = p;
		entry_from = e;
	
	
		if(place == SIT_UP){
			weapon = new SingleLaserGun(this.x, this.y, SingleLaserGun.DOWN);
			
			if(entry_from == ENTRY_FROM_LEFT){
				x = -width/2;
				y = Game.GAME_HEIGHT - width/2;
			}
			else{
				x = Game.GAME_WIDTH + width/2;
				y = Game.GAME_HEIGHT - width/2;
			}
		}
		else if(place == SIT_DOWN)
		{
			weapon = new SingleLaserGun(this.x, this.y, SingleLaserGun.UP);
			
			if(entry_from == ENTRY_FROM_LEFT){
				x = -width/2;
				y = width/2;
			}
			else{
				x = Game.GAME_WIDTH + width/2;
				y = width/2;
			}

			
		}
		else if(place == SIT_LEFT){
			
			weapon = new SingleLaserGun(this.x, this.y, SingleLaserGun.RIGHT);
			
			if(entry_from == ENTRY_FROM_DOWN){
				
				x = width/2;
				y = -width/2;
			}
			else{
				
				x = width/2;
				y = Game.GAME_HEIGHT + width/2;
				
			}
		}
		else if(place == SIT_RIGHT){
			
			weapon = new SingleLaserGun(this.x, this.y, SingleLaserGun.LEFT);
			
			if(entry_from == ENTRY_FROM_DOWN){
				
				x = Game.GAME_WIDTH - width/2;
				y = -width/2;
				
				
			}
			else{
				
				x = Game.GAME_WIDTH - width/2;
				y = Game.GAME_HEIGHT + width/2;
				
				
			}
		}
		
		
		
		
		this.width = 50;
		this.height = 50;
		
		this.hp = 500;
		
		speed = 200f;
		

	}
	
	
	
	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
				
		super.update(dt);
		
		
		weapon.setX(this.x);
		weapon.setY(this.y);
	
		
		
		if(PlayState.player.remove){
			speed = 0;
			weapon.setShoot(false);
			return;
		}
		
		
		
				
		if(place == SIT_LEFT || place == SIT_RIGHT){
			
			if(Math.abs(this.y - PlayState.player.getY()) < 5 && !PlayState.player.remove){
				weapon.setShoot(true);
			}
			
			else if(PlayState.player.getY() < this.y){
				this.y -= speed*dt;
				weapon.setShoot(false);
				
			}
			else if(PlayState.player.getY() > this.y){
				this.y += speed*dt;
				weapon.setShoot(false);
				
			}
			
		
		}
		else{
			

			if(Math.abs(this.x - PlayState.player.getX()) < 5 && !PlayState.player.remove){
				weapon.setShoot(true);
			}
			
			else if(PlayState.player.getX() < this.x){
				this.x -= speed*dt;
				weapon.setShoot(false);
				
			}
			else if(PlayState.player.getX() > this.x){
				this.x += speed*dt;
				weapon.setShoot(false);
				
			}
			
			
		}
		
		
				
		weapon.update(dt);
		
		
	}

	@Override
	public void draw(ShapeRenderer sr) {
		// TODO Auto-generated method stub
		sr.begin(ShapeType.Line);
		
		sr.rect(x - width/2, y - height/2, width, height);
		
		sr.end();
		
		weapon.draw(sr);
	
	}
	
	
	

}
