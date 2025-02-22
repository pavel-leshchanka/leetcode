package solutions.task_1071;

/**
 * 1071. Greatest Common Divisor of Strings
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 */
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder stringBuilder11 = new StringBuilder(str1);
        StringBuilder stringBuilder22 = new StringBuilder(str2);
        int min = stringBuilder22.length();
        if (stringBuilder22.length() > stringBuilder11.length()) {
            min = stringBuilder11.length();
        }
        StringBuilder dev = new StringBuilder();
        for (int i = 1; i <= min; i++) {
            StringBuilder stringBuilder1 = new StringBuilder(str1);
            StringBuilder stringBuilder2 = new StringBuilder(str2);
            StringBuilder builder = new StringBuilder(stringBuilder1.substring(0, i));
            while (stringBuilder1.length() >= i) {
                if (stringBuilder1.substring(0, i).compareTo(String.valueOf(builder)) == 0) {
                    stringBuilder1 = new StringBuilder(stringBuilder1.substring(i, stringBuilder1.length()));
                } else {
                    break;
                }
            }
            while (stringBuilder2.length() >= i) {
                if (stringBuilder2.substring(0, i).compareTo(String.valueOf(builder)) == 0) {
                    stringBuilder2 = new StringBuilder(stringBuilder2.substring(i, stringBuilder2.length()));
                } else {
                    break;
                }
            }
            if (stringBuilder1.length() == 0 && stringBuilder2.length() == 0) {
                dev = builder;
            }
        }
        return String.valueOf(dev);
    }
}
