package binarySearch;

public class Sqrt {
	
	public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
        	return x;
        }
        
        int start = 1, end = x;
        int res = 1;
        while(start <= end) {
        	int mid = (start + end) / 2;
        	int tmp = mid * mid;
        	if (tmp == x) {
        		return mid;
        	}
        	
        	if (tmp < x) {
        		start = mid + 1;
        		res = mid;
        	}
        	else if(tmp > x) {
        		end =  mid - 1;
        	}
        }
        return res;
        
    }
	public static void main(String[] args) {
		System.out.println(mySqrt(3));
	}
}
