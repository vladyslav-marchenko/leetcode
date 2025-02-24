package com.leetcode;

// https://leetcode.com/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-interview-150

import java.util.Arrays;

public class LongestConsecutive {

    public static void main(String[] args) {
        int[] a = {100,4,200,1,3,2};
        int[] b = {0, 1, 1, 2};
        int[] c = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(b));
        System.out.println(longestConsecutive(c));
        System.out.println(longestConsecutive(a));
    }

    public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        Arrays.sort(nums);

        int lastSmaller = Integer.MAX_VALUE;
        int count = 0;
        int longest = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 == lastSmaller) {
                count++;
                lastSmaller = nums[i];
            } else if (nums[i] != lastSmaller) {
                count = 1;
                lastSmaller = nums[i];
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

}
