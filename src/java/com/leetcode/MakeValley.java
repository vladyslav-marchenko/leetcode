package com.leetcode;

// https://www.codewars.com/kata/56e3cd1d93c3d940e50006a4/train/java

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MakeValley {

    public static void main(String[] args) {
        int[] a = {17, 17, 15, 14, 8, 7, 7, 5,  4,  4,  1};
        int[] a1 = {79, 54, 35, 35, 25, 19};
        makeValleyV2(a);
        makeValleyV2(a1);
        makeValley(a);
    }

    // 1,  4,  4,  5,  7, 7, 8, 14, 15, 17, 17
    public static int[] makeValleyV2(int[] arr) {
        Arrays.sort(arr);
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                result[i / 2] = arr[arr.length - i - 1];
            } else {
                result[arr.length - 1 - i / 2] = arr[arr.length - i - 1];
            }
        }
        return result;
    }

    public static int[] makeValley(int[] arr) {
        List<Integer> decreasing = Arrays.stream(arr)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        List<Integer> increasing = Arrays.stream(arr)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
        Integer lastRightAdded = null;
        int[] result = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (lastRightAdded != null && increasing.get(arr.length - j - 1) == lastRightAdded) {
                j++;
            }
            if (j >= arr.length) {
                break;
            }
            result[i] =  decreasing.get(j);
            if (0 > arr.length - j - 2) {
                break;
            }
            result[arr.length - i - 1] = increasing.get(arr.length - j - 2);
            lastRightAdded = increasing.get(arr.length - j - 2);;
            j++;
        }
        return result;
    }


}
