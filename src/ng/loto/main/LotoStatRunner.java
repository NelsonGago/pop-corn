package ng.loto.main;

import java.util.HashMap;
import java.util.Map;

import ng.loto.entities.Position;
import ng.loto.util.NumberCollector;

public class LotoStatRunner {

	public static void main(String[] args) throws Exception {
		
		NumberCollector nc = new NumberCollector();
		
		// the int contains the 
		Map<String, int[]> tirages = nc.getQuebec49TirageNumbers(2017);
		
		/*
		Map<String, int[]> tirages =  new HashMap<String, int[]>();
		tirages.put("2017-12-30", new int[] {2, 18, 22, 23, 28, 48, 33});
		tirages.put("2017-12-27", new int[] {10, 12, 14, 30, 40, 45, 11});
		tirages.put("2017-12-23", new int[] {7, 24, 28, 34, 35, 46, 21});
		tirages.put("2017-12-20", new int[] {5, 11, 16, 33, 45, 47, 31});
		tirages.put("2017-12-16", new int[] {4, 8, 16, 36, 43, 47, 18});		
		tirages.put("2017-12-13", new int[] {9, 12, 14, 30, 39, 40, 8});
		tirages.put("2017-12-09", new int[] {1, 15, 20, 21, 35, 43, 25});	
		tirages.put("2017-12-06", new int[] {10, 11, 15, 19, 44, 46, 22});	
		tirages.put("2017-12-02", new int[] {1, 21, 26, 28, 37, 44, 25});
		
		*/

		// crate the 7 positions
		Position position1 =  new Position(1);
		Position position2 =  new Position(2);
		Position position3 =  new Position(3);
		Position position4 =  new Position(4);
		Position position5 =  new Position(5);
		Position position6 =  new Position(6);
		Position position7 =  new Position(7);
		

		//Map<Integer, Integer> pairs =  new HashMap<Integer, Integer>();
		for (Map.Entry<String, int[]> entry : tirages.entrySet())
		{
			
			// add the members to each position
			position1.addMember(entry.getValue()[0]);
			position2.addMember(entry.getValue()[1]);
			position3.addMember(entry.getValue()[2]);
			position4.addMember(entry.getValue()[3]);
			position5.addMember(entry.getValue()[4]);
			position6.addMember(entry.getValue()[5]);
			position7.addMember(entry.getValue()[6]);
			
		}
		
		// Print positions
		position1.toString();
		position2.toString();
		position3.toString();
		position4.toString();
		position5.toString();
		position6.toString();
		position7.toString();

	}
	
}
