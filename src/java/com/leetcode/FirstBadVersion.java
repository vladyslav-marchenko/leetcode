package com.leetcode;

// https://leetcode.com/problems/first-bad-version/
public class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            // Prevent overflow
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isBadVersion(int mid) {
        return true;
    }

}
