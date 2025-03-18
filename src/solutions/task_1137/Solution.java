package solutions.task_1137;

/**
 * 1137. N-th Tribonacci Number
 * The Tribonacci sequence Tn is defined as follows:
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * <p>
 * Given n, return the value of Tn.
 */
class Solution {
    public static int[] three = new int[37];

    static {
        three[0] = 0;
        three[1] = 1;
        three[2] = 1;
        for (int i = 3; i < 37; i++) {
            three[i] = three[i - 1] + three[i - 2] + three[i - 3];
        }
    }

    public int tribonacci(int n) {
        return three[n];
    }
}
