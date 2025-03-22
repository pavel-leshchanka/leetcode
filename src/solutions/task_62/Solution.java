package solutions.task_62;

/**
 * 62. Unique Paths
 * There is a robot on an m x n grid. The robot is initially located at the top-left
 * corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner
 * (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any
 * point in time.
 * Given the two integers m and n, return the number of possible unique paths that
 * the robot can take to reach the bottom-right corner.
 * The test cases are generated so that the answer will be less than or equal
 * to 2 * 109.
 */
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        int[][] ints = new int[m][n];
        ints[0][0] = 0;
        for (int i = 1; i < m; i++) {
            ints[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            ints[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ints[i][j] = ints[i - 1][j] + ints[i][j - 1];
            }
        }
        return ints[m - 1][n - 1];
    }
}