package com.leetcode;

import java.util.*;

// https://leetcode.com/problems/two-sum/description/
public class TwoSum {

    public static void main(String[] args) {
        //int[] nums = new int[]{-1, -2, -3, -4, -5};
        //int target = -8;
        int[] nums = new int[]{3, 4, 5, 2, 2, 2};
        int target = 6;
        twoSum(nums, target);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
