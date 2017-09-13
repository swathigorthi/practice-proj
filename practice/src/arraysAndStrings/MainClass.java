package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
    private static Integer[][] array2D = new Integer[4][];
    static {
  	  array2D[0] = new Integer[]{0,1,0,1};
  	  array2D[1] = new Integer[]{0,0,1,1};
  	  array2D[2] = new Integer[]{0,0,0,0};
  	  array2D[3] = new Integer[]{1,1,0,0};
  	  
    }
    
    public static char[] removeDuplicates(char[] charArray){
   	 boolean[] flags = new boolean[256];
   	 
   	 int n = charArray.length;
   	 int j= 1;
   	 int i;
   	 for(i=0;i<n;i++){
   		 char c = charArray[i];
   		 int pos = (int) c;
   		 if(flags[pos]){
   			
   			 while(j<n){
   				c = charArray[j];
   			    pos = (int) c;
   			    if(!flags[pos] || j == n-1){
   			    	break;
   			    }
   			    j++;
   			 }
   			 if(j<n){
   				 charArray[i] = c;
   				 flags[pos] = true;
   			 }
   			 else{
   				 break;
   			 }
   		 }else{
   			 flags[pos]=true;
   		 }
         if(i+1 == j){
   			 j++;
   		 }
   	 }
   	 return Arrays.copyOfRange(charArray, 0, i);
    }
    public static void main(String[] args) {
//        System.out.println(StringUtil.hasAllUniqueChar("abc"));
//        System.out.println(StringUtil.reverseCString("ABCDE"));
       // System.out.println(StringUtil.getAllPossibleStrings(265L).toString());
           //  ArrayUtil.getMineClusters(array2D);
    	
    	//System.out.println(ArrayUtil.getMinimumHops(new int[]{1,3,5,8,9,2,6,7,6,8,9}));
        
        System.out.println(String.valueOf(removeDuplicates("abcaadae".toCharArray())));
    }
    

}
