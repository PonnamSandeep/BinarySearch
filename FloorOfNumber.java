package arrays;

public class FloorOfNumber {

	public static void main(String[] args) {
		
		int[] nums = {-11,-18,0,1,2,6,7,89,112,456};
		int target = 4;
		
		System.out.println(floor(nums,target));

	}

	private static int floor(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		boolean isAsc = nums[start] < nums[end];
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(target < nums[0]) {
				return -1;
			}
			
			if(isAsc) {
				
				if(target == nums[mid]) {
					return nums[mid];
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
		return nums[end];
	}

}
