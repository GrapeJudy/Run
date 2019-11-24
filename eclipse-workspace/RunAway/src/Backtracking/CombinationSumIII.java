package Backtracking;

import java.util.*;

public class CombinationSumIII {
	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (k == 0 || n == 0) {
			return res;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		generateCombinations(res, list, k, n, 0, 1);
        return res;
    }
	
	public static void generateCombinations(
			List<List<Integer>> res,
			List<Integer> list,
			int k, int n, int sum, int index) {
		if (list.size() > k) {
			return;
		}
		
		if (sum == n && list.size() == k) {
			List<Integer> copy = new ArrayList<Integer>(list);
			res.add(copy);
			return;
		}
		
		for(int i = index; i <= 9; i++) {
				list.add(i);
				generateCombinations(res, list, k, n, sum + i, i + 1);
				list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		List<List<Integer>> res = combinationSum3(3, 9);
		System.out.println(res.size());
		for(List<Integer> l : res) {
			System.out.println(l);
		}
	}
}
