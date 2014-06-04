package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Entity {

	protected float x;
	protected float y;
	protected float width;
	protected float height;
		
	public abstract void update(float dt);
	public abstract void draw(ShapeRenderer sr);
	
	

	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	
}
