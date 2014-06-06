package player.weapons;

import player.weapons.bullets.EnemyChaserBullet;
import enemies.Enemy;

public class EnemyChaserGun extends BulletWeaponSystem{
	
	
	public EnemyChaserGun(float x, float y){
			
		super(x, y);
		
		shoot_time = 2f;
		shoot_timer = 0;
		
	}
		

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
			
		super.update(dt);
			
		if(cooling_down == false && shoot){
			
			float min_dist = 10000;
			Enemy target = null;
			
			
			for(int i=0;i<this.play_state.getEnemies().size();i++){
				
				
				Enemy temp = this.play_state.getEnemies().get(i);
				
				
				
				float dist = (float)Math.sqrt((temp.getX() - this.x)*(temp.getX() - this.x) + (temp.getY() - this.y)*(temp.getY() - this.y));
				
				if(dist < min_dist){
					min_dist = dist;
					target = temp;
				}
				
				
			}
			
			if(target != null){
							
				
				EnemyChaserBullet b = new EnemyChaserBullet(x, y);
				b.setTarget(target);
				b.setTargets(this.play_state.getEnemies());
				b.setSpeed(300);
				
				
				bullets.add(b);
							
				cooling_down = true;
					
			}
	
			
		}
	
		
		
		
		
		
	}

	

}
