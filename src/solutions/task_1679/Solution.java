package solutions.task_1679;

import java.util.Arrays;

/**
 * 1679. Max Number of K-Sum Pairs
 * You are given an integer array nums and an integer k.
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 * Return the maximum number of operations you can perform on the array.
 */
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int firstC = 0;
        int secondC = nums.length - 1;

        while (firstC < secondC) {
            int i = nums[firstC] + nums[secondC];
            if (i == k) {
                count++;
                firstC++;
                secondC--;
            } else if (i > k) {
                secondC--;
            } else {
                firstC++;
            }
        }
        return count;
    }
}