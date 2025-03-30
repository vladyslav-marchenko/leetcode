package com.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Long> map = Arrays.stream(nums)
                .mapToObj(i -> i)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }
        return -1;
    }

}
