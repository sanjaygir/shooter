package game;

public class GameKeys {

	
	public static boolean keys[]  = new boolean[6];
	public static boolean prev_keys[] = new boolean[6];
	
	
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	public static final int SHOOT_A = 4;
	public static final int SHOOT_B = 5;
	

	public static boolean getState(int k){
		return keys[k];
	}
	
	public static void setState(int k, boolean v){
		
		keys[k] = v;
		
		
	}
	
	public static void updatePrevKeys(){
		
		for(int i=0;i<6;i++){
			prev_keys[i] = keys[i];
		}
		
	}
	
	public static boolean isPressed(int k){
		return keys[k] && !prev_keys[k];
	}
	
	
}
