package solutions.task_2191;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//2191. Sort the Jumbled Numbers
/*
 * You are given a 0-indexed integer array mapping which represents the mapping rule of a shuffled decimal system. mapping[i] = j means digit i should be mapped to digit j in this system.
 * The mapped value of an integer is the new integer obtained by replacing each occurrence of digit i in the integer with mapping[i] for all 0 <= i <= 9.
 * You are also given another integer array nums. Return the array nums sorted in non-decreasing order based on the mapped values of its elements.
 * Notes:
 * Elements with the same mapped values should appear in the same relative order as in the input.
 * The elements of nums should only be sorted based on their mapped values and not be replaced by them.
 * */
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<int[]> ints = intsMapper(nums, mapping);
        return ints.stream()
                .sorted(Comparator.comparing(o -> o[0]))
                .map(ints1 -> ints1[1])
                .mapToInt(i -> i)
                .toArray();
    }

    private List<int[]> intsMapper(int[] nums, int[] mapping) {
        List<int[]> intsArr = new ArrayList<>();
        for (int anInt : nums) {
            char[] charArray = String.valueOf(anInt).toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                charArray[j] = (char) (mapping[charArray[j] - 48] + 48);
            }
            intsArr.add(new int[]{Integer.parseInt(String.valueOf(charArray)), anInt});
        }
        return intsArr;
    }
}
