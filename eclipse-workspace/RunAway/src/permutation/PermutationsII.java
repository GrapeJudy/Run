package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Please revisit this problem.... Got to understand this condition correctly
 */
public class PermutationsII {
	// first sort
	public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
        	return res;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        boolean[] occupied = new boolean[nums.length];
        Arrays.sort(nums);
        permute(res, list, nums, occupied, 0);
        return res;
    }
	
	public static void permute(
			List<List<Integer>> res,
			List<Integer> list,
			int[] nums,
			boolean[] occupied,
			int index
	) {
		if (list.size() > nums.length) {
			return;
		}
		
		if (list.size() == nums.length) {
			List<Integer> copyList = new ArrayList<Integer>(list);
			System.out.println("first list");
			System.out.println(copyList);
			res.add(copyList);
			return;
		}
		
		// since it starts with 0, the index that has it should be skipped.
		for(int i = 0; i < nums.length; i++) {
			System.out.println("i: " + i + " occupied[i]: " + occupied[i] + " index: " + index);
			if (i > 0) {
				System.out.println("i - 1 occupation: " + occupied[i-1]);
			}
			// this step is important..
			// if nums[i] == nums[i - 1] meaning we're going through duplicate value
			// use i and i -1 since it has to be the latter one that reappear, first time is fine
			if (i > 0 && nums[i] == nums[i - 1] && !occupied[i -1]) {
				///aaah it's isn't occupied!!!
				//occuplied meanning it's just normal iteration
				continue;
			}
			if(!occupied[i]) {
				System.out.println("this time i and index and value: " + i + " " + index + " " + nums[i]);
				occupied[i] = true;
				list.add(nums[i]);
				permute(res, list, nums, occupied, index+1);
				list.remove(list.size() - 1);
				occupied[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 1};
		List<List<Integer>> res = permuteUnique(nums);
		System.out.println(res.size());
		for(List a : res) {
			System.out.println(a);
		}
	}
}
