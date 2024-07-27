package solutions.task_334;

import java.util.Arrays;

//334. Increasing Triplet Subsequence
/*
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 * */
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int max = Arrays.stream(nums).max().orElseThrow();
        int min = Arrays.stream(nums).min().orElseThrow();
        if (nums.length < 3) return false;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] != min) {
                for (int j = i; j < nums.length - 1; j++) {
                    if (nums[i] < nums[j]) {
                        for (int k = j; k < nums.length; k++) {
                            if (nums[k] != max) {
                                if (nums[j] < nums[k]) {
                                    return true;
                                }
                            } else {
                                if (nums[j] < nums[k]) {
                                    return true;
                                }
                                break;
                            }
                        }
                    }
                }
            } else {
                for (int j = i; j < nums.length - 1; j++) {
                    if (nums[i] < nums[j]) {
                        for (int k = j; k < nums.length; k++) {
                            if (nums[k] != max) {
                                if (nums[j] < nums[k]) {
                                    return true;
                                }
                            } else {
                                if (nums[j] < nums[k]) {
                                    return true;
                                }
                                break;
                            }
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }
}
