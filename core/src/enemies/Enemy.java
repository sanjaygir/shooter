package enemies;

import game.Entity;
import gamescreens.PlayState;

public abstract class Enemy extends Entity{

		public Enemy(float x, float y){

			super(x, y);
						
		}
		
		public void update(float dt){
			
			for(int i=0;i<PlayState.players.size();i++){
				
				if(!PlayState.players.get(i).remove && this.intersects(PlayState.players.get(i))){
					
					this.remove = true;
					PlayState.players.get(i).getHit(100);
					
				}
				
			}

		}
	
	
}
