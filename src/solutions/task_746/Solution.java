package solutions.task_746;

/**
 * 746. Min Cost Climbing Stairs
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] ints = new int[n];
        ints[0] = cost[0];
        ints[1] = cost[1];
        for (int i = 2; i < n; i++) {
            ints[i] = cost[i] + Math.min(ints[i - 1], ints[i - 2]);
        }
        return Math.min(ints[n - 1], ints[n - 2]);
    }
}
