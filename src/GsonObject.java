import java.util.ArrayList;


public class GsonObject {

	
	private ArrayList<Record> input;
	
	public GsonObject(){
		input = new ArrayList<Record>();
	}

	public ArrayList<Record> getInput() {
		return input;
	}

	public void setInput(ArrayList<Record> input) {
		this.input = input;
	}
	
}
