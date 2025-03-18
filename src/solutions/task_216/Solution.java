package solutions.task_216;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice,
 * and the combinations may be returned in any order.
 */
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        for (int i = 1; i < 11 - k; i++) {
            List<Integer> integers = new ArrayList<>();
            integers.add(i);
            createArrayAndCalculateSum(arrayLists, integers, i, k, n);
        }
        return arrayLists;
    }

    public void createArrayAndCalculateSum(List<List<Integer>> arrayLists, List<Integer> integers, int currentSum, int amount, int sum) {
        if (integers.size() < amount && currentSum < sum) {
            Integer last = integers.getLast();
            for (int i = last + 1; i < 10; i++) {
                List<Integer> integersNew = new ArrayList<>(integers);
                integersNew.add(i);
                createArrayAndCalculateSum(arrayLists, integersNew, currentSum + i, amount, sum);
            }
        } else if (integers.size() == amount && currentSum == sum) {
            arrayLists.add(integers);
        }
    }
}