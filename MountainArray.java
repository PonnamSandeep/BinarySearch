package binarySearch;

public class MountainArray {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,3,1};
		System.out.println(peakIndexInMountainArray(arr));

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
	

}
