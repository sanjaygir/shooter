package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

public abstract class Bullet extends Entity{
	
	protected float speed;
			
	protected boolean dead;
		
	
	public Bullet(){
		
	}
	
	
	public void setSpeed(float s){
		
		this.speed = s;
		
	}
	
	public boolean getDead(){
		return dead;
	}
	
	public void setDead(boolean b){
		dead = b;
	}
	
	public void update(float dt){
	
		
	}

	
	public void draw(ShapeRenderer sr){
		
		sr.begin(ShapeType.Filled);
		
		sr.rect(x - width/2, y - height/2, width, height);
		
		sr.end();
		
	}
	
	
	
}
