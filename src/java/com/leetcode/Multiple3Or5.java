package com.leetcode;

// https://www.codewars.com/kata/514b92a657cdc65150000006/train/java

public class Multiple3Or5 {

    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    public static int solution(int number) {
        return multipleBy(number, 3) +
                multipleBy(number, 5);
    }

    private static int multipleBy(int number, int multiplier) {
        boolean isNumberExceeded = true;
        int sum = 0;
        int i = 1;
        while (isNumberExceeded) {
            int multiplied = multiplier * i;
            if (multiplied >= number) {
                isNumberExceeded = false;
            } else {
                sum += multiplied;
                i++;
            }
        }
        return sum;
    }

}
