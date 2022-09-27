package arrays;

public class BinarySearch {

	public static void main(String[] args) {
		
		int[] nums = {-11,-18,0,1,2,6,7,89,112,456};
		int target = 0;
		
		System.out.println(binarySearch(nums,target));

	}

	private static int binarySearch(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		boolean isAsc = nums[start] < nums[end];
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(isAsc) {
				
				if(target == nums[mid]) {
					return mid;
				}
				if(target > nums[mid]) {
					start = mid + 1;
				} else if(target < nums[mid]) {
					end = mid - 1;
				}
			} else {
				if(target < nums[mid]) {
					start = mid + 1;
				} else if(target > nums[mid]) {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

}
