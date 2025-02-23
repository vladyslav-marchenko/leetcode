package com.leetcode;

// https://www.codewars.com/kata/56f3a1e899b386da78000732/train/java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartList {

    public static void main(String[] args) {
        String[] s1 = new String[] {"I", "wish", "I", "hadn't", "come"};
        String[][] strings = partList(s1);
        System.out.println(strings);
    }

    private static String[][] partList(String[] arr) {
        if (arr.length == 0) {
            return new String[][]{};
        }
        List<String[]> result = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            String left = String.join(" ", Arrays.copyOfRange(arr, 0, i));
            String right = String.join(" ", Arrays.copyOfRange(arr, i, arr.length));
            result.add(new String[]{left, right});
        }
        return result.toArray(new String[result.size()][]);
    }

}
