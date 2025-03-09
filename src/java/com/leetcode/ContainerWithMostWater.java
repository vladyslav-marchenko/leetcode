package com.leetcode;

// https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=top-interview-150

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height2 = {1,8,6,2,150,150,8,3,7};
        int[] height3 = {1,1};
        System.out.println(maxArea(height3));
        System.out.println(maxArea(height2)); // 150 x 1 = 150
        System.out.println(maxArea(height)); // (7 x 7) = 49
    }

    public static int maxArea(int[] height) {
        int result = 0;
        int currentMinHeight;
        int currentArea;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
        //for (int i = 0, j = height.length - 1; i < j;) {
            currentMinHeight = Math.min(height[i], height[j]);
            currentArea = currentMinHeight * (j - i);
            result = Math.max(result, currentArea);
            if (height[i] > height[j]) {
                j--;
            } else if (height[i] < height[j]) {
                i++;
            } else {
                i++; // TODO: think about it
            }
        }
        return result;
    }

}
