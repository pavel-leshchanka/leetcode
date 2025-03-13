package solutions.task_2300;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2300. Successful Pairs of Spells and Potions
 * You are given two positive integer arrays spells and potions, of length n and
 * m respectively, where spells[i] represents the strength of the ith spell and potions[j]
 * represents the strength of the jth potion.
 * You are also given an integer success. A spell and potion pair is considered successful
 * if the product of their strengths is at least success.
 * Return an integer array pairs of length n where pairs[i] is the number of potions that
 * will form a successful pair with the ith spell.
 */
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int potCount = potions.length;
        int spellCount = spells.length;
        int[] returns = new int[spellCount];
        int[][] ints = new int[spellCount][2];
        for (int i = 0; i < spellCount; i++) {
            ints[i][0] = spells[i];
            ints[i][1] = i;
        }
        Arrays.sort(ints, Comparator.comparing(s -> s[0]));
        Arrays.sort(potions);
        int position = 0;
        for (int i = spellCount - 1; i >= 0; i--) {
            int spell = ints[i][0];
            for (int j = position; j < potCount; j++) {
                int potion = potions[j];
                if (potion * (long) spell >= success) {
                    returns[ints[i][1]] = potCount - j;
                    position = j;
                    break;
                }
            }
        }
        return returns;
    }
}
