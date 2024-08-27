package com.leetcode.numberOfOneBits;

// https://leetcode.com/problems/number-of-1-bits/

public class NumberOfOneBits {

    public static void main(String[] args) {
        hammingWeight(11);
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

}
