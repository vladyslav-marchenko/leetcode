package com.leetcode;

import java.util.Arrays;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {0, 4}};
        int[][] intervalsV2 = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge(intervalsV2));

    }

    public static int[][] merge(int[][] intervals) {
        boolean merged = false;
        int oldLength = intervals.length;
        do {
            intervals = mergeIteratively(intervals);
            merged = oldLength != intervals.length;
            oldLength = intervals.length;
        } while (merged);
        return intervals;
    }

    // [[1,3], [2,6], [8,10], [15,18]]
    private static int[][] mergeIteratively(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            if (i + 1 < intervals.length && intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i + 1][0] = Math.min(intervals[i][0], intervals[i + 1][0]);
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
                return Arrays.copyOfRange(intervals, i + 1, intervals.length);
            }
        }
        return intervals;
    }

}
