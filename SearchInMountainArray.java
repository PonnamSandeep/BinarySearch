package binarySearch;

public class SearchInMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5,3,1};
		int target=3;
		System.out.println(search(arr,target));
	}
	
	static int search(int[] arr, int target) {
		int peak=peakIndexInMountainArray(arr);
		int firstTry=binarySearch(arr,target,0,peak);
		if(firstTry!=-1) {
			return firstTry;
		}
		//try to search in second half
		return binarySearch(arr,target,peak+1,arr.length-1);
		
	}
	
	static int peakIndexInMountainArray(int[] arr) {
		int start=0;
		int end=arr.length-1;
		while(start<end) {
			int mid=start+ (end-start)/2;
			if(arr[mid]> arr[mid+1]) {
				// you are in dec part of the array
				// this may be the ans, but look at left
				// this is why end != mid-1
				end = mid;
			}else {
				//you are in ascending part
				start=mid+1; // because we know that mid+1 element is greater than mid element 
			}
		}
		//in the end, start==end and pointing to the largest number because of the above two checks
		// start and ends are always trying to find max element in the above 2 checks 
		// hence when they are pointing to just one element, that is max one  because that is what checks say
		//more elaboration: at every point of time for start and end, they have the best possible answer till that time
		// and if we are saying that only one item is remaining, hence cuz of above line that is the best possible ans
		return start; // or return end because both are same
	}
	static int binarySearch(int[] nums, int target, int start,int end) {
		
		boolean isAsc=nums[start]<nums[end];
	    
	 while(start<=end) 
	  {
		 //find the middle element
	   int mid = start + (end-start)/2;
	   if(isAsc) {
	    if(target==nums[mid]) {
		   return mid;
	   }
	   
	   if(target>nums[mid]) {
		   
		   start=mid+1;
	   }
	   else if(target<nums[mid]){
		   
		   end=mid-1;
	   }
	   }
	   else {
		   if(target<nums[mid]) {
			   
			   start=mid+1;
		   }
		   else if(target>nums[mid]){
			   
			   end=mid-1;
		   }
	   }
	 }
	
		return -1;
	}


}
