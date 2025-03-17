package com.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-interview-150
public class SetZeros {

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        int[][] matrix2 = new int[][]{
                {0,1,1,0},
                {1,1,1,1},
                {1,1,1,1}
        };
        setZeroesV2(matrix1);
        setZeroes(matrix2);
    }

    public static void setZeroes(int[][] matrix) {
        Map<Integer, List<Integer>> indexes = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (!indexes.containsKey(i)) {
                        indexes.put(i, new ArrayList<>());
                    }
                    indexes.get(i).add(j);
                }
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : indexes.entrySet()) {
            int x = entry.getKey();
            List<Integer> ys = entry.getValue();
            for (int j = 0; j < matrix[x].length; j++) {
                matrix[x][j] = 0;
            }
            for (Integer y : ys) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][y] = 0;
                }
            }
        }
    }

    public static void setZeroesV2(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] zeroRows = new boolean[rows];
        boolean[] zeroCols = new boolean[cols];

        // First pass to find all rows and columns that need to be zeroed
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        // Second pass to set the rows and columns to zero
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (zeroRows[i] || zeroCols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
