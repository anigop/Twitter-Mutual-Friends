import java.util.ArrayList;
import java.util.HashMap;


public class Graph {

	private HashMap<String,Node> graph;
	
	public Graph(){
		graph = new HashMap<String,Node>();
	}
	
	
	public HashMap<String, Node> getGraph() {
		return graph;
	}


	public void setGraph(HashMap<String, Node> graph) {
		this.graph = graph;
	}

	/*
	 * 
	 * Building a graph containing each ID as a node, later a BFS can be performed for each node
	 * as root to find mutual nodes between root and root's second degree connections
	 */

	public void buildGraph(GsonObject g){
		ArrayList<Record> records = g.getInput();

		for(Record r : records){
			if(graph.get(r.getId()) == null){
				Node n = new Node();
				n.setId(r.getId());
				graph.put(r.getId(), n);
			}
			
			Node n = graph.get(r.getId());
			
			for(String i : r.getFollowers()){
				if(graph.get(i) == null){
					Node d = new Node();
					d.setId(i);
					graph.put(i, d);
				}
				
				Node d = graph.get(i);
				d.getEgress().add(n);
				n.getIngress().add(d);
			}
		}
		
	}
}
