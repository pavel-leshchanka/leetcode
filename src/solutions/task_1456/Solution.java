package solutions.task_1456;

import java.util.Set;

/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 * Given a string s and an integer k, return the maximum number
 * of vowel letters in any substring of s with length k.
 */
class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> characters;
        Character[] chars = {'a', 'e', 'i', 'o', 'u'};
        characters = Set.of(chars);
        char[] charArray = s.toCharArray();

        int sum = 0;
        int maxSum;
        for (int i = 0; i < k; i++) {
            if (characters.contains(charArray[i])) sum++;
        }
        maxSum = sum;

        for (int i = 0; i < charArray.length - k; i++) {
            char first = charArray[i];
            char last = charArray[i + k];
            boolean containsFirst = characters.contains(first);
            boolean containsLast = characters.contains(last);
            if (containsLast && !containsFirst) {
                sum++;
            } else if (!containsLast && containsFirst) {
                sum--;
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (maxSum == k) return k;
        }
        return maxSum;
    }
}
