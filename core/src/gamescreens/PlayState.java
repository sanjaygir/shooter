package gamescreens;

import game.Game;
import game.GameKeys;
import game.Player;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;


public class PlayState extends GameState{

	private ShapeRenderer sr;
	private Player player;
	
	
	
	
	public PlayState(){
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		sr = new ShapeRenderer();
		player = new Player();
		
		player.setSpeed(300);
		
		
		
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
		player.update(dt);
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
		sr.setProjectionMatrix(Game.cam.combined);
		
		
		player.draw(sr);
		
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
	
		player.setDown(GameKeys.getState(GameKeys.DOWN));
		player.setUp(GameKeys.getState(GameKeys.UP));
		player.setLeft(GameKeys.getState(GameKeys.LEFT));
		player.setRight(GameKeys.getState(GameKeys.RIGHT));
		player.setShootA(GameKeys.getState(GameKeys.SHOOT_A));
		player.setShootB(GameKeys.getState(GameKeys.SHOOT_B));
		
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
