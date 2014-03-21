import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;



public class ComputeMaxCorrelation {

	public static final int TOP_N_RANKS = 3;
	private static ArrayList<OutputRecord> op;
	
	
	public static class Heapnode implements Comparable<Heapnode> {
		public String id;
		public int count;
		public int compareTo(Heapnode l){
			if(this.count < l.count){
				return 1;
			}
			return -1;
		}
	}
	
	/*
	 * 
	 * Traverse each node in the graph, to generate , first degree and the
	 * second degree connections of each node, making sure that none of the second
	 * degree connections is in the first degree pool.
	 * 
	 */
	public static  void start(String filename){
		GsonObject g = FileOperations.readFromFile(filename);
		Graph graph = new Graph();
		op = new ArrayList<OutputRecord>();
		
		graph.buildGraph(g);
		if(g.getInput().size() > 0){
			
			for(Record r : g.getInput()){
				
				if(graph.getGraph().get(r.getId()) != null){
					HashSet<Node> firstDegree = new HashSet<Node>();
					HashSet<Node> secondDegreeConnections = new HashSet<Node>();
					
					for(Node n : graph.getGraph().get(r.getId()).getIngress()){
						firstDegree.add(n);
					}
					
					for(Node n : firstDegree){
						for(Node d : n.getIngress()){
							if(!firstDegree.contains(d) && (!d.getId().equals(r.getId()))){
								secondDegreeConnections.add(d);
							}
						}
					}
					compute(r.getId() , firstDegree, secondDegreeConnections);
				}
			}
		}
		
		
		FileOperations.outputDump(op);
		System.out.println("Graph size "+op.size());
		System.out.println("Dumping json to output-top3.json");
		
		
	}
	
	/*
	 * For a given second degree connection of a node, number of outgoing edges, i.e the number 
	 * of first degree connections that the second degree node follows in calculated.
	 * 
	 * This count later added to a max heap, which is later used to calculate top 3 with most number
	 * of mutual connections
	 */
	public static void compute(String id  , HashSet<Node> firstDegree , HashSet<Node> secondDegreeConnections){
		
		PriorityQueue<Heapnode> heap = new PriorityQueue<Heapnode>();
		for(Node n : secondDegreeConnections){
			int count = 0;
			for(Node out : n.getEgress()){
				count = firstDegree.contains(out) ? count+1: count;
			}
			
			if(count > 0){
				Heapnode h = new Heapnode();
				h.count = count;
				h.id = n.getId();
				
				heap.add(h);
			}
		}
		
		
		OutputRecord o = new OutputRecord();
		int count = 0;
		o.setId(id);
		while(!heap.isEmpty() && count < TOP_N_RANKS){
			Heapnode h = heap.remove();
			o.getTop3().add(new BigInteger(h.id));
			count++;
		}
		
		
		System.out.println("<stdout>  id "+o.getId()+"   top3 "+o.getTop3());
		op.add(o);
		
	}
	
	
	
	
	
	
	
/*	
	public static void heaptest(){
		
		PriorityQueue<Heapnode> heap = new PriorityQueue<Heapnode>();
		
		Heapnode h = new Heapnode();
		h.count = 0;
		h.id = "3";
		
		
		Heapnode h1 = new Heapnode();
		h1.count = 2;
		h1.id = "5";
		
		Heapnode h2 = new Heapnode();
		h2.count = 2;
		h2.id = "5";
		
		
		heap.add(h);
		heap.add(h1);
		heap.add(h2);

		System.out.println(heap.remove().count);
		System.out.println(heap.remove().count);
		System.out.println(heap.remove().count);

	}
		
*/
	
	
}
