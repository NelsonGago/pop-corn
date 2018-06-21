package ng.loto.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Position {
	
	int positionIndex;
	List<Integer> positionMembers; 
	Map<Integer, Integer> memberOccurrences;
	
	/**
	 * @param pPositionIndex
	 */
	public Position(int pPositionIndex) {
		
		positionIndex = pPositionIndex;
		positionMembers = new ArrayList<Integer>();
		// Each member has a key (it self) pointing to the number of occurrences
		memberOccurrences = new HashMap<Integer, Integer>();
		
	}
	
	public void addMember(int pMember) {
		
		// if not added add it 
		if(!positionMembers.contains(pMember)) positionMembers.add(pMember);
		
		// increment member occurrences if member already exists in map
		if (memberOccurrences.containsKey(pMember)){			
			int occurrences  = memberOccurrences.get(pMember);
			memberOccurrences.put(pMember, occurrences + 1);
		}else {
			memberOccurrences.put(pMember, 1);
		}		
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb =  new StringBuilder();
		sb.append("\nPosition-").append(positionIndex);
		sb.append("\nContains ").append(positionMembers.size()).append(" unique numbers");
	    sb.append("\nThe tree top numbers are:");
	    sb.append("\n").append(memberOccurrences.toString());
	    
	    
	    
	    
	    System.out.println(sb.toString());
	    
		return "";
	}
	

}
