
public class Main {

	public static void main(String[] args) {
		if(args.length == 0){
			ComputeMaxCorrelation.start("inputs-large.json");
			
		}else{
			/*
			 * First parameter treated as input file to override
			 */
			ComputeMaxCorrelation.start(args[0]);
		}
	}
}
