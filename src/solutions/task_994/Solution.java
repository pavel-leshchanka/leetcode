package solutions.task_994;

import java.util.LinkedList;

/**
 * 994. Rotting Oranges
 * You are given an m x n grid where each cell can have one of three values:
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is
 * impossible, return -1.
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        LinkedList<int[]> ints = new LinkedList<>();

        int height = grid.length;
        int length = grid[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                int i1 = grid[i][j];
                if (i1 == 2) {
                    ints.add(new int[]{i, j});
                }
            }
        }
        int steps = -1;
        if (ints.isEmpty()) steps = 0;

        while (!ints.isEmpty()) {
            steps++;
            int size = ints.size();

            for (int i = 0; i < size; i++) {
                int[] poll = ints.poll();
                int pointY = poll[0];
                int pointX = poll[1];

                int moveD = pointY + 1;
                int moveU = pointY - 1;
                int moveR = pointX + 1;
                int moveL = pointX - 1;

                if (moveR < length && grid[pointY][moveR] == 1) {
                    ints.add(new int[]{pointY, moveR});
                    grid[pointY][moveR] = 2;
                }
                if (moveL >= 0 && grid[pointY][moveL] == 1) {
                    ints.add(new int[]{pointY, moveL});
                    grid[pointY][moveL] = 2;
                }
                if (moveD < height && grid[moveD][pointX] == 1) {
                    ints.add(new int[]{moveD, pointX});
                    grid[moveD][pointX] = 2;
                }
                if (moveU >= 0 && grid[moveU][pointX] == 1) {
                    ints.add(new int[]{moveU, pointX});
                    grid[moveU][pointX] = 2;
                }
            }
        }
        for (int[] value : grid) {
            for (int j = 0; j < length; j++) {
                if (value[j] == 1) return -1;
            }
        }
        return steps;
    }
}