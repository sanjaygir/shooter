package enemies;

import enemies.weapons.TripleBulletAngularGun;
import game.WeaponSystem;
import gamescreens.PlayState;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class TripleBulletEnemyUnit extends Enemy{
		

	/*
	 * 
	 * 
	 * THIS CLASS SHOOTS TRIPLE BULLET IN ONE OF 5 DIRECTIONS...RIGHT, UP, LEFT, RIGHT_DOWN, LEFT_DOWN 
	 * 
	 * 
	 * 
	 */
	
	private TripleBulletAngularGun weapon;

	private float timer;
	private float time;
	
	
	public static final int RIGHT_DOWN = 0;
	public static final int LEFT_DOWN = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;
	
	
	
	
	public TripleBulletEnemyUnit(float x, float y){
			
		super(x, y);
		
		this.width = 50;
		this.height = 50;
		
		this.hp = 500;
		
		speed = 100f;
		
		weapon = new TripleBulletAngularGun(this.x, this.y);
		
		timer = 0f;
		timer = 0f;
		
		
		setShootDirection(TripleBulletAngularGun.DOWN);
		
	}
	
	
	
	public void setShootDirection (int d){
		weapon.setShootDirection(d);
	}
	
	public void setShootTime(float t){
		time = t;
	}
	
	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
		timer += dt;
		
		super.update(dt);
		
		
		weapon.setX(this.x);
		weapon.setY(this.y);
	
		
		if(timer > time){
			
			weapon.setShoot(true);
			
			timer = 0;
		}
		
		this.y -= speed * dt;
					
		
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
