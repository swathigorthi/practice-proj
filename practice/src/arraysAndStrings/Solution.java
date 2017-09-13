package arraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
	    public static List<String> findItinerary(String[][] tickets) {
	        List<String> result = new ArrayList<>();
	        Map<String, PriorityQueue<String>> stpd = new HashMap<>();
	        for(int i=0;i<tickets.length;i++){
	            PriorityQueue<String> d = stpd.get(tickets[i][0]);
	            if(d==null){
	                d = new PriorityQueue<String>();
	                stpd.put(tickets[i][0], d);
	            }
	            d.offer(tickets[i][1]);
	        }
	       
	        result.add("JFK");
	        reconstruct(stpd, "JFK", result, tickets.length + 1);
	        return result;
	    }
	    
	    public static boolean reconstruct(Map<String, PriorityQueue<String>> map, String source, List<String> result, int length){
	        PriorityQueue<String> destList = map.get(source);
	        if(destList == null || destList.isEmpty()){
	            return result.size() == length;
	        }
	        Set<String> triedAndFailed = new HashSet<>();
	        while(!destList.isEmpty()){
	            String dest = destList.poll();
	            while(triedAndFailed.contains(dest)){
	                if(destList.isEmpty()){return false;}
	                   dest = destList.poll();
	            }
	            for(String s : triedAndFailed){
	                destList.offer(s);
	            }
	            result.add(dest);
	            if(reconstruct(map, dest, result, length)){
	                return true;
	            }
	            triedAndFailed.add(dest);
	            result.remove(result.size()-1);
	            destList.offer(dest);
	        }
	        return false;
	    }
	

	public static void main(String[] args) {
		String[][] input= new String[][]{{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},{"ANU","JFK"},{"ADL","ANU"},{"TIA","AUA"},{"ANU","AUA"},{"ADL","EZE"}};
		findItinerary(input);
	}

}
