package player.weapons.bullets;

import game.Bullet;


public class TimeBombBullet extends Bullet{

	private float explode_timer;
	private float explode_time;
	
	private float blast_radius;
	
	public TimeBombBullet(float x, float y){
		
		super(x, y);
		
		speed = 500;
		
		width = 5;
		height = 10;
					
		this.damage = 1000;
				
		blast_radius = 500;
				
		this.explode_time = 3;
				
	}
	
	
	
	public void setExplodeTime(float s){
		this.explode_time = s;		
	}
		
	public float getExplodeTime(){
		return this.explode_time;
	}
	
	public void update(float dt){
	
		super.update(dt);
		
		
		explode_timer += dt;
				
		if(explode_timer > explode_time){
		
			for(int i=0;i<targets.size();i++){
				
				float dist = (float)Math.sqrt((targets.get(i).getX() - this.x)*(targets.get(i).getX() - this.x) + (targets.get(i).getY() - this.y)*(targets.get(i).getY() - this.y));
				
				if(dist <= blast_radius){
					
					targets.get(i).getHit(1000);
										
				}
				
			}
			
			this.remove = true;
		}
			
		
	}

}
