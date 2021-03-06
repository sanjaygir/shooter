package player.weapons;

import game.BulletWeaponSystem;
import game.Entity;
import game.GameCharacterProperties;
import gamescreens.PlayState;
import player.weapons.bullets.EnemyChaserBullet;

public class EnemyChaserGun extends BulletWeaponSystem{
		
	public EnemyChaserGun(float x, float y){
			
		super(x, y);
		
		shoot_time = GameCharacterProperties.ENEMY_CHASER_GUN_SHOOT_DELAY;
		shoot_timer = 0;
		targets = PlayState.enemies;
		
	}
		

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
			
		super.update(dt);
			
		if(cooling_down == false && shoot){
			
			float min_dist = 10000;
			Entity target = null;			
			
			for(int i=0;i<targets.size();i++){
				
				
				Entity temp = targets.get(i);
				
				
				
				float dist = (float)Math.sqrt((temp.getX() - this.x)*(temp.getX() - this.x) + (temp.getY() - this.y)*(temp.getY() - this.y));
				
				if(dist < min_dist){
					min_dist = dist;
					target = temp;
				}
				
				
			}
			
			if(target != null){
							
				
				EnemyChaserBullet b = new EnemyChaserBullet(x, y);
				b.setTarget(target);
				b.setTargets(targets);
				b.setSpeed(GameCharacterProperties.ENEMY_CHASER_GUN_BULLET_SPEED);
				b.setDamage(GameCharacterProperties.ENEMY_CHASER_GUN_BULLET_DAMAGE);
				
				bullets.add(b);
							
				cooling_down = true;
					
			}
	
			
		}
	
		
		
		
		
		
	}

	

}
