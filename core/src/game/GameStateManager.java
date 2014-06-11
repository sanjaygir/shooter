package game;

import gamescreens.GameOverState;
import gamescreens.GameState;
import gamescreens.MenuState;
import gamescreens.PlayState;

public class GameStateManager {

	
	public static final int MENU_STATE = 0;
	public static final int PLAY_STATE = 1;
	public static final int GAME_OVER_STATE = 2;
	
	
	
	private GameState current_state;
	
	public GameStateManager(){
		
		setState(MENU_STATE);
		
		
	}
	
	
	public void setState(int s){
	
		if(s == MENU_STATE){
			
			current_state = new MenuState();
		
		}
		else if(s == PLAY_STATE){
			
			current_state = new PlayState();
			
		}
		else if(s == GAME_OVER_STATE){
			
			current_state = new GameOverState();
			
		}
		
	}
	
	public void update(float dt){
	
		current_state.update(dt);
	}
	
	
	public void draw(){
		
		current_state.draw();
		
	}
	
	public void handleInput(){
		
		current_state.handleInput();
		
	}
	
	
}
