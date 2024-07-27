package solutions.task_2976;

import java.util.Arrays;

//2976. Minimum Cost to Convert String I
/*
 * You are given two 0-indexed strings source and target, both of length n and consisting of lowercase English letters. You are also given two 0-indexed character arrays original and changed, and an integer array cost, where cost[i] represents the cost of changing the character original[i] to the character changed[i].
 * You start with the string source. In one operation, you can pick a character x from the string and change it to the character y at a cost of z if there exists any index j such that cost[j] == z, original[j] == x, and changed[j] == y.
 * Return the minimum cost to convert the string source to the string target using any number of operations. If it is impossible to convert source to target, return -1.
 * Note that there may exist indices i, j such that original[j] == original[i] and changed[j] == changed[i].
 * */
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int maxValue = Integer.MAX_VALUE;
        int countLetters = 26;
        int[][] distanceMatrix = new int[countLetters][countLetters];
        long ret = 0;
        char[] sourceCharArray = source.toCharArray();
        char[] targetCharArray = target.toCharArray();
        for (int i = 0; i < countLetters; i++) {
            Arrays.fill(distanceMatrix[i], maxValue);
            distanceMatrix[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            distanceMatrix[original[i] - 97][changed[i] - 97] = Math.min(distanceMatrix[original[i] - 97][changed[i] - 97], cost[i]);
        }
        for (int k = 0; k < countLetters; k++) {
            for (int i = 0; i < countLetters; i++) {
                for (int j = 0; j < countLetters; j++) {
                    int change;
                    if (distanceMatrix[i][k] == Integer.MAX_VALUE || distanceMatrix[k][j] == Integer.MAX_VALUE) {
                        change = Integer.MAX_VALUE;
                    } else {
                        change = distanceMatrix[i][k] + distanceMatrix[k][j];
                    }
                    distanceMatrix[i][j] = Math.min(distanceMatrix[i][j], change);
                }
            }
        }
        for (int i = 0; i < source.length(); i++) {
            int matrix = distanceMatrix[sourceCharArray[i] - 97][targetCharArray[i] - 97];
            if (matrix == maxValue) {
                ret = 0;
                break;
            } else {
                ret += matrix;
            }
        }
        if (ret == 0 || ret == Integer.MAX_VALUE) return -1L;
        return ret;
    }
}