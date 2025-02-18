package solutions.task_1493;

/**
 * 1493. Longest Subarray of 1's After Deleting One Element
 * Given a binary array nums, you should delete one element from it.
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 */

class Solution {
    public int longestSubarray(int[] nums) {
        int k = 1;
        int zeroCount = 0;
        int lastArrIndex = 0;
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount < k) {
                size++;
                if (nums[i] == 0) {
                    zeroCount++;
                }
            } else if (zeroCount == k && nums[i] == 1) {
                size++;
            } else {
                if (nums[i] == 0) {
                    zeroCount++;
                }
                if (nums[lastArrIndex] == 0) {
                    zeroCount--;
                }
                lastArrIndex++;
            }
        }
        return size - 1;
    }
}