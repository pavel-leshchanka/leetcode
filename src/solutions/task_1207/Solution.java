package solutions.task_1207;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 1207. Unique Number of Occurrences
 * Given an array of integers arr, return true if the number of occurrences
 * of each value in the array is unique or false otherwise.
 */
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Collection<Long> values = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .values();
        return values.size() == Set.copyOf(values).size();
    }
}
