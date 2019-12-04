package permutation;

import java.util.*;

/*
 * Please revisit this problem.... Got to understand this condition correctly
 */

public class Combinations {
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (n == 0) {
			return res;
		}
		List<Integer> list = new ArrayList<Integer>();
		combination(res, list, 1, n, k);
        return res;
    }
	
	public static void combination(
			List<List<Integer>> res,
			List<Integer> list,
			int index,
			int n, int k) {
		if (list.size() > k) {
			return;
		}
		if (list.size() == k) {
			List<Integer> copyList = new ArrayList<Integer>(list);
			res.add(copyList);
			return;
		}
		
		for(int i = index; i <= n; i++) {
			list.add(i);
			// index is to set the next start position
			// i + 1 is to prevent duplicate and back track such as
			// [3, 3], [1, 4] with [4, 1]
			combination(res, list, i+1, n, k);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		List<List<Integer>> res = combine(4, 2);
		System.out.println(res.size());
		for(List a : res) {
			System.out.println(a);
		}
	}
}
