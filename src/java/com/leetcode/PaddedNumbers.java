package com.leetcode;

import java.util.Arrays;

public class PaddedNumbers {

    public static void main(String[] args) {
        solutionV2(5);
    }

    public static String solution(int value) {
        StringBuilder result = new StringBuilder();
        StringBuilder values = new StringBuilder();
        values.append(value).reverse();
        // TODO: use Math.max
        for (int i = 0; i < 5; i++) {
            result.append(i >= values.length() ? '0' : values.charAt(i));
        }
        result.reverse();
        return "Value is " + result;
    }

    public static String solutionV2(int value) {
        return String.format("Value is %05d", value);
    }

}
