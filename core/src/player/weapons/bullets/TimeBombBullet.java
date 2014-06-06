package player.weapons.bullets;


public class TimeBombBullet extends Bullet{

	private float explode_timer;
	private float explode_time;
	
	private float radius;
	
	public TimeBombBullet(float x, float y){
		
		this.x = x;
		this.y = y;
		
		speed = 500;
		
		width = 5;
		height = 10;
					
		this.damage = 1000;
				
		radius = 500;
				
		this.explode_time = 3;
				
	}
	
	public void setExplodeTime(float s){
		this.explode_time = s;		
	}
			
	
	public void update(float dt){
	
		
		explode_timer += dt;
				
		if(explode_timer > explode_time){
		
			for(int i=0;i<targets.size();i++){
				
				float dist = (float)Math.sqrt((targets.get(i).getX() - this.x)*(targets.get(i).getX() - this.x) + (targets.get(i).getY() - this.y)*(targets.get(i).getY() - this.y));
				
				if(dist <= radius){
					
					targets.get(i).getHit(1000);
										
				}
				
			}
			
			this.remove = true;
		}
			
		
	}

}
