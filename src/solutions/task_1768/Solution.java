package solutions.task_1768;

//1768. Merge Strings Alternately
/*
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 * Return the merged string.
 * */
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder out = new StringBuilder();
        StringBuilder str1 = new StringBuilder(word1);
        StringBuilder str2 = new StringBuilder(word2);
        int i1 = str1.length();
        int i2 = str2.length();
        int min = 0;
        int max = 0;
        if (i1 > i2) {
            min = i2;
            max = i1;
        } else {
            min = i1;
            max = i2;
        }
        for (int i = 0; i < min; i++) {
            out.append(str1.charAt(i));
            out.append(str2.charAt(i));
        }
        if (i1 > i2) {
            for (int i = min; i < max; i++) {
                out.append(str1.charAt(i));
            }
        } else {
            for (int i = min; i < max; i++) {
                out.append(str2.charAt(i));
            }
        }
        return String.valueOf(out);
    }
}
