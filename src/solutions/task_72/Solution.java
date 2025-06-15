package solutions.task_72;

/**
 * 72. Edit Distance
 * Given two strings word1 and word2, return the minimum number of operations required
 * to convert word1 to word2.
 * You have the following three operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 */
class Solution {
    public int minDistance(String word1, String word2) {
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();
        int[][] ints = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < word1.length() + 1; i++) {
            ints[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            ints[0][i] = i;
        }
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                int min = Math.min(ints[i][j + 1], ints[i + 1][j]);
                if (charArray1[i] == charArray2[j]) {
                    ints[i + 1][j + 1] = Math.min(min + 1, ints[i][j]);
                } else {
                    ints[i + 1][j + 1] = Math.min(min, ints[i][j]) + 1;
                }
            }
        }
        return ints[word1.length()][word2.length()];
    }
}
