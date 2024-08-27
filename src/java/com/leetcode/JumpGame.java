package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JumpGame {

    public static void main(String[] args) {
        int[] n = new int[]{2, 0};
        System.out.println(canJump(n));
    }

    //5,3,1,2,4
    public static boolean canJump(int[] nums) {
        Map<Integer, Boolean> index2isJumped = new HashMap<>();
        for (int i = 0; i < nums.length; i++) index2isJumped.put(i, false);

        int lastIndex = nums.length - 1;
        int currentIndex = 0;
        while (currentIndex != lastIndex) {
            if (nums[currentIndex] > lastIndex) {
                currentIndex = nums[currentIndex] % lastIndex;
                currentIndex = currentIndex == 0 ? 0 : currentIndex - 1;
            } else if (nums[currentIndex] == 0) {
                return false;
            } else {
                currentIndex = currentIndex + nums[currentIndex];
            }

            if (currentIndex == lastIndex) return true;
            if (Boolean.TRUE.equals(index2isJumped.get(currentIndex))) {
                return false;
            } else {
                index2isJumped.put(currentIndex, true);
            }
        }
        return true;
    }
}
