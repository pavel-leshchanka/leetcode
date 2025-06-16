package solutions.task_1318;

/**
 * 1318. Minimum Flips to Make a OR b Equal to c
 * Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make
 * ( a OR b == c ). (bitwise OR operation).
 * Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
 */
class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        int dash = 0;
        while (a != 0 || b != 0 || c != 0) {
            int a1 = a >> dash;
            int b1 = b >> dash;
            int c1 = c >> dash;
            int ba = a1 & 1;
            int bb = b1 & 1;
            int bc = c1 & 1;
            a ^= (ba << dash);
            b ^= (bb << dash);
            c ^= (bc << dash);
            dash++;
            if ((ba | bb) != bc) count++;
            if (bc == 0 && ba == 1 && ba == bb) count++;
        }
        return count;
    }
}
