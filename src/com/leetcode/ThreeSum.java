package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    public static void main(String[] args) {
        //int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        //int[] nums = new int[]{0, 0, 0};
        int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};

        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSum = new ArrayList<>();
        if (nums.length < 3) {
            return threeSum;
        }
        Map<Integer, List<Integer>> cache = new HashMap<>();
        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    if (list.get(i) + list.get(j) + list.get(k) == 0 && i != j && i != k && j != k) {

                        List<Integer> sorted = Arrays.asList(list.get(i), list.get(j), list.get(k)).stream()
                                .sorted()
                                .collect(Collectors.toList());

                        if (!inCache(cache, sorted)) {
                            cache.put(sorted.get(0), Arrays.asList(sorted.get(1), sorted.get(2)));
                            threeSum.add(Arrays.asList(list.get(i), list.get(j), list.get(k)));
                        }
                    }
                }
            }
        }

        return threeSum;
    }

    private static boolean inCache(Map<Integer, List<Integer>> cache, List<Integer> sorted) {
        if (cache.containsKey(sorted.get(0))) {
            List<Integer> integers = cache.get(sorted.get(0));
            return integers.contains(sorted.get(1)) && integers.contains(sorted.get(2));
        }
        return false;
    }

}
