package solutions.task_643;

/**
 * 643. Maximum Average Subarray I
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average
 * value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 */
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int maxSum;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        maxSum = sum;

        for (int i = 0; i < nums.length - k; i++) {
            sum += nums[i + k] - nums[i];
            if (sum > maxSum) maxSum = sum;
        }
        return (double) maxSum / k;
    }
}