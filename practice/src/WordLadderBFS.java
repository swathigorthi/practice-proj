import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderBFS {
	
	static Set<String> dictionary = new HashSet<>(Arrays.asList("hit", "bit", "sit", "hat", "him", "rim", "bat", "sat", "fat", "cog", "cot", "hot"));
	static char[] charsArray = String.valueOf("abcdefghijklmnopqrstuvwxyz").toCharArray();
	
	
	public static Set<String> getChildrenNotVisited(String str, Map<String, String> parentMap, Set<String> visitedStrings){
		Set<String> childrenSet = new HashSet<>();
		for(int i=0;i<str.length();i++){
			char[] strArray = str.toCharArray();
			for(int j=0;j< charsArray.length;j++){
			    strArray[i ]= charsArray[j];
				String newStr = new String(strArray);
				if(!visitedStrings.contains(newStr) && dictionary.contains(newStr)){
					childrenSet.add(newStr);
					if(!parentMap.containsKey(newStr)){
						parentMap.put(newStr, str);
					}
				}
			}
		}
		return childrenSet;
	}
	
	public static int getPathLength(String str, Map<String, String> parentMap){
		int length = 1;
		while(parentMap.containsKey(str)){
			length++;
			str = parentMap.get(str);
		}
		return length;
	}
	
	public static int WordLadderBFS(String str1, String str2){
		List<String> queue = new ArrayList<>();
		Set<String> visitedStrings = new HashSet<>();
		queue.add(str1);
		String lastButOneString = "";
	    int sl = Integer.MAX_VALUE;
		int cl = 1;
		String prevParent = "";
		Map<String,String> parentMap = new HashMap<>();
		int i =0;
		while(!queue.isEmpty()){
			String str = queue.get(i);
			i++;
			if(visitedStrings.contains(str)){
				continue;
			}
			visitedStrings.add(str);
			String parent = parentMap.get(str);
			if(parent!=null && parent.equals(prevParent)){
				cl++;
			}
			if(cl>sl){
				break;
			}
			Set<String> childrenSet = getChildrenNotVisited(str, parentMap, visitedStrings);
			if(childrenSet.isEmpty()){
				continue;
			}
			else if(!childrenSet.contains(str2)){
				queue.addAll(childrenSet);
			}
			else{
				int l = getPathLength(str, parentMap);
				if(l<sl){
					sl = l;
					lastButOneString = str;
				}
			}
			if(parent!=null){
				prevParent = parent;
			}
		}
		while(parentMap.containsKey(lastButOneString)){
			System.out.println(lastButOneString);
			lastButOneString = parentMap.get(lastButOneString);
		}
		System.out.println(str1);
		return sl;
	}

	public static void main(String[] args) {
		System.out.println( WordLadderBFS("hit", "cog"));

	}

}
