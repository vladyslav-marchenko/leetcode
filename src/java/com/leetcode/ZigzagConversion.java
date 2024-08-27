package com.leetcode;

// * * * * *
// https://leetcode.com/problems/zigzag-conversion/submissions/1348205787/
public class ZigzagConversion {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3)); // expected: "PAHNAPLSIIGYIR"
        System.out.println(convert("PAYPALISHIRING", 4)); // expected: "PINALSIGYAHRPI"`
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows[row].append(c);
            if (row == 0 || row == numRows - 1) {
                goingDown = !goingDown;
            }
            row += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder r : rows) {
            result.append(r);
        }
        return result.toString();
    }

}
