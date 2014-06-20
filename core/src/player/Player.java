package player;


import game.Entity;
import game.Game;
import game.WeaponSystem;
import game.WeaponTypes;
import gamescreens.PlayState;
import player.weapons.CrossMachineGun;
import player.weapons.DoubleLaserGun;
import player.weapons.DoubleLinearMissileGun;
import player.weapons.EnemyChaserGun;
import player.weapons.FiveBarrelMachineGun;
import player.weapons.LaserGun;
import player.weapons.SineMachineGun;
import player.weapons.SingleBarrelMachineGun;
import player.weapons.TimeBombGun;
import player.weapons.TripleBarrelMachineGun;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Player extends Entity{

	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
			
	private WeaponSystem weapon1;
	private WeaponSystem weapon2;
	
	private boolean invincible;
	
	private float invincible_timer;
	private float invincible_time;
	
	public int lives;
	
	
	private float blink_time;
	private float blink_timer;
	
	private boolean visible;
	
	
	public Player(float x, float y, PlayState p){
						
		super(x, y);
		
		lives = 3;
		
		invincible = false;		
		
		invincible_timer = 0;
		invincible_time = 3;
		
		blink_time = 0.05f;
		blink_timer = 0;
		
		
		width = 100;
		height = 10;
		
		speed = 300;		
		
		weapon1 = new SingleBarrelMachineGun(x, y);	
		weapon2 = null;
		
		remove = false;
		
		visible = true;
		
		
	}
		

	
	public void setDecrementLife(){
		
		lives --;
		
		invincible_timer = 0;
		invincible = true;		
		
		
	}
	
	public boolean isInvincible(){
		return this.invincible;
	}
	

	public void update(float dt){
						
			
			if(invincible){
				
				blink_timer += dt;
				
				if(blink_timer > blink_time){
					if(visible){
						visible = false;
					}
					else{
						visible = true;
					}
					blink_timer = 0;
				}
								
			}
			
			
			

			if(invincible){
				
				invincible_timer += dt;
				
				if(invincible_timer > invincible_time){
					invincible_timer = 0;
					invincible = false;
					visible = true;
				}
			}
		
				
			for(int i=0;i<PlayState.capsules.size();i++){
				
				if( this.intersects(PlayState.capsules.get(i))){
					PlayState.capsules.get(i).remove = true;
				
					
					switch(PlayState.capsules.get(i).getType()){
					
						
					case WeaponTypes.SINGLE_BARREL_MACHINE_GUN:
						this.weapon1 = new SingleBarrelMachineGun(x, y);
						
						break;
			
					case WeaponTypes.TRIPLE_BARREL_MACHINE_GUN:
						this.weapon1 = new TripleBarrelMachineGun(x, y);
						
						break;
			
					case WeaponTypes.FIVE_BARREL_MACHINE_GUN:
						this.weapon1 = new FiveBarrelMachineGun(x, y);
						
						break;
			
					case WeaponTypes.SINE_MACHINE_GUN:
						this.weapon1 = new SineMachineGun(x, y);
						
						
						break;
			
					case WeaponTypes.CROSS_MACHINE_GUN:
						this.weapon1 = new CrossMachineGun(x, y);
						
						break;
			
						
						
					case WeaponTypes.LASER_GUN:
						this.weapon2 = new LaserGun(x, y);
						
						break;
			
					case WeaponTypes.TIME_BOMB_GUN:
						this.weapon2 = new TimeBombGun(x, y);
						
						break;
			
					case WeaponTypes.ENEMY_CHASER_GUN:
						this.weapon2 = new EnemyChaserGun(x, y);
						
						break;
			
					case WeaponTypes.DOUBLE_LINEAR_MISSILE_GUN:
						this.weapon2 = new DoubleLinearMissileGun(x, y);
						
						break;
			
					case WeaponTypes.DOUBLE_LASER_GUN:
						this.weapon2 = new DoubleLaserGun(x, y);
						
						break;
			
					
					
					}
					
					
				
				
				}
				
			}
			
		
				
		
		
		if(weapon1 != null){
			weapon1.setX(x);
			weapon1.setY(y);
		}
		
		
		
		if(weapon2 != null){
			weapon2.setX(x);
			weapon2.setY(y);
		}
			
		if(left && ((x - speed*dt - this.width/2) > 0)){
			x -= speed*dt;
		}
		
		if(right && ((x + speed*dt + this.width/2) < Game.GAME_WIDTH)){
			x += speed*dt;
		}
		
		if(up && ((y + speed*dt + this.height/2) < Game.GAME_HEIGHT)){
			y += speed*dt;
		}
		
		if(down && ((y - speed*dt - this.height/2) > 0)){
			y-=speed*dt;
			
		}

		
		if(weapon1 != null){
			weapon1.update(dt);
		}
		
		if(weapon2 != null){
			weapon2.update(dt);
		}
	}
	
	
	public void draw(ShapeRenderer sr){
		
		if(visible){
		
			sr.begin(ShapeType.Line);
			
			sr.rect(x - width/2, y - height/2, width, height);
			
			sr.end();
				
		}
		
		
		
		if(weapon1 != null){
			weapon1.draw(sr);
		}
		
		if(weapon2 != null){
			weapon2.draw(sr);
		}
		
	}
	

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////SETTERS AND GETTERS//////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public void setUp(boolean b){
		up = b;
		
	}
	
	public void setDown(boolean b){
		
		down = b;
		
	}
	
	public void setLeft(boolean b){
		
		left = b;
		
	}
	
	public void setRight(boolean b){
		
		right = b;
		
	}
	
	public void setShootA(boolean b){
				
		if(weapon1 != null)
			weapon1.setShoot(b);
		
	}
	
	public void setShootB(boolean b){
		
		if(weapon2 != null)
			weapon2.setShoot(b);
		
	}
	
	
	
	public boolean getUp(){
		return up;
	}
	
	public boolean getDown(){
		return down;	
	}
		
	public boolean getLeft(){
		return left;
	}
	
	public boolean getRight(){
		return right;
	}

	
}
