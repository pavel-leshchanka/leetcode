package solutions.task_11;

/**
 * 11. Container With Most Water
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * * Return the maximum amount of water a container can store.
 * * Notice that you may not slant the container.
 */
class Solution {

    public int maxArea(int[] height) {
        if (height.length == 0) return 0;
        int min = 0;
        int max = height.length - 1;
        int area = 0;

        while (min != max) {
            int a = height[min];
            int b = height[max];
            int min1 = Math.min(a, b);
            int ar = (max - min) * min1;
            if (ar > area) area = ar;
            if (a == min1) min++;
            else max--;
        }
        return area;
    }
}