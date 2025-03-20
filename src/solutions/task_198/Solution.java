package solutions.task_198;

/**
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can
 * rob tonight without alerting the police.
 */
class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        int[] ints = new int[length];
        ints[0] = nums[0];
        ints[1] = nums[1];
        ints[2] = nums[2] + nums[0];
        for (int i = 3; i < length; i++) {
            ints[i] = nums[i] + Math.max(ints[i - 2], ints[i - 3]);
        }
        return Math.max(ints[length - 1], ints[length - 2]);
    }
}