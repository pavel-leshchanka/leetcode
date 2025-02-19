package solutions.task_2390;

/**
 * 2390. Removing Stars From a String
 * You are given a string s, which contains stars *.
 * In one operation, you can:
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star itself.
 * Return the string after all stars have been removed.
 * Note:
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 */

class Solution {
    public String removeStars(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int count = 0;
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = stringBuilder.charAt(i);
            if (c != '*') {
                stringBuilder1.append(c);
                count++;
            } else {
                count--;
                stringBuilder1.deleteCharAt(count);
            }
        }
        return stringBuilder1.toString();
    }
}