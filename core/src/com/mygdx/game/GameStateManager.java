package com.mygdx.game;

import gamescreens.GameState;
import gamescreens.MenuState;
import gamescreens.PlayState;

public class GameStateManager {

	
	public static final int MENU_STATE = 0;
	public static final int PLAY_STATE = 1;
	
	
	private GameState current_state;
	
	public GameStateManager(){
		
		setState(PLAY_STATE);
		
		
	}
	
	
	public void setState(int s){
	
		if(s == MENU_STATE){
			
			current_state = new MenuState();
		
		}
		else if(s == PLAY_STATE){
			
			current_state = new PlayState();
			
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
