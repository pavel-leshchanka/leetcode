package solutions.task_2418;

/**
 * 2418. Sort the People
 * You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.
 * For each index i, names[i] and heights[i] denote the name and height of the ith person.
 * Return names sorted in descending order by the people's heights
 */
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (heights[i] < heights[j]) {
                    int buf = heights[i];
                    heights[i] = heights[j];
                    heights[j] = buf;
                    String bufStr = names[i];
                    names[i] = names[j];
                    names[j] = bufStr;
                }
            }
        }
        return names;
    }
}
