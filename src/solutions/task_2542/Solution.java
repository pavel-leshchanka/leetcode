package solutions.task_2542;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2542. Maximum Subsequence Score
 * You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k.
 * You must choose a subsequence of indices from nums1 of length k.
 * For chosen indices i0, i1, ..., ik - 1, your score is defined as:
 * The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
 * It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
 * Return the maximum possible score.
 * A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements.
 */
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] ints = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            ints[i][0] = nums1[i];
            ints[i][1] = nums2[i];
        }
        Arrays.sort(ints, Comparator.comparing(a -> -a[1]));
        long answer = 0;

        long sum = 0;
        PriorityQueue<Integer> objects = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            sum += ints[i][0];
            objects.add(ints[i][0]);
        }
        answer = sum * ints[k - 1][1];
        for (int i = k; i < nums1.length; i++) {
            objects.add(ints[i][0]);
            sum -= objects.poll();
            sum += ints[i][0];
            answer = Math.max(answer, sum * ints[i][1]);
        }
        return answer;
    }
}