package enemies;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

import enemies.weapons.TripleBulletAngularGun;
import game.Game;
import game.GameStateManager;

public class MainBoss extends Enemy{

	private TripleBulletAngularGun weapon_left_down;
	private TripleBulletAngularGun weapon_down;
	private TripleBulletAngularGun weapon_right_down;
	private TripleBulletAngularGun weapon_right;
	private TripleBulletAngularGun weapon_left;
		
	
	
	private float timer;
	private float time;
		
	
	public MainBoss(float x, float y){
		super(x, y);
		
		
		this.width = 50;
		this.height = 50;
		
		this.hp = 500;
		
		speed = 100f;
		
		weapon_left_down = new TripleBulletAngularGun(this.x, this.y);
		weapon_down = new TripleBulletAngularGun(this.x, this.y);
		weapon_right_down = new TripleBulletAngularGun(this.x, this.y);
		weapon_right = new TripleBulletAngularGun(this.x, this.y);
		weapon_left = new TripleBulletAngularGun(this.x, this.y);
				
		
		timer = 0f;
		time = 3f;
		
		
		weapon_left_down.setShootDirection(TripleBulletAngularGun.LEFT_DOWN);
		weapon_down.setShootDirection(TripleBulletAngularGun.DOWN);
		weapon_right_down.setShootDirection(TripleBulletAngularGun.RIGHT_DOWN);
		weapon_right.setShootDirection(TripleBulletAngularGun.RIGHT);
		weapon_left.setShootDirection(TripleBulletAngularGun.LEFT);
		

		
		weapon_left_down.setShoot(false);
		weapon_down.setShoot(false);
		weapon_right_down.setShoot(false);
		weapon_right.setShoot(false);
		weapon_left.setShoot(false);
		
	}

	
	
	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
				
		timer += dt;
		
		super.update(dt);
		
				
		weapon_left_down.setX(this.x);
		weapon_left_down.setY(this.y);
	
		weapon_down.setX(this.x);
		weapon_down.setY(this.y);
	
		weapon_right_down.setX(this.x);
		weapon_right_down.setY(this.y);
	
		weapon_right.setX(this.x);
		weapon_right.setY(this.y);
	
		weapon_left.setX(this.x);
		weapon_left.setY(this.y);
	
		
		if(timer > time){
		
			int rand = MathUtils.random(4);
			
			if(rand == 0){
				weapon_left_down.setShoot(true);
				
			}
			else if(rand == 1){
				weapon_down.setShoot(true);
				
			}
			else if(rand == 2){
				weapon_right_down.setShoot(true);
				
			}
			else if(rand == 3){
				weapon_right.setShoot(true);
				
			}
			else if(rand == 4){
				
				weapon_left.setShoot(true);
				
			}
			
			
			timer = 0;
		}
		
				
		
		weapon_left_down.update(dt);
		weapon_down.update(dt);
		weapon_right_down.update(dt);
		weapon_right.update(dt);
		weapon_left.update(dt);
		
		
		
		weapon_left_down.setShoot(false);
		weapon_down.setShoot(false);
		weapon_right_down.setShoot(false);
		weapon_right.setShoot(false);
		weapon_left.setShoot(false);
		

		
	}

	@Override
	public void draw(ShapeRenderer sr) {
		// TODO Auto-generated method stub
		sr.begin(ShapeType.Line);
		
		sr.rect(x - width/2, y - height/2, width, height);
		
		sr.end();
		
		weapon_left_down.draw(sr);
		weapon_down.draw(sr);
		weapon_right_down.draw(sr);
		weapon_right.draw(sr);
		weapon_left.draw(sr);
		
	
	}
	
	

}
