package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class LevelLoader {
		
	private ArrayList<String> lines;
	
		
	public void stripComments(String path){
		

		String raw = "";
		
		try{
			
			FileReader fr = new FileReader(path);
			
			BufferedReader br = new BufferedReader(fr);
			
			
			int c;
			
			while((c = br.read()) != -1){
				
				raw += (char)c;
				
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		String to_be_outputted = "";
		
		int i;
		
		for(i=0;i<raw.length();i++){
						
			
			if(raw.charAt(i) == '/' && raw.charAt(i+1) == '*'){
				
				i++;
				
				while(true){
					
					i++;
					
					if(raw.charAt(i) == '*' && raw.charAt(i+1) == '/') {
						i++;
						
						
						break;}
					
				}				
				
			}
			else{
				to_be_outputted += raw.charAt(i);
			}
			
			
			
		}
		
		
		
		
		try{
			
			FileWriter fw = new FileWriter("temp.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(to_be_outputted);
			bw.close();
			
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
	public LevelLoader(String path){
		
		lines = new ArrayList<String>();
		
		
		
		stripComments(path);
		
			
		
		
		try{
		
			BufferedReader reader = new BufferedReader(new FileReader("temp.txt"));
			
			
			String line = null;
			
			while((line = reader.readLine())!=null){
				
				if (line.equals("")) continue;
				
				
				if(hasComments(line)) continue;
				
				
				String[] parts = line.split("\\s+");
				
				if(parts.length != 0){
								
					lines.add(line);
					
				}
					
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public boolean hasComments(String s){
		
		for(int i=0;i<s.length();i++){
			
			if(s.charAt(i) == '/') return true;			
		}
		
		return false;
	}
	
	public ArrayList<ToGenerateToken> getToGenerateTokens(){
		
		ArrayList<ToGenerateToken> tokens = new ArrayList<ToGenerateToken>();
		
		for(int i=0;i<lines.size();i++){
			
			ToGenerateToken token = new ToGenerateToken();
						
			String[] parts = lines.get(i).split("\\s+");
	
			String type = parts[0];
			
			
			if(type.equals("SL")){
			
				token.type = ToGenerateTokenTypes.SL;
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.hp = Float.parseFloat(parts[5]);
				token.speed = Float.parseFloat(parts[6]);
				token.time_delay = Float.parseFloat(parts[7]);
								
			}
			else if(type.equals("SLG")){
				
				token.type = ToGenerateTokenTypes.SLG;
				

				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.hp = Float.parseFloat(parts[5]);
				token.speed = Float.parseFloat(parts[6]);
				token.time_delay = Float.parseFloat(parts[7]);
				token.num_units = Float.parseFloat(parts[8]);
				token.time_between_units = Float.parseFloat(parts[9]);
				
			}
			else if(type.equals("C")){
								

				token.type = ToGenerateTokenTypes.C;
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.hp = Float.parseFloat(parts[5]);
				token.speed = Float.parseFloat(parts[6]);
				token.time_delay = Float.parseFloat(parts[7]);
				token.init_angle = Float.parseFloat(parts[8]);
				token.angle_turn_amount = Float.parseFloat(parts[9]);
				token.turn_start_time = Float.parseFloat(parts[10]);
				token.turn_stop_angle = Float.parseFloat(parts[11]);
							
				
				
			}
			else if(type.equals("CG")){


				token.type = ToGenerateTokenTypes.CG;
				
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.hp = Float.parseFloat(parts[5]);
				token.speed = Float.parseFloat(parts[6]);
				token.time_delay = Float.parseFloat(parts[7]);
				token.init_angle = Float.parseFloat(parts[8]);
				token.angle_turn_amount = Float.parseFloat(parts[9]);
				token.turn_start_time = Float.parseFloat(parts[10]);
				token.turn_stop_angle = Float.parseFloat(parts[11]);
				token.num_units = Float.parseFloat(parts[12]);
				token.time_between_units = Float.parseFloat(parts[13]);
							
				
			}
			else if(type.equals("MAT")){
				
				token.type = ToGenerateTokenTypes.MAT;
				
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.hp = Float.parseFloat(parts[5]);
				token.speed = Float.parseFloat(parts[6]);
				token.time_delay = Float.parseFloat(parts[7]);
				token.march_angle = Float.parseFloat(parts[8]);
				token.transition_time = Float.parseFloat(parts[9]);
				token.gravity = Float.parseFloat(parts[10]);
				token.jump_velocity = Float.parseFloat(parts[11]);
				token.jump_angle = Float.parseFloat(parts[12]);

				
			}
			else if(type.equals("MATG")){

				
				token.type = ToGenerateTokenTypes.MATG;
				
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.hp = Float.parseFloat(parts[5]);
				token.speed = Float.parseFloat(parts[6]);
				token.time_delay = Float.parseFloat(parts[7]);
				token.march_angle = Float.parseFloat(parts[8]);
				token.transition_time = Float.parseFloat(parts[9]);
				token.gravity = Float.parseFloat(parts[10]);
				token.jump_velocity = Float.parseFloat(parts[11]);
				token.jump_angle = Float.parseFloat(parts[12]);

				token.num_units = Float.parseFloat(parts[13]);
				token.time_between_units = Float.parseFloat(parts[14]);
				
			}
			else if(type.equals("TB")){
				
				token.type = ToGenerateTokenTypes.TB;
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.hp = Float.parseFloat(parts[5]);
				token.speed = Float.parseFloat(parts[6]);
				token.time_delay = Float.parseFloat(parts[7]);
				token.shoot_interval = Float.parseFloat(parts[8]);
				token.shoot_direction = parts[9];
				
			}
			else if(type.equals("TBG")){
				
				token.type = ToGenerateTokenTypes.TBG;
				
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.hp = Float.parseFloat(parts[5]);
				token.speed = Float.parseFloat(parts[6]);
				token.time_delay = Float.parseFloat(parts[7]);
				token.shoot_interval = Float.parseFloat(parts[8]);
				token.shoot_direction = parts[9];
				token.num_units = Float.parseFloat(parts[10]);
				token.time_between_units = Float.parseFloat(parts[11]);
				
			}
			else if(type.equals("TP")){
				
				token.type = ToGenerateTokenTypes.TP;
				
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.hp = Float.parseFloat(parts[5]);
				token.speed = Float.parseFloat(parts[6]);
				token.time_delay = Float.parseFloat(parts[7]);
				token.init_direction = Float.parseFloat(parts[8]);
				token.path_change_time = Float.parseFloat(parts[9]);
				token.turn_angle = Float.parseFloat(parts[10]);
				
				
			}
			else if(type.equals("TPG")){
				
				token.type = ToGenerateTokenTypes.TPG;
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.hp = Float.parseFloat(parts[5]);
				token.speed = Float.parseFloat(parts[6]);
				token.time_delay = Float.parseFloat(parts[7]);
				token.init_direction = Float.parseFloat(parts[8]);
				token.path_change_time = Float.parseFloat(parts[9]);
				token.turn_angle = Float.parseFloat(parts[10]);
				
				token.num_units = Float.parseFloat(parts[11]);
				token.time_between_units = Float.parseFloat(parts[12]);
				
			}
			else if(type.equals("B")){
				
				token.type = ToGenerateTokenTypes.B;
				
				token.time_delay = Float.parseFloat(parts[1]);
				
				
			}
			else if(type.equals("WC")){
				
				token.type = ToGenerateTokenTypes.WC;
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.hp = Float.parseFloat(parts[5]);
				token.speed = Float.parseFloat(parts[6]);
				token.time_delay = Float.parseFloat(parts[7]);
				
				token.place = parts[8];
				token.enter_from = parts[9];
				
				
			}
			else if(type.equals("P_SBMG")){
				
				token.type = ToGenerateTokenTypes.P_SBMG;
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.speed = Float.parseFloat(parts[5]);
				token.time_delay = Float.parseFloat(parts[6]);
				
			}
			else if(type.equals("P_CMG")){
				

				token.type = ToGenerateTokenTypes.P_CMG;
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.speed = Float.parseFloat(parts[5]);
				token.time_delay = Float.parseFloat(parts[6]);
				
			}
			else if(type.equals("P_ECG")){
				
				token.type = ToGenerateTokenTypes.P_ECG;
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.speed = Float.parseFloat(parts[5]);
				token.time_delay = Float.parseFloat(parts[6]);
				
			}
			else if(type.equals("P_DLMG")){
				
				token.type = ToGenerateTokenTypes.P_DLMG;
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.speed = Float.parseFloat(parts[5]);
				token.time_delay = Float.parseFloat(parts[6]);
				
				
			}
			else if(type.equals("P_TBMG")){
				
				token.type = ToGenerateTokenTypes.P_TBMG;
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.speed = Float.parseFloat(parts[5]);
				token.time_delay = Float.parseFloat(parts[6]);
				
				
			}
			else if(type.equals("P_FBMG")){

				token.type = ToGenerateTokenTypes.P_FBMG;
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.speed = Float.parseFloat(parts[5]);
				token.time_delay = Float.parseFloat(parts[6]);
				

			}
			else if(type.equals("P_TBG")){
				
				token.type = ToGenerateTokenTypes.P_TBG;
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.speed = Float.parseFloat(parts[5]);
				token.time_delay = Float.parseFloat(parts[6]);
				
				
			}
			else if(type.equals("P_SMG")){
				
				token.type = ToGenerateTokenTypes.P_SMG;
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.speed = Float.parseFloat(parts[5]);
				token.time_delay = Float.parseFloat(parts[6]);
				
				
				
			}
			else if(type.equals("P_LG")){
				
				token.type = ToGenerateTokenTypes.P_LG;
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.speed = Float.parseFloat(parts[5]);
				token.time_delay = Float.parseFloat(parts[6]);
				

				
				
			}
			else if(type.equals("P_DLG")){
				
				
				token.type = ToGenerateTokenTypes.P_DLG;
				
				token.x = Float.parseFloat(parts[1]);
				token.y = Float.parseFloat(parts[2]);
				token.width = Float.parseFloat(parts[3]);
				token.height = Float.parseFloat(parts[4]);
				token.speed = Float.parseFloat(parts[5]);
				token.time_delay = Float.parseFloat(parts[6]);
				

			}
			
			tokens.add(token);			
			
		}
			
		
		return tokens;
		
		
	}
	
	
	
}
