import java.util.HashSet;
import java.util.Set;

public class AnyDuplicates {
	
	public static boolean anyDuplicates(int [] arr, int k){
		Set<Integer> s = new HashSet<>();
		int n = arr.length;
		for(int i=0;i<=k;i++){
			s.add(arr[i]);
		}
		if(s.size()!=k+1){
			return true;
		}
		s.remove(arr[0]);
		for(int i=1;i<=n-1-k;i++){
			s.remove(i-1);
			if(s.contains(arr[i+k])) return true;
			else s.add(arr[i+k]);
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[]  = new int[]{1,2,3,5,4,6};
		System.out.println(anyDuplicates(arr, 2));

	}

}
