package solutions.task_547;

/**
 * 547. Number of Provinces
 * There are n cities. Some of them are connected, while some are not. If city a is connected
 * directly with city b, and city b is connected directly with city c, then city a is connected
 * indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities
 * outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the
 * jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * Return the total number of provinces.
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int groupCount = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visit(isConnected, visited, i);
                groupCount++;
            }
        }
        return groupCount;
    }

    private void visit(int[][] isConnected, boolean[] visited, int i) {
        for (int j = 0; j < visited.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                visit(isConnected, visited, j);
            }
        }
    }
}