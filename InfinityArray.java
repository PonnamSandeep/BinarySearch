package binarySearch;

public class InfinityArray {

	public static void main(String[] args) {
		int[] nums= {3,5,7,9,10,90,100,130,140,160,170};
		int target=10;
		System.out.println(ans(nums,target));
		

	}
	static int ans(int[] nums, int target) {
		//first find the range
		//first start with the size of box size 2
		int start=0;
		int end=1;
		
		//condition for the target to lie in the range
		while(target > nums[end]) {
			int newStart = end + 1;
			//double the box value
			//end= end plus sizeofbox * 2
			end = end + (end - start + 1) * 2;
			start = newStart;
			
		}
		return binarySearch(nums,target,start,end);
		
	}
	static int binarySearch(int[] nums, int target,int start, int end) {
	
	 while(start<=end) 
	  {
	   int mid = start + (end-start)/2;
	    if(target==nums[mid]) {
		   return mid;
	   }
	   
	   if(target>nums[mid]) {
		   
		   start=mid+1;
	   }
	   else if(target<nums[mid]){
		   
		   end=mid-1;
	   }
	   else {
		   // ans  found
		   return mid;
	   }
	   
	   }
	
		return -1;
	}
  
}
