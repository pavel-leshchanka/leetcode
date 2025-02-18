package solutions.task_1004;

/**
 * 1004. Max Consecutive Ones III
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in
 * the array if you can flip at most k 0's.
 */
class Solution {
    public int longestOnes(int[] nums, int k) {
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
        return size;
    }
}
