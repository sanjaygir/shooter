package enemies.weapons.bullets;


import game.Bullet;
import game.Game;

public class LinearLaserBullet extends Bullet{

	public LinearLaserBullet(float x, float y){
		super(x, y);
	
		speed = 300;		
		width = 50;
		height = 5;				
		damage = 100;
		
		this.hp = 1;
		
		this.hittable = true;
				
	}
	
	
	public void update(float dt){
		
		if(this.x >= Game.GAME_WIDTH){
			this.remove = true;
			return;
		}
	
		if(!remove){
			
			for(int i=0;i<targets.size();i++){
				if(targets.get(i).isHittable() && this.intersects(targets.get(i))){
					this.remove = true;
					targets.get(i).getHit(this.damage);
				}
			}
			
		}
		
		x += speed * dt;
	
		
	}
	
	
	
}
