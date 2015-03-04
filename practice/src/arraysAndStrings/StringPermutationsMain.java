package arraysAndStrings;

import java.util.HashSet;
import java.util.Set;

public class StringPermutationsMain {
	
	public static Set<String> permute(String str){
		Set<String> permutedStrings = new HashSet<>();
		int length = str.length();
		if(length==1){
			permutedStrings.add(str);
		}
		else{
			for(int i=0;i<length;i++){
				String ch =String.valueOf(str.charAt(i));
				String remString =(i==0 ? str.substring(1): str.substring(0, i)+str.substring(i+1));
				for(String s : permute(remString)){
					permutedStrings.add(ch+s);
				}
			}
		}
		return permutedStrings;
	}

	public static void main(String[] args) {
		String str = "str";
		System.out.println(permute(str));
	}

}
