import java.util.*;

public class Hard_ContainsDuplicateIII {
	public static boolean containsDuplicateIII(int[] num, int k, int t) {
		if (num == null || num.length == 0) {
			return false;
		}
		
		// [1,2,3,1], k = 3, t = 0
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int i = 0; i < num.length; i++) {
			int value = num[i];
			//lower value: value - t;
			//higher value: value + t;
			if((set.floor(value) != null && set.floor(value) + t >= value) ||
					(set.ceiling(value) != null && set.ceiling(value) -t <= value)) {
				return true;
			}
			set.add(value);
			if (i >= k) {
				set.remove(num[i-k]);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		
	}
}
