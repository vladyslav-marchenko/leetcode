package com.leetcode;

public class RotateArray {
    public static void main(String[] args) {
        /*int[] a = new int[]{1,2,3,4,5,6,7};
        rotate(a, 3);
        int[] b = new int[]{-1,-100,3,99};
        rotate(b, 2);*/
        int[] b = new int[]{1, 2};
        rotate(b, 3);
    }

    /*Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]*/
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k % nums.length == 0) {
            return; // No need to rotate if the array is empty or 'k' is a multiple of array length
        }
        k %= nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }

    private static void rotate(int[] nums, int start, int end) {
        while (start < end) {
            int starting = nums[start];
            int ending = nums[end];
            nums[start] = ending;
            nums[end] = starting;
            start++;
            end--;
        }
    }
}
