package game;

public abstract class HittableEntity extends Entity {
	
	protected float hp;
	protected float speed;
	
	public HittableEntity(float x, float y){
		super(x, y);
	}
	
	public void setHP(float h){
		hp = h;
	}
	
	public float getHP(){
		return hp;
	}
	
	
	public float getSpeed(){
		return speed;
	}

	public void setSpeed(float s){
		
		speed = s;
		
	}
	
	public void getHit(float d) {
		// TODO Auto-generated method stub
		if(remove) return;
		
		this.hp -= d;		
		
		if(this.hp < 0){
			this.remove = true;
			
		}
		
	}
	
	
	
}
