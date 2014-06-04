package game;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

public class GameInputProcessor extends InputAdapter{

	
	public boolean keyDown(int k){
		
		if(k == Keys.LEFT){
				
			GameKeys.setState(GameKeys.LEFT, true);
						
		}

		if(k == Keys.RIGHT){
			
			GameKeys.setState(GameKeys.RIGHT,  true);
			
		}

		if(k == Keys.UP){
			
			GameKeys.setState(GameKeys.UP, true);
			
		}

		
		if(k == Keys.DOWN){
			
			GameKeys.setState(GameKeys.DOWN, true);
			
		}

		
		if(k == Keys.A){
			
			GameKeys.setState(GameKeys.SHOOT_A, true);
		
		}

		
		if(k == Keys.S){
		
			GameKeys.setState(GameKeys.SHOOT_B, true);
			
		}


		return true;

		
		
	}
	
	public boolean keyUp(int k){
		
		if(k == Keys.LEFT){
			
			GameKeys.setState(GameKeys.LEFT, false);
						
		}

		if(k == Keys.RIGHT){
			
			GameKeys.setState(GameKeys.RIGHT,  false);
			
		}

		if(k == Keys.UP){
			
			GameKeys.setState(GameKeys.UP, false);
			
		}

		
		if(k == Keys.DOWN){
			
			GameKeys.setState(GameKeys.DOWN, false);
			
		}

		
		if(k == Keys.A){
			
			GameKeys.setState(GameKeys.SHOOT_A, false);
		
		}

		
		if(k == Keys.S){
		
			GameKeys.setState(GameKeys.SHOOT_B, false);
			
		}


		return true;


		
	}
	
}
