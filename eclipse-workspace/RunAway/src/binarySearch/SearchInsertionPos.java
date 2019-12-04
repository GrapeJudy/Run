package binarySearch;

public class SearchInsertionPos {
	public static int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        return searchHelper(0, nums.length - 1, target, nums);
    }
	
	public static int searchHelper(int left, int right, int target, int[] nums) {
		int mid = (left + right) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		
		if (nums[mid] < target) {
			return right > mid ? searchHelper(mid + 1, right, target, nums) : right + 1;
		}
		
		else {
			return left < mid ? searchHelper(left, mid - 1, target, nums) : left;
		}
	}
	public static void main(String[] args) {
//		int[] arr = {1, 3, 5, 6};
		int[] arr = {1, 5, 6, 8, 9, 10, 14, 16};
		System.out.println(searchInsert(arr, 15));
	}
}
