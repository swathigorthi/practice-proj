import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {
	
	 public static int[] twoSum(int[] nums, int target) {
	        List<Integer> list = new ArrayList<>();
	        findSum(nums, target, list, 0);
	        int[] result = new int[list.size()];
	        for(int i = 0;i<list.size();i++){
	            result[i] = list.get(i);
	        }
	        return result;
	    }
	    
	    public static boolean  findSum(int[] nums, int target, List<Integer> list, int start){
	        if(start > nums.length-1){
	            return false;
	        }
	        if(start == nums.length-1){
	            if(nums[start] == target){list.add(start); return true;}
	            return false;
	        }
	        for(int i = start; i< nums.length;i++){
	            int cur = nums[i];
	            if(findSum(nums, target-cur, list, start+1)){
	                list.add(i);
	                return true;
	            }
	        }
	        return false;
	    }

	public static void main(String[] args) {
		
	 int[] A = new int[] {3,2,4};
	 int[] B = twoSum(A, 6);
	 System.out.println(B.length);
	}

}
