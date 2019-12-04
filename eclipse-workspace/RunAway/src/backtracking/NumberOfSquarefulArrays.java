package backtracking;

import java.util.*;

/*
 * omg I wrote up the version correctly.. though I need the duplication check.
 * Pay more attention to the duplicate condition but ..overall better than I thought.
 */
public class NumberOfSquarefulArrays {
	public static int numOfSquarefulPermutations = 0;
	
	public static int numSquarefulPerms(int[] A) {
		List<Integer> list = new ArrayList<Integer>();
		boolean[] used = new boolean[A.length];
		Arrays.sort(A);
		helper(A, list, used);
		System.out.println(numOfSquarefulPermutations);
		return numOfSquarefulPermutations;
    }
	
	public static void helper(
			int[] A,
			List<Integer> list,
			boolean[] used) {
		int n = A.length;
		if (list.size() > n) {
			return;
		}
		
		if (list.size() == n) {
			numOfSquarefulPermutations++;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if (used[i]) continue;
			if (i > 0 && !used[i-1] && A[i] == A[i - 1]) continue;
			if (!list.isEmpty() && !isSquareNumber(list.get(list.size() - 1) + A[i])) {
				continue;
			}
			
			list.add(A[i]);
			used[i] = true;
			helper(A, list, used);
			list.remove(list.size() - 1);
			used[i] = false;

		}
	}
	
	public static boolean isSquareNumber(int num) {
		int a = (int)Math.sqrt((double)num);
		return a * a == num;
	}
	
	public static void main(String[] args) {
//		int[] A = {1, 17, 8};
		int[] A = {2, 2, 2};
		int res = numSquarefulPerms(A);
	}
}
