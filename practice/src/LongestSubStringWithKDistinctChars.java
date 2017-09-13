import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithKDistinctChars {
	
	public static int findLength(String s, int k){
		if(s == null || s == "" || s.length() == 0){
			return 0;
		}
		int l = s.length();
		if(k > l){
			return l;
		}
		Set<Character> mainSet = new HashSet<>();
		int maxLen = 0;
		int start = 0;
		for(int i = 0; i < l; i++){
			char c = s.charAt(i);
			mainSet.add(c);
			if(mainSet.size() > k){
				maxLen = Math.max(maxLen, i-start);
				Set<Character> temp = new HashSet<>();
                for(int j = i ; j >= start; j--){
				    char t = s.charAt(j);
					temp.add(t);
					if(temp.size() > k){
						mainSet.remove(t);
						start = j + 1;
						break;
					}
				}
			}
			if(i == l-1){
				maxLen = Math.max(maxLen, i-start+1);
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		System.out.println(findLength("abcadcacacaca", 3));
		System.out.println(findLength("abcbbbbcccbdddadacb", 2));
		

	}

}
