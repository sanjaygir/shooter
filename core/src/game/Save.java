package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.badlogic.gdx.Gdx;

public class Save {
		
	public static void save(Score s){
		
		try{
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("highscores.sav"));
			
			out.writeObject(s);
			out.close();
						
		}
		catch(Exception e){
			e.printStackTrace();
			Gdx.app.exit();
		}
		
	}
	
	
	public static int load(){
		
		try{
			
			if(!saveFileExists()){
				return -1;
			}
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("highscores.sav"));
			
			int sc = ((Score)in.readObject()).getScore();
			
			in.close();
			return sc;
			
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			
			return -1;
		}
		
	}
	

	public static boolean saveFileExists(){
		
		File f = new File("highscores.sav");
		return f.exists();
		
	}


	
	
}
