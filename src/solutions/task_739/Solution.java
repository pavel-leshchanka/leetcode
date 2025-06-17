package solutions.task_739;

import java.util.Stack;

/**
 * 739. Daily Temperatures
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
 * is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for
 * which this is possible, keep answer[i] == 0 instead.
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        Stack<Integer> ints = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!ints.isEmpty() && temperatures[i] > temperatures[ints.peek()]) {
                Integer peek = ints.pop();
                days[peek] = i - peek;
            }
            ints.push(i);
        }
        return days;
    }
}