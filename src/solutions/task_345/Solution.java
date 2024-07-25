package solutions.task_345;

import java.util.ArrayList;
import java.util.Set;

//345. Reverse Vowels of a String
/*
 * Given a string s, reverse only all the vowels in the string and return it.
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 * */
class Solution {
    public String reverseVowels(String s) {
        Set<Character> a = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        ArrayList<Character> objects = new ArrayList<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (a.contains(charArray[i])) {
                objects.add(charArray[i]);
            }
        }
        for (int i = 0; i < charArray.length; i++) {
            if (a.contains(charArray[i])) {
                charArray[i] = objects.getLast();
                objects.removeLast();
            }
        }
        return String.valueOf(charArray);
    }
}