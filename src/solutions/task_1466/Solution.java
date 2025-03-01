package solutions.task_1466;

import java.util.ArrayList;
import java.util.List;

/**
 * 1466. Reorder Routes to Make All Paths Lead to the City Zero
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 * It's guaranteed that each city can reach city 0 after reorder.
 */

class Solution {
    public int minReorder(int n, int[][] connections) {
        boolean[] isCompleted = new boolean[n];
        List<List<int[]>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int[] connection = connections[i];
            lists.get(connection[0]).add(connection);
            lists.get(connection[1]).add(connection);
        }
        return dfs(lists, isCompleted, 0);
    }

    public int dfs(List<List<int[]>> connections, boolean[] isCompleted, int start) {
        int count = 0;
        isCompleted[start] = true;
        for (int[] anInt : connections.get(start)) {
            int i0 = anInt[0];
            int i1 = anInt[1];
            if (i1 == start && !isCompleted[i0]) {
                count += dfs(connections, isCompleted, i0);
            }
            if (i0 == start && !isCompleted[i1]) {
                count++;
                count += dfs(connections, isCompleted, i1);
            }
        }
        return count;
    }
}
