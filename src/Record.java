import java.util.ArrayList;


public class Record {

	private String id;
	private ArrayList<String> followers;
	
	public Record(){
		followers = new ArrayList<String>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<String> getFollowers() {
		return followers;
	}

	public void setFollowers(ArrayList<String> followers) {
		this.followers = followers;
	}
	
}
