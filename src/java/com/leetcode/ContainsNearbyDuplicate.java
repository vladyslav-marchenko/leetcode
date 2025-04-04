package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(containsNearbyDuplicateV2(nums, k));

        nums = new int[]{1,0,1,1};
        k = 1;
        System.out.println(containsNearbyDuplicateV2(nums, k));

        nums = new int[]{1,2,3,1,2,3};
        k = 2;
        System.out.println(containsNearbyDuplicateV2(nums, k));
    }

    public static boolean containsNearbyDuplicateV2(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i]) && i - indexMap.get(nums[i]) <= k) {
                return true;
            }
            indexMap.put(nums[i], i);
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> indexesByNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!indexesByNums.containsKey(nums[i])) {
                indexesByNums.put(nums[i], new ArrayList<>());
            }
            indexesByNums.get(nums[i]).add(i);
        }
        for (Map.Entry<Integer, List<Integer>> entry : indexesByNums.entrySet()) {
            if (entry.getValue().size() < 2) {
                continue;
            }
            if (containsNearbyDuplicate(entry.getValue(), k)) {
                return true;
            }
        }

        return false;
    }

    private static boolean containsNearbyDuplicate(List<Integer> indexes, int k) {
        for (int i = 0; i < indexes.size(); i++) {
            for (int j = i; j < indexes.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (Math.abs(indexes.get(i) - indexes.get(j)) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

}
