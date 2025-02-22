package solutions.task_1334;

import java.util.Arrays;

/**
 * 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
 * There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.
 * Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.
 * Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.
 */
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int maxValue = Integer.MAX_VALUE;
        int[][] distanceMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distanceMatrix[i], maxValue);
            distanceMatrix[i][i] = 0;
        }
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            distanceMatrix[start][end] = weight;
            distanceMatrix[end][start] = weight;
        }
        floyd(n, distanceMatrix);
        return getCityWithFewestReachable(n, distanceMatrix, distanceThreshold);
    }

    void floyd(int n, int[][] distanceMatrix) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distanceMatrix[i][j] = Math.min(
                        distanceMatrix[i][j],
                        distanceMatrix[i][k] + distanceMatrix[k][j]
                    );
                }
            }
        }
    }

    int getCityWithFewestReachable(int n, int[][] distanceMatrix, int distanceThreshold) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = n;

        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (distanceMatrix[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }
            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }
}