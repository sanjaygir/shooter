package player.weapons;

import game.BulletWeaponSystem;
import game.GameCharacterProperties;
import gamescreens.PlayState;
import player.weapons.bullets.TimeBombBullet;

public class TimeBombGun extends BulletWeaponSystem{

	
	
	private TimeBombBullet bullet;
	
	
	public TimeBombGun(float x, float y){
		
		super(x, y);
	
		shoot_time = GameCharacterProperties.TIME_BOMB_GUN_SHOOT_DELAY;
		shoot_timer = 0;
		
		targets = PlayState.enemies;
		
	}
	

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		super.update(dt);
		
		
		if(!cooling_down && shoot){
			
			bullet = new TimeBombBullet(x, y);
			bullet.setTargets(targets);
			bullet.setSpeed(GameCharacterProperties.TIME_BOMB_GUN_BULLET_SPEED);
			bullet.setDamage(GameCharacterProperties.TIME_BOMB_GUN_BULLET_DAMAGE);
			bullet.setExplodeTime(GameCharacterProperties.TIME_BOMB_GUN_BLAST_TIME);
			bullet.setBlastRadius(GameCharacterProperties.TIME_BOMB_GUN_BLAST_RADIUS);
			bullets.add(bullet);
			
			cooling_down = true;
			
		}
	
		
	
		
	}

	

}
