package solutions.task_2462;

import java.util.PriorityQueue;

/**
 * 2462. Total Cost to Hire K Workers
 * You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.
 * You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:
 * You will run k sessions and hire exactly one worker in each session.
 * In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last
 * candidates workers. Break the tie by the smallest index.
 * For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will choose the 4th
 * worker because they have the lowest cost [3,2,7,7,1,2].
 * In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but
 * they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
 * If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them. Break the
 * tie by the smallest index.
 * A worker can only be chosen once.
 * Return the total cost to hire exactly k workers.
 */
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int currentLeft = 0;
        int currentRight = costs.length - 1;
        PriorityQueue<Integer> priorityQueueLeft = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueueRight = new PriorityQueue<>();
        if (costs.length >= candidates * 2) {
            for (int i = 0; i < candidates; i++) {
                priorityQueueLeft.add(costs[currentLeft]);
                currentLeft++;
                priorityQueueRight.add(costs[currentRight]);
                currentRight--;
            }
        } else {
            while (currentLeft <= currentRight) {
                priorityQueueLeft.add(costs[currentLeft]);
                currentLeft++;
                if (currentLeft <= currentRight) {
                    priorityQueueRight.add(costs[currentRight]);
                    currentRight--;
                }
            }
        }
        long salary = 0;
        for (int i = 0; i < k; i++) {
            if (priorityQueueLeft.peek() == null) {
                salary += priorityQueueRight.poll();
            } else if (priorityQueueRight.peek() == null) {
                salary += priorityQueueLeft.poll();
            } else if (priorityQueueLeft.peek() > priorityQueueRight.peek()) {
                salary += priorityQueueRight.poll();
                if (currentLeft <= currentRight) {
                    priorityQueueRight.add(costs[currentRight]);
                    currentRight--;
                }
            } else {
                salary += priorityQueueLeft.poll();
                if (currentLeft <= currentRight) {
                    priorityQueueLeft.add(costs[currentLeft]);
                    currentLeft++;
                }
            }
        }
        return salary;
    }
}