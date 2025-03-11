package solutions.task_215;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 215. Kth Largest Element in an Array
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
