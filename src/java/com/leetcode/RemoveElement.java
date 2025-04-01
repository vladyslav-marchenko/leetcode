package com.leetcode;

// https://leetcode.com/problems/remove-element/submissions/1593509746/?envType=study-plan-v2&envId=top-interview-150
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println(removeElementV2(nums, val));

        nums = new int[]{0,1,2,2,3,0,4,2}; // 0,1,0,3
        val = 2;
        System.out.println(removeElementV2(nums, val));
    }

    // nums = [0,1,2,2,3,0,4,2], val = 2
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                k++;
            }
        }
        int i = 0;
        int j = nums.length - 1;
        int temp;
        while (i < j) {
            if (nums[i] == val) {
                if (nums[j] == val) {
                    j--;
                } else {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            } else {
                i++;
            }
        }

        return k;
    }

    public static int removeElementV2(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

}
