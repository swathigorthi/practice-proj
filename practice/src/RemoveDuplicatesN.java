import java.util.Arrays;

public class RemoveDuplicatesN {
	
	static int[] removeDuplicatesN(int[] arr, int N){
		int i=0,j=1, l=0;
		int n= arr.length;
		while(j<n){
			if(arr[i]==arr[j]){
				j++;
				l++;
				if(l<N) i++;
			}
			else{
				l=0;
				i++;
				arr[i] = arr[j];
				j++;
			}
		}
		return Arrays.copyOf(arr, i+1);
	}

	public static void main(String[] args) {
		int [] arr = new int[]{1,1,1,2,2,3, 3, 3};
		int [] output = removeDuplicatesN(arr, 1);
		int l = output.length;
		for(int i =0;i<l;i++){
			System.out.println(output[i]);
		}

	}

}
