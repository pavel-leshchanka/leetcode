package solutions.task_338;

/**
 * 338. Counting Bits
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number
 * of 1's in the binary representation of i.
 */
class Solution {
    public int[] countBits(int n) {
        int[] ints = new int[n + 1];
        ints[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            int number = i;
            int count = 0;
            while (number != 0) {
                number &= (number - 1);
                count++;
            }
            ints[i] = count;
        }
        return ints;
    }
}
