package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(1)); // false
        System.out.println(isHappy(2)); // false
        System.out.println(isHappy(19)); // true
    }

    public static boolean isHappy(int n) {
        Set<Integer> cache = new HashSet<>();
        while (n != 1) {
            n = getNext(n);
            if (n == 1) {
                return true;
            } else if (!cache.add(n)) {
                return false;
            }
        }
        return true;
    }

    private static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

}
