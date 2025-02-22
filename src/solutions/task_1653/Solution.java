package solutions.task_1653;
/**
 * 1653. Minimum Deletions to Make String Balanced
 * You are given a string s consisting only of characters 'a' and 'b'​​​​.
 * You can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.
 * Return the minimum number of deletions needed to make s balanced.
 */

import java.util.Arrays;

class Solution {
    public int minimumDeletions(String s) {
        char[] charArray = s.toCharArray();
        int[] countA = new int[charArray.length];
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i - 1] == 'a') {
                countA[i] = countA[i - 1] + 1;
            } else {
                countA[i] = countA[i - 1];
            }
        }
        int temp = 0;
        for (int i = charArray.length - 2; i >= 0; i--) {
            if (charArray[i + 1] == 'b') {
                temp++;
                countA[i] += temp;
            } else {
                countA[i] += temp;
            }
        }
        int i = Arrays.stream(countA).max().orElseThrow() + 1;
        return charArray.length - i;
    }
}