package enemies;

import enemies.weapons.SingleLaserGun;
import game.WeaponSystem;
import gamescreens.PlayState;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class WallCrawler extends Enemy{

	private WeaponSystem weapon;
	
	private boolean vertical;
		
	
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
		
	private int place;
	
	public WallCrawler(float x, float y, int p){
		
		super(x, y);	
		
		this.width = 50;
		this.height = 50;
		
		this.hp = 500;
		
		speed = 100f;
		
		this.place = p;
	
		
		if(place == UP){
			weapon = new SingleLaserGun(this.x, this.y, SingleLaserGun.DOWN);
						
		}
		else if(place == DOWN){
			
			weapon = new SingleLaserGun(this.x, this.y, SingleLaserGun.UP);
			
		}
		else if(place ==  LEFT){
			
			weapon = new SingleLaserGun(this.x, this.y, SingleLaserGun.RIGHT);
			
		}
		else if(place == RIGHT){
			
			weapon = new SingleLaserGun(this.x, this.y, SingleLaserGun.LEFT);
			
		}

		vertical = true;
	}
	
	
	public void setMovesVertical(boolean b){
		
		this.vertical = b;
		
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
		
		
		
		if(vertical){
			
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
