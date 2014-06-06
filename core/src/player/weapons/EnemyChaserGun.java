package player.weapons;

import player.weapons.bullets.EnemyChaserBullet;
import enemies.Enemy;

public class EnemyChaserGun extends BulletWeaponSystem{

	private float shoot_time;
	private float shoot_timer;
	
	public EnemyChaserGun(){
	
		shoot_time = 2f;
		shoot_timer = 0;
		
		
	}
	
	@Override
	public void setShoot(boolean b) {
		// TODO Auto-generated method stub
		shoot = b;		
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
	
		
		
		if(shoot){
			
			
			shoot_timer += dt;
			
			
			if(shoot_timer >= shoot_time){
				
				
				
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
								
					
				}
				
				shoot_timer = 0;
				
				
			}
			
		}
		else{
			
			shoot_timer = 2f;
			
		}
		
		
		super.update(dt);
		
		
	
		
	}

	

}
