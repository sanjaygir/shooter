package player.weapons;

import java.util.ArrayList;

import player.weapons.bullets.Bullet;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class BulletWeaponSystem extends WeaponSystem{

	protected ArrayList<Bullet> bullets;
	
	protected float shoot_time;
	protected float shoot_timer;
		
	protected boolean cooling_down;
	
	public BulletWeaponSystem(float x, float y){
		super(x, y);
		
		bullets = new ArrayList<Bullet>();		
		cooling_down = false;
	}

	public void setShootInterval(float s){
		this.shoot_time = s;
	}
	
	public void update(float dt){
		
		//handle bullets

		for(int i=0;i<bullets.size();i++){
			
			if(!bullets.get(i).remove){
				
				bullets.get(i).update(dt);
				
			}
			else{
				
				bullets.remove(i);
				i--;
				
			}
			
		}
		

		if(cooling_down){
			shoot_timer += dt;
		}
		
		if(shoot_timer >= shoot_time){
			shoot_timer = 0;
			cooling_down = false;
		}
			
	}
	
	public void draw(ShapeRenderer sr) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<bullets.size();i++){
			bullets.get(i).draw(sr);
		}
	
		
		
	}

	
}
