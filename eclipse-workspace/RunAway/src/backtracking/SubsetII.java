package backtracking;

import java.util.*;

/*
 * For this problem I need print illustration to figure out the problem..
 */
public class SubsetII {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(nums == null || nums.length == 0) {
        	return res;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        subsets(res, list, nums, 0);
        return res;
    }
	
	public static void subsets(
			List<List<Integer>> res,
			List<Integer> list,
			int[] nums,
			int index) {
		if (index > nums.length) {
			return;
		}
		
		List<Integer> copy = new ArrayList<Integer>(list);
		res.add(copy);
//		System.out.println("After: index: " + index + " " + res);
//		System.out.println();
		
		for(int i = index; i < nums.length; i++) {
			if (i > index && nums[i - 1] == nums[i]) 
				continue;
//			System.out.println("Before: index: " + index + " i: " + i + " " + res);
			list.add(nums[i]);
			subsets(res, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 2};
		List<List<Integer>> res = subsetsWithDup(nums);
		System.out.println(res.size());
		for(List<Integer> list : res) {
			System.out.println(list);
		}
	}
}
