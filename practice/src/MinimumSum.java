
public class MinimumSum {
	
	public static int minimumSum(int [] []arr){
		return minimumSum(arr, 0, 0 );
	}

	public static int minimumSum(int [][] arr, int i, int j){
		int currentSize = arr.length - i;
		if(currentSize==2){
			return arr[i][j] + Math.min(arr[i+1][j], arr[i+1][j+1]);
		}
		else{
			return arr[i][j] + Math.min(minimumSum(arr, i+1, j), minimumSum(arr, i+1, j+1));
		}
	}
	public static void main(String[] args) {
		int arr[][] = new int[][]{{2},{3,4}, {6,5,7}, {4,1,8,3}};
        System.out.println(minimumSum(arr));		

	}

}
