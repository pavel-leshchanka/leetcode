package solutions.task_283;

/**
 * 283. Move Zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 */

class Solution {
    public void moveZeroes(int[] nums) {
        for (int j = 0; j < nums.length-1; j++) {
            for (int i = 0; i < nums.length-1; i++) {
                if (nums[i] == 0) {
                    int swap = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = swap;
                }
            }
        }
    }
}
