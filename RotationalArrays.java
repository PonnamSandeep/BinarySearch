package binarySearch;

public class RotationalArrays {

	public static void main(String[] args) {
		// finding pivot
	int[] nums= {4,5,6,7,0,1,2};
	int target=0;
	System.out.println(findPivot(nums));
	System.out.println(search(nums,target));

	}
	static int search(int[]nums, int target) {
		int pivot=findPivot(nums);
		//if u did not find a pivot, it means the array is not rotated
		if(pivot==-1) {
			//just do normal search
			return binarySearch(nums,target,0,nums.length);
		}
		//if pivot is found, you have found 2 asc sorted arrays
		if(nums[pivot]==target) {
			return pivot;
		}
		if(target>=nums[0]) {
			return binarySearch(nums,target,0,pivot-1);
		}
		return binarySearch(nums,target,pivot+1,nums.length-1);
		
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
	static int findPivot(int[] arr) {
		int start=0;
		int end= arr.length-1;
		while (start<=end) {
			int mid=start+(end-start)/2;
			//4 cases are here
			if(arr[mid]>arr[mid+1] && mid<end ) {
				return mid;
			}
			if(arr[mid]<arr[mid-1]) {
				return mid-1;
			}
			if(arr[mid]<=arr[start]) {
				end=mid-1;
			}
			else {
				start=mid+1;
			}
		}
		return -1;
	}
	static int findPivotWithDuplicates(int[] arr) {
		int start=0;
		int end= arr.length-1;
		while (start<=end) {
			int mid=start+(end-start)/2;
			//4 cases are here
			if(arr[mid]>arr[mid+1] && mid<end ) {
				return mid;
			}
			if(arr[mid]<arr[mid-1]) {
				return mid-1;
			}
			//if elements at middle,start,end are equals, then skip the duplicates
			if(arr[mid]==arr[start]&& arr[mid]==arr[end]) {
				//skip duplicates
				
				//NOTE:  what if these start and end are pivot
				//check start is pivot
				if(arr[start]>arr[start+1]) {
					return start;
				}
				
				start++;
				
				//check end is pivot
				if(arr[end-1]>arr[end]) {
					return end;
				}
				end--;
			}
			//left side is sorted, so pivot should be in right
			else if(arr[start]<arr[mid]|| arr[start]==arr[mid]&& arr[mid]>arr[end] ) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		return -1;
	}

}
