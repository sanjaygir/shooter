package player.weapons;

import java.util.ArrayList;

import player.weapons.bullets.Bullet;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class BulletWeaponSystem extends WeaponSystem{

	protected ArrayList<Bullet> bullets;
	
	
	public BulletWeaponSystem(){
		
		bullets = new ArrayList<Bullet>();		
		
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
			
	}
	
	public void draw(ShapeRenderer sr) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<bullets.size();i++){
			bullets.get(i).draw(sr);
		}
	
		
		
	}

	
}
