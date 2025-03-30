package com.leetcode;


// https://leetcode.com/problems/gas-station/?envType=study-plan-v2&envId=top-interview-150

public class GasStation {

    public static void main(String[] args) {
        int[] gas  = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int index = 0;
        int tank = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            if (tank < 0) {
                tank = 0;
                index++;
            }
        }
        return totalGas >= totalCost ? index : -1;
    }

}
