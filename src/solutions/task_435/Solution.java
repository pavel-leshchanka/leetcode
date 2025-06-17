package solutions.task_435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. Non-overlapping Intervals
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of
 * intervals you need to remove to make the rest of the intervals non-overlapping.
 * Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3]
 * are non-overlapping.
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, Comparator.comparing((int[] ints) -> ints[0]));
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[1] < end) {
                end = interval[1];
                count++;
            } else if (interval[0] < end && interval[1] >= end) {
                count++;
            } else {
                end = interval[1];
            }
        }
        return count;
    }
}