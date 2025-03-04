package com.leetcode;

// https://leetcode.com/problems/minimum-size-subarray-sum/?envType=study-plan-v2&envId=top-interview-150

import java.util.Arrays;

public class MinSubArrayLen {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3}; // 1,2,2,3,3,4
        System.out.println(minSubArrayLen(7, nums));
        int[] nums1 = {1, 4, 4}; // 1,2,2,3,3,4
        System.out.println(minSubArrayLen(4, nums1));
        int[] nums3 = {12,28,83,4,25,26,25,2,25,25,25,12};
        System.out.println(minSubArrayLen(213, nums3));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            count++;
            sum += nums[i];
            if (sum >= target) {
                return count;
            }
        }
        return 0;
    }

}
