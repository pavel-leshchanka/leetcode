package solutions.task_2215;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 2215. Find the Difference of Two Arrays
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 * Note that the integers in the lists may be returned in any order.
 */
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
/*        Set<Integer> collect1 = Arrays.stream(nums1)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new));
        Set<Integer> collect2 = Arrays.stream(nums2)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new));
        List<List<Integer>> objects = new ArrayList<>();
        List<Integer> list1 = collect1.stream()
            .filter(e -> !collect2.contains(e))
            .toList();
        List<Integer> list2 = collect2.stream()
            .filter(e -> !collect1.contains(e))
            .toList();
        objects.add(list1);
        objects.add(list2);
        return objects;*/

        HashSet<Integer> integers1 = new HashSet<>();
        HashSet<Integer> integers2 = new HashSet<>();
        for (int j : nums1) {
            integers1.add(j);
        }
        for (int j : nums2) {
            integers2.add(j);
        }
        ArrayList<Integer> integers11 = new ArrayList<>();
        for (Integer i : integers1) {
            if (!integers2.contains(i)) {
                integers11.add(i);
            }
        }
        ArrayList<Integer> integers22 = new ArrayList<>();
        for (Integer i : integers2) {
            if (!integers1.contains(i)) {
                integers22.add(i);
            }
        }
        return List.of(integers11, integers22);
    }
}