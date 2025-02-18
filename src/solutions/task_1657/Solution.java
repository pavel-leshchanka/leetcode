package solutions.task_1657;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 1657. Determine if Two Strings Are Close
 * Two strings are considered close if you can attain one from the
 * other using the following operations:
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into
 * another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and
 * false otherwise.
 */
class Solution {
    public boolean closeStrings(String word1, String word2) {
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();
        if (charArray1.length != charArray2.length)
            return false;
        Map<Character, Integer> objects1 = new HashMap<>();
        Map<Character, Integer> objects2 = new HashMap<>();
        for (int i = 0; i < charArray1.length; i++) {
            objects1.put(charArray1[i], objects1.getOrDefault(charArray1[i], 0) + 1);
            objects2.put(charArray2[i], objects2.getOrDefault(charArray2[i], 0) + 1);
        }
        Collection<Integer> values = objects1.values().stream().sorted().toList();
        Collection<Integer> values1 = objects2.values().stream().sorted().toList();
        boolean equals = values.equals(values1);
        Set<Character> characters1 = objects1.keySet();
        Set<Character> characters2 = objects2.keySet();
        boolean equals1 = characters1.equals(characters2);
        return equals && equals1;
    }
}
