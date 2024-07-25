package solutions.task_238;

//238. Product of Array Except Self
/*
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ints1 = new int[nums.length];
        int[] ints2 = new int[nums.length];
        ints1[0] = 1;
        ints2[nums.length - 1] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            ints1[i + 1] = ints1[i] * nums[i];
        }
        for (int i = nums.length - 1; i > 0; i--) {
            ints2[i - 1] = ints2[i] * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            ints1[i] *= ints2[i];
        }
        return ints1;
    }
}
