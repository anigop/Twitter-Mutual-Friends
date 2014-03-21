import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class FileOperations {

	public static GsonObject readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			String jsonString = "";
			
			while((line = br.readLine()) != null){
				jsonString += line;
			}
			
			Gson g = new Gson();
			GsonObject gInput = new GsonObject();
		    List<Record> list = g.fromJson(jsonString, new TypeToken<List<Record>>(){}.getType());
			gInput.setInput((ArrayList<Record>) list);
		    
			br.close();
			return gInput;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	public static void outputDump(ArrayList<OutputRecord> o){
		PrintWriter pw = null;
		try{
			String outputString = new Gson().toJson(o);
		    pw = new PrintWriter(new FileWriter("output-top3.json"));
			pw.println(outputString);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		if(pw != null){
			pw.close();
		}
		
	}
	
}
