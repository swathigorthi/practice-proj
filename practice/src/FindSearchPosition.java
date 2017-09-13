
public class FindSearchPosition {
	
	public static int searchInsert(int[] nums, int target) {
        return searchInsert(nums, 0, nums.length-1, target);
    }
    
    public static int searchInsert(int[] nums, int start, int end, int target){
        if(start<=end){
            return nums[start] >= target ? start : start+1;
        }
        int mid = (start+end)/2;
        if(nums[mid] >= target){
            return searchInsert(nums, start, mid-1, target);
        }
        else{
            return searchInsert(nums, mid+1, end, target);
        }
    }

	public  static void main(String[] args) {
		System.out.println(searchInsert(new int[]{1,3}, 4));

	}

}
