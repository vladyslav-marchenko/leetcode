package com.leetcode;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/?envType=study-plan-v2&envId=top-interview-150
public class BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        int[] prices = new int[] {7,1,5,3,6,4}; // 7
        int[] prices1 = new int[] {1,2,3,4,5};  // 4
        int[] prices2 = new int[] {7,6,4,3,1};  // 0

        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        boolean bought = false;
        int boughtAtDay = 0;
        int priceToday;
        int priceTomorrow;
        for (int i = 0; i < prices.length; i++) {
            priceToday = prices[i];
            if (i + 1 == prices.length) {
                // last day, nothing to buy tomorrow
                if (bought) {
                    profit += prices[i] - prices[boughtAtDay];
                }
                return profit;
            }
            priceTomorrow = prices[i + 1];
            if (bought) { // check and sell
                if (priceToday > priceTomorrow) {
                    profit += prices[i] - prices[boughtAtDay];
                    bought = false;
                }
            } else { // check and buy
                if (priceToday < priceTomorrow) {
                    boughtAtDay = i;
                    bought = true;
                }
            }
        }
        return profit;
    }

}
