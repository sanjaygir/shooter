package game;

public abstract class HittableEntity extends Entity {
	
		
	public abstract void getHit(float h);

	public HittableEntity(float x, float y){
		super(x, y);
	}
	
}
