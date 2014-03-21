import java.math.BigInteger;
import java.util.ArrayList;


public class OutputRecord {

	private BigInteger id;
	private ArrayList<BigInteger> top3;
	
	public OutputRecord(){
		top3 = new ArrayList<BigInteger>();
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(String id) {
		this.id = new BigInteger(id);
	}

	public ArrayList<BigInteger> getTop3() {
		return top3;
	}

	public void setTop3(ArrayList<BigInteger> top3) {
		this.top3 = top3;
	}
	
	
}
