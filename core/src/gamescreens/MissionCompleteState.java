package gamescreens;

import game.Game;
import game.GameKeys;
import game.GameStateManager;
import game.ParametricCurveUnit;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class MissionCompleteState extends GameState{

	private SpriteBatch batch;
	private BitmapFont font;
	
	private ShapeRenderer sr;
	
	private ParametricCurveUnit pcu;
	
	private ArrayList<ParametricCurveUnit> pcus;
	
	private float spawn_time;
	private float spawn_timer;
	
	private float mission_complete_timer;
	private float mission_complete_time;
	
	private float you_are_great_timer;
	private float you_are_great_time;
	
	
	public MissionCompleteState(){
		
		init();
		
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
	
		mission_complete_timer = 0;
		mission_complete_time = 7;
		
		you_are_great_timer = 0;
		you_are_great_time = 10;
			
		
		spawn_time = 0.1f;
		spawn_timer = 0;
		
		
		pcus = new ArrayList<ParametricCurveUnit>();
		
		
		
		batch = new SpriteBatch();
		
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
		font = gen.generateFont(50);

		sr = new ShapeRenderer();
	
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
		spawn_timer += dt;
		mission_complete_timer += dt;
		you_are_great_timer += dt;
		
		
		if(spawn_timer > spawn_time && pcus.size() < 62){
			pcus.add(new ParametricCurveUnit(400, 400));
			spawn_timer = 0;
		}
		
		
		for(int i=0;i<pcus.size();i++){
			pcus.get(i).update(dt);		
		}
		
		
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
		batch.setProjectionMatrix(Game.cam.combined);
		
		for(int i=0;i<pcus.size();i++){
			pcus.get(i).draw(sr);		
		}
		
		
		if(mission_complete_timer > mission_complete_time){
		
			batch.begin();
				
				font.draw(batch, "Mission Complete!!", 100, 400);
				
			batch.end();
		
		}
		
		
		if(you_are_great_timer > you_are_great_time){
		

			batch.begin();
			
				font.draw(batch, "You're Great!", 180, 200);
				
			batch.end();
			
			
			
		}
		
		
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
		if(GameKeys.isPressed(GameKeys.SHOOT_A)){
			
			Game.gsm.setState(GameStateManager.GAME_OVER_STATE);
			
		}
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
