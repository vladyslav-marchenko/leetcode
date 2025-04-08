package com.leetcode;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervalsV1 = new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newIntervalV1 = new int[] {4,8};
        int[][] resultV1 = insertV2(intervalsV1, newIntervalV1);
        System.out.println(Arrays.toString(resultV1));
        int[][] intervals = new int[][] {{1,3}, {6,9}};
        int[] newInterval = new int[] {2,5};
        int[][] result = insertV2(intervals, newInterval);
        System.out.println(Arrays.toString(result));
    }


    // Example 1:
    //
    // Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    // Output: [[1,5],[6,9]]
    // Example 2:
    //
    // Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    // Output: [[1,2],[3,10],[12,16]]
    // Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

    public static int[][] insertV2(int[][] intervals, int[] newInterval) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        int kVal = newInterval[0];
        int lVal = newInterval[1];
        int lastPutKey = -1;
        int lastPutVal = -1;
        int keyToPut = -1;
        int valToPut = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (lastPutKey == -1) { // first iteration
                keyToPut = Math.min(kVal, intervals[i][0]);
                valToPut = Math.min(kVal, intervals[i][1]);
                map.put(keyToPut, valToPut);
                lastPutKey = keyToPut;
                lastPutVal = valToPut;
            } else {
                keyToPut = Math.min(kVal, intervals[i][0]);
                valToPut = Math.max(lVal, intervals[i][1]);

                if ((lastPutKey < keyToPut && lastPutVal < valToPut && lastPutVal > keyToPut) ||
                        lastPutKey < keyToPut && lastPutVal >= valToPut) {
                    keyToPut = lastPutKey;
                } else {
                    keyToPut = intervals[i][0];
                }
                if (lastPutKey < keyToPut && lastPutVal >= valToPut) {
                    continue;
                }

                map.put(keyToPut, valToPut);
                lastPutKey = keyToPut;
                lastPutVal = valToPut;
            }
        }

        int[][] result = new int[map.size()][map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.sequencedEntrySet()) {
            result[i][0] = entry.getKey();
            result[i][1] = entry.getValue();
            i++;
        }

        return result;
    }

}
