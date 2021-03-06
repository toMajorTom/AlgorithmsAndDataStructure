package map_and_set;

import java.util.HashSet;
import java.util.Set;

//给定一个整数数组和一个整数k，找出数组中是否有两个不同的索引i和j，
//使得nums[i]和nums[j]之间的绝对差至多为t，i和j之间的绝对差至多为k。 j - i <= k
public class V_LeetCode219 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(set.contains(nums[i])) //替换成 nums[i]和nums[j]之间的绝对差至多为t条件
				return true;
			set.add(nums[i]);
			if(set.size() == k +1) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}
}
