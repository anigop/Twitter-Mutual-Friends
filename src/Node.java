import java.util.ArrayList;


public class Node {

	/*
	 * integer of the original too big for java to handle, first read in as string
	 * and then converted to biginteger once the calculations are complete.
	 */
	private String id;
	private ArrayList<Node> ingress;
	private ArrayList<Node> egress;
	
	public Node(){
		ingress = new ArrayList<Node>();
		egress = new ArrayList<Node>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Node> getIngress() {
		return ingress;
	}

	public void setIngress(ArrayList<Node> ingress) {
		this.ingress = ingress;
	}

	public ArrayList<Node> getEgress() {
		return egress;
	}

	public void setEgress(ArrayList<Node> egress) {
		this.egress = egress;
	}
	
	
}
