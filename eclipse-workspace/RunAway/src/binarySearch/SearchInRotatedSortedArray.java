package binarySearch;

public class SearchInRotatedSortedArray {
	// just follow a normal pattern then do the search,
	// it's like a greed binary search
	
	public static int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			
			if (nums[left] <= nums[mid]) {
				if(target <= nums[mid] && target >= nums[left]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			else {
				if (nums[mid] < target && target <= nums[right]) {
					left =  mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
        return -1;
    }
	public static void main(String[] args) {
		
	}
}
