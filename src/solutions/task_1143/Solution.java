package solutions.task_1143;

/**
 * 1143. Longest Common Subsequence
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int max = 0;
        int[] ints = new int[text1.length()];
        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();
        for (int i = 0; i < charArray2.length; i++) {
            int cur = 0;
            for (int j = 0; j < charArray1.length; j++) {
                if (cur < ints[j]) {
                    cur = ints[j];
                } else if (charArray1[j] == charArray2[i]) {
                    ints[j] = cur + 1;
                    max = Math.max(max, cur + 1);
                }
            }
        }
        return max;
    }
}
