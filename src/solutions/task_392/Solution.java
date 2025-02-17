package solutions.task_392;

/**
 * 392. Is Subsequence
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some
 * (can be none) of the characters without disturbing the relative positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */

class Solution {
    public boolean isSubsequence(String s, String t) {

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        if (charArrayS.length == 0 && charArrayT.length == 0) return true;
        if (charArrayT.length == 0) return false;
        if (charArrayS.length == 0) return true;

        int j = 0;
        for (char c : charArrayT) {
            if (c == charArrayS[j]) {
                j++;
            }
            if (charArrayS.length == j) {
                return true;
            }
        }
        return false;
    }
}