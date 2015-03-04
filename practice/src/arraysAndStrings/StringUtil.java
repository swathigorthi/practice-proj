package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
	public static String strArray[] = new String[]{"A","B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    public static boolean hasAllUniqueChar(String newString) {
        boolean[] booleanVaue = new boolean[256];
        for (int i = 0; i < newString.length(); i++) {
            int value = newString.charAt(i);
            if (booleanVaue[value]) {
                return false;
            }
            else {
                booleanVaue[value] = true;
            }
        }
        return true;
    }

    public static String reverseCString(String str) {
        String cString = str + '\n';
        int length = cString.length();
        char[] charArray = new char[length];
        charArray[length - 1] = '\n';
        for (int i = 0; i < length - 1; i++) {
            charArray[length - 1 - i] = cString.charAt(i);
        }
        return new String(charArray);
    }
    
    public static List<String> getAllPossibleStrings(Long number){
    	String numberString = number.toString();
        List<String> possibleStrings = new ArrayList<>();
        for(List<Integer> list : getPossibleStrings(numberString) ){
        	String str = "";
        	 for(Integer i : list){
        		 str+= strArray[i-1];
        	 }
        	 possibleStrings.add(str);
        }
    	return possibleStrings;
    }
    
    private static List<List<Integer>> getPossibleStrings(String str){
    	List<List<Integer>> possibleStrings = new ArrayList<>();
    	 if(str.length()==1){
    		 List<Integer> list = new ArrayList<>();
    		 Integer i = Integer.valueOf(str.substring(0, 1));
    		 list.add(i);
    		 possibleStrings.add(list);
    		 
    	 }
    	 else{
    		 Integer i0 = Integer.valueOf(str.substring(0, 1));
    		 String remStr = str.substring(1);
    	    for(List<Integer> list : getPossibleStrings(remStr)){
    	    	 List<Integer> newList = new ArrayList<>();
    	    	 newList.add(i0);
    	    	 newList.addAll(list);
    	    	 possibleStrings.add(newList);
    	    	 Integer i1 = 10*i0+list.get(0);
    	    	 if(i1<=26){
    	    		 List<Integer> newList1 = new ArrayList<>();
    	    		 newList1.add(i1);
    	    		 list.remove(0);
    	    		 newList1.addAll(list);
    	    		 possibleStrings.add(newList1);
    	    	 }
    	    }
    	 }
    	 return possibleStrings;
    }
}
