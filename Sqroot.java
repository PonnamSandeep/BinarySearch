package binarySearch;

public class Sqroot {

	public static void main(String[] args) {
//		int a=10;
//		System.out.println(a<<1);
//		System.out.println(a>>2);
		
		System.out.println(sqroot(35));
	}
	
	public static int sqroot(int x) {
		
//		return (int) Math.pow(x, 0.5);
		if(x<2) {
			return x;
		}
		int start=1;
		int end=x-1;
		int ans=0;
		while(start<=end) {
			int mid=start+(end-start)/2;
			int sqrt=mid*mid;
			if(sqrt==x) {
				return mid;
			}
			if(sqrt>x) {
				end=mid-1;
			}
			else {
				ans=mid;
				start=start+1;
			}
			
		}
		return ans;
	}

}
