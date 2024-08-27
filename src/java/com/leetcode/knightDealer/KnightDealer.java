package com.leetcode.knightDealer;

// https://leetcode.com/problems/knight-dialer

public class KnightDealer {

    public static void main(String[] args) {
        System.out.println(knightDialer(1));
    }

    public static int knightDialer(int n) {
        int mod = 1000000007;
        int[][] moves = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        int[][] dp = new int[n][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int move : moves[j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][move]) % mod;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + dp[n - 1][i]) % mod;
        }
        return res;
    }

}
