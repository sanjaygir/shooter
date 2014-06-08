package enemies;

import game.HittableEntity;
import gamescreens.PlayState;

public abstract class Enemy extends HittableEntity{

	
	public static final int CIRCLE_ENEMY_UNIT = 0;
	public static final int WALL_CRAWLER_ENEMY_UNIT = 1;
	public static final int SIMPLE_LINEAR_ENEMY_UNIT = 2;
	
	
	
		public Enemy(float x, float y){
			super(x, y);
						
		}
	
	
}
