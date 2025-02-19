package solutions.task_394;

import java.util.LinkedList;

/**
 * 394. Decode String
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside
 * the square brackets is being repeated exactly k times. Note that k is
 * guaranteed to be a positive integer.
 * You may assume that the input string is always valid; there are no extra
 * white spaces, square brackets are well-formed, etc. Furthermore, you may
 * assume that the original data does not contain any digits and that digits
 * are only for those repeat numbers, k. For example, there will not be input
 * like 3a or 2[4].
 * The test cases are generated so that the length of the output will never
 * exceed 105.
 */

class Solution {
    static class Pair {
        public Integer key;
        public StringBuilder value;

        public Pair(Integer key, StringBuilder value) {
            this.key = key;
            this.value = value;
        }
    }

    public String decodeString(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder result = new StringBuilder();
        LinkedList<Pair> objects = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = charArray[i];
            if (Character.isDigit(c)) {
                count = count * 10 + c - 48;
            } else if (c == '[') {
                objects.add(new Pair(count, new StringBuilder()));
                count = 0;
            } else if (c == ']') {
                Pair pop = objects.pollLast();
                StringBuilder stringBuilder1 = new StringBuilder();
                for (int j = 0; j < pop.key; j++) {
                    stringBuilder1.append(pop.value);
                }
                Pair peek = objects.peekLast();
                if (peek != null) {
                    peek.value.append(stringBuilder1);
                } else {
                    result.append(stringBuilder1);
                }
            } else {
                if (objects.isEmpty()) {
                    result.append(c);
                } else {
                    objects.peekLast().value.append(c);
                }
            }
        }
        return result.toString();
    }
}