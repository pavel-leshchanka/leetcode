package solutions.task_605;

//605. Can Place Flowers
/*
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 * */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) {
                count++;
            }
        } else if (flowerbed.length == 2) {
            if (flowerbed[0] + flowerbed[1] == 0) {
                count++;
            }
        } else {
            if (flowerbed[0] + flowerbed[1] == 0) {
                count++;
                flowerbed[0] = 1;
            }
            for (int i = 0; i < flowerbed.length - 2; i++) {
                int sum = flowerbed[i] + flowerbed[i + 1] + flowerbed[i + 2];
                if (sum == 0) {
                    count++;
                    flowerbed[i + 1] = 1;
                }
            }
            if (flowerbed[flowerbed.length - 2] + flowerbed[flowerbed.length - 1] == 0) {
                count++;
            }
        }
        return count >= n;
    }
}