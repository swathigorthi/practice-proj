package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {
	
	public static int getMinimumHops(int[] array){
	
			return getMinimumHops(array, 0);
			
		
	}
	
	private static int getMinimumHops(int[] array, int i){
		if(array[i]==0){
			return array.length;
		}
		if(array[i]>array.length-1-i){
			return 1;
		}
		else{
			int min = getMinimumHops(array, i+1);
			for(int j=i+2 ;j<=array[i];j++){
				int currentMin =  getMinimumHops(array, j);
				if(currentMin<min){
					min = currentMin;
				}
			}
			return 1+min;
		}
	}
  
      
      public static void getMineClusters(Integer[][] array2D){
    	  boolean b[][] = new boolean[array2D.length][array2D[0].length];
    	  for(int i=0;i<array2D.length;i++){
    		  Integer[] array = array2D[i];
    		  for(int j=0;j<array.length;j++){
    			   Integer k = array[j];
    			   if(k==1 && !b[i][j]){
    				   getNeighbourMines(i, j, array2D, b);
    				   System.out.println();
    			   }
    		  }
    		  
    	  }
      }
      
      public static void getNeighbourMines(int i, int j, Integer[][] array2D, boolean[][] b){
    	   System.out.print("("+i+", "+j+")");
    	   b[i][j] = true;
    	   int dx[] = new int[]{-1,1,0,0,-1,-1,1,1};
    	   int dy[] = new int[] {0,0,-1,1,-1,1,-1,1};
    	   int m = array2D.length;
    	   int n= array2D[0].length;
    	   for(int k=0;k<dx.length;k++){
    		   int x = i+dx[k];
    		   int y=j+dy[k];
    		   if(x<0 || y<0 ||x>m-1||y>n-1|| array2D[x][y]==0 ||b[x][y]){
    			   continue;
    		   }
    		   getNeighbourMines(x,y, array2D, b);
    		   
    	   }
       }
      
}
