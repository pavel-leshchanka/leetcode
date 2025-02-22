package solutions.task_443;

/**
 * 443. String Compression
 * Given an array of characters chars, compress it using the following algorithm:
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 * After you are done modifying the input array, return the new length of the array.
 * You must write an algorithm that uses only constant extra space.
 */
class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        } else {
            int charNumber = 0;
            char firstChar = chars[0];
            int arrayLength = 0;
            for (char ch : chars) {
                if (firstChar == ch) {
                    arrayLength++;
                } else {
                    chars[charNumber] = firstChar;
                    firstChar = ch;
                    charNumber++;
                    if (arrayLength != 1) {
                        int length = String.valueOf(arrayLength).length();
                        int cloneLength = length;
                        while (arrayLength > 0) {
                            chars[charNumber + length - 1] = (char) (arrayLength % 10 + 48);
                            arrayLength /= 10;
                            length--;
                        }
                        charNumber += cloneLength;
                    }
                    arrayLength = 1;
                }
            }
            chars[charNumber] = firstChar;
            charNumber++;
            if (arrayLength != 1) {
                int length = String.valueOf(arrayLength).length();
                int cloneLength = length;
                while (arrayLength > 0) {
                    chars[charNumber + length - 1] = (char) (arrayLength % 10 + 48);
                    arrayLength /= 10;
                    length--;
                }
                charNumber += cloneLength;
            }
            return charNumber;
        }
    }
}
