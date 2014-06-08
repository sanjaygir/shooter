package enemies;

import enemies.weapons.SingleLaserGun;
import game.WeaponSystem;
import gamescreens.PlayState;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class WallCrawler extends Enemy{

	private WeaponSystem weapon;

	
	public WallCrawler(float x, float y){
		
		super(x, y);
		
		remove = false;
		this.x = x;
		this.y = y;
		
		this.width = 50;
		this.height = 50;
		
		this.hp = 500;
		
		speed = 100f;
		
		weapon = new SingleLaserGun(this.x, this.y);
		
		
	}
	
	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
		weapon.setX(this.x);
		weapon.setY(this.y);
	
		
		if(PlayState.player.remove){
			speed = 0;
			weapon.setShoot(false);
		}
		else if(Math.abs(this.y - PlayState.player.getY()) < 5 && !PlayState.player.remove){
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
