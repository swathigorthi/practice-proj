package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    private static Integer[][] array2D = new Integer[4][];
    static {
  	  array2D[0] = new Integer[]{0,1,0,1};
  	  array2D[1] = new Integer[]{0,0,1,1};
  	  array2D[2] = new Integer[]{0,0,0,0};
  	  array2D[3] = new Integer[]{1,1,0,0};
  	  
    }
    public static void main(String[] args) {
//        System.out.println(StringUtil.hasAllUniqueChar("abc"));
//        System.out.println(StringUtil.reverseCString("ABCDE"));
       // System.out.println(StringUtil.getAllPossibleStrings(265L).toString());
           //  ArrayUtil.getMineClusters(array2D);
    	
    	System.out.println(ArrayUtil.getMinimumHops(new int[]{1,3,5,8,9,2,6,7,6,8,9}));
        
 
    }
    

}
