package enemies.weapons.bullets;


import game.Bullet;
import game.Game;

public class LinearLaserBullet extends Bullet{

	
	private int direction;
	
	public static final int DOWN =  0;
	public static final int UP =    1;
	public static final int LEFT =  2;
	public static final int RIGHT = 3;
	
	
	
	
	public LinearLaserBullet(float x, float y, int direction){
		super(x, y);
	
		speed = 300;		
		
		damage = 100;
		
		this.hp = 1;
		
		this.direction = direction;
		
		if(direction == DOWN || direction == UP){
			
			width = 5;
			height = 50;				
			
		}
		else if(direction == LEFT || direction == RIGHT){
			width = 50;
			height = 5;				
				
		}	
		
	}
	
	
	public void setDirection(int d){
		this.direction = d;		
	}
	
	public void update(float dt){
		
		if(this.x >= Game.GAME_WIDTH){
			this.remove = true;
			return;
		}
	
		if(!remove){
			
			for(int i=0;i<targets.size();i++){
				if(this.intersects(targets.get(i))){
					this.remove = true;
					targets.get(i).getHit(this.damage);
				}
			}
			
		}
		
		if(direction == UP){
			y += speed * dt;
					
		}
		else if(direction == DOWN){
			y -= speed * dt;
			
		}
		else if(direction == LEFT){
			x -= speed * dt;
			
		}
		else if(direction == RIGHT){
			x += speed * dt;
				
		}	
	
		
	}
	
	
	
}
