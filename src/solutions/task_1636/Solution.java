package solutions.task_1636;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 1636. Sort Array by Increasing Frequency
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
 * Return the sorted array.
 */
class Solution {
    public int[] frequencySort(int[] nums) {
        List<Integer> objects = new ArrayList<>();
        int[] myArray = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        while (map.size() > 0) {
            Optional<Integer> min = map.values().stream()
                .min(Integer::compare);
            map.keySet().stream()
                .filter(i -> map.get(i).equals(min.get()))
                .sorted(Comparator.reverseOrder())
                .forEach(i -> {
                    if (map.get(i).equals(min.get())) {
                        for (int j = 0; j < min.get(); j++) {
                            objects.add(i);
                        }
                        map.remove(i);
                    }
                });
        }
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = objects.get(i);
        }
        return myArray;
    }
}
