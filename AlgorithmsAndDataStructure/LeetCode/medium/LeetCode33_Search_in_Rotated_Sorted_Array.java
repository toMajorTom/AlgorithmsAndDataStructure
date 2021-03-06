package medium;

public class LeetCode33_Search_in_Rotated_Sorted_Array {
	// 查询旋转数组中是否包含某个数
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == nums[mid])
				return mid;
			// 6 7 0 1 2 3 4 5
			// 这里取范围的意思是 [nums[left] < target < nums[mid]]
			if (nums[left] > nums[mid]) {
				if (nums[mid] > target || target >= nums[left])
					right = mid - 1;
				else
					left = mid + 1;
			} else if(nums[left] < nums[mid]){
				// 2 3 4 5 6 7 0 1
				// 这里取范围的意思是 [nums[mid] < target < nums[left]]
				if (nums[mid] < target || target < nums[left])
					left = mid + 1;
				else
					right = mid - 1;
			}else {
				left ++;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 2,3,4,5,6,1 };
		int res = new LeetCode33_Search_in_Rotated_Sorted_Array().search(arr, 1);
		System.out.println(res);
	}
}
