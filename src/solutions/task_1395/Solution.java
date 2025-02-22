package solutions.task_1395;

/**
 * 1395. Count Number of Teams1395. Count Number of Teams
 * There are n soldiers standing in a line. Each soldier is assigned a unique rating value.
 * You have to form a team of 3 soldiers amongst them under the following rules:
 * Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
 * A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
 * Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).
 */
class Solution {
    public int numTeams(int[] rating) {
        if (rating.length < 3) return 0;
        int res = 0;
        for (int i = 1; i < rating.length - 1; i++) {
            int smaler1 = 0;
            int bigger1 = 0;
            int smaler2 = 0;
            int bigger2 = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) smaler1++;
                else bigger2++;
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[i] < rating[j]) bigger1++;
                else smaler2++;
            }
            res = res + smaler1 * bigger1 + smaler2 * bigger2;
        }
        return res;
    }
}
