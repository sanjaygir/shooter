package game;

import java.io.Serializable;

public class Score implements Serializable{

	private int score = 0;	
	
	public Score(int s){
		score = s;
	}
	
	public int getScore(){
		return score;
	}
}
