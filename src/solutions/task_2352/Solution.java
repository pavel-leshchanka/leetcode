package solutions.task_2352;

/**
 * 2352. Equal Row and Column Pairs
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj)
 * such that row ri and column cj are equal.
 * A row and column pair is considered equal if they contain the same elements in
 * the same order (i.e., an equal array).
 */

class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                for (int k = 0; k < grid.length; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        break;
                    }
                    if (k == grid.length - 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}