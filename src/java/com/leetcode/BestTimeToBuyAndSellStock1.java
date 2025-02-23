package com.leetcode;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
public class BestTimeToBuyAndSellStock1 {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int[] prices1 = new int[]{7, 6, 2, 4, 5, 1, 3};

        System.out.println(maxProfit(prices)); // 5
        System.out.println(maxProfit(prices1)); // 3
    }

    // 7 6 2 4 5 1 3
    // 7 6 3 2 4 1
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = prices[0];

        for (int price : prices) {
            if (buyPrice > price) {
                buyPrice = price;
            }
            profit = Math.max(profit, price - buyPrice);
        }
        return profit;
    }

}
