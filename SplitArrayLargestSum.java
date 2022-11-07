package binarySearch;

public class SplitArrayLargestSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {7,2,5,10,8};
		int m=2;
		System.out.println(splitArray(nums,m));

	}
	
	static int splitArray(int[] nums,int m) {
		int start=0;
		int end=0;
		for(int i=0;i<nums.length;i++) {
			start=Math.max(start, nums[i]); //in the end this contain max item
			end +=nums[i];
		}
		
		//binary search
		while(start<end) {
			//try middle as potential ans 
			int mid = start+ (end-start)/2;
			//calculate how many pieces you can divide this in with max sum
			int sum=0;
			int pieces=1;
			for(int num:nums) {
				if(sum+num>mid) {
					//you can not add this in this sub array, make new one
					//say you add this num in the new subarray, then sum=num
					sum =num;
					pieces++;
				}else {
					sum+=num;
				}
			}
			if(pieces>m) {
				start=mid+1;
			}else {
				end=mid;
			}
		}
		return end; // here start=end
	}
        
}
