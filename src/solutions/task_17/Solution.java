package solutions.task_17;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number
 * could represent. Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */
class Solution {

    public static char[][] chars = new char[][]{
        new char[]{'a', 'b', 'c'},
        new char[]{'d', 'e', 'f'},
        new char[]{'g', 'h', 'i'},
        new char[]{'j', 'k', 'l'},
        new char[]{'m', 'n', 'o'},
        new char[]{'p', 'q', 'r', 's'},
        new char[]{'t', 'u', 'v'},
        new char[]{'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        List<String> strings = new ArrayList<>();
        char[] charArray = digits.toCharArray();
        if (charArray.length == 0) {
            return strings;
        }
        strings.add("");
        for (char c : charArray) {
            strings = makeString(strings, chars[c - 50]);
        }
        return strings;
    }

    public List<String> makeString(List<String> list, char[] chars) {
        ArrayList<String> strings = new ArrayList<>();
        for (String s : list) {
            for (char aChar : chars) {
                strings.add(s + aChar);
            }
        }
        return strings;
    }
}