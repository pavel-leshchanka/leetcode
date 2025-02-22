package solutions.task_1431;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1431. Kids With the Greatest Number of Candies
 * There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.
 * Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.
 * Note that multiple kids can have the greatest number of candies.
 */
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ret = new ArrayList<>(candies.length);
        int max = Arrays.stream(candies).max().orElseThrow();
        for (int candy : candies) {
            ret.add(candy + extraCandies >= max);
        }
        return ret;
    }
}
