package com.leetcode;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/?envType=study-plan-v2&envId=top-interview-150

public class TwoSum2 {

    public static void main(String[] args) {
        int[] numbers = {2, 3, 4}; // 1, 3
        twoSumV2(numbers, 6);
        int[] numbers2 = {-10,-8,-2,1,2,5,6};
        twoSumV2(numbers2, 0);
    }

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (i == j) {
                    continue;
                }
                if (numbers[i] + numbers[j] == target) {
                    return new int[] {i + 1, j + 1};
                }
            }
        }
        return null;
    }

    public static int[] twoSumV2(int[] n, int target) {
        for (int i = 0, j = n.length - 1; i < j;) {
            if (n[i] + n[j] == target) {
                return new int[]{i+1, j+1};
            } else if (n[i] + n[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

}
