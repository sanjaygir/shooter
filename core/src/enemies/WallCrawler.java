package enemies;

import enemies.weapons.SingleLaserGun;
import game.WeaponSystem;
import gamescreens.PlayState;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class WallCrawler extends Enemy{

	private float active_time;
	private float timer;
		
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
		
		active_time = 2f;
		timer = 0f;
		
		
		weapon = new SingleLaserGun(this.x, this.y);
		
		
		
	}
	
	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
		weapon.setX(this.x);
		weapon.setY(this.y);
		
		
		timer += dt;
		
		if(PlayState.players.size() != 0){
			
			
		
		if(PlayState.players.get(0).remove){
			speed = 0;
		}
				
		if(Math.abs(this.y - PlayState.players.get(0).getY()) < 5 && !PlayState.players.get(0).remove){
			weapon.setShoot(true);
		}
		
		else if(PlayState.players.get(0).getY() < this.y){
			this.y -= speed*dt;
			weapon.setShoot(false);
			
		}
		else if(PlayState.players.get(0).getY() > this.y){
			this.y += speed*dt;
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
