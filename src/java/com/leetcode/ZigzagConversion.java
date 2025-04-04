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

    // P     I    N
    // A   L S  I G
    // Y A   H R
    // P     I
    public static String convertV2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] zigZag = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            zigZag[i] = new StringBuilder();
        }

        char[] chars = s.toCharArray();
        int zigZagPutAt = 0;
        boolean goDown = true;
        for (char aChar : chars) {
            zigZag[zigZagPutAt].append(aChar);
            if (goDown) {
                if (zigZagPutAt >= numRows - 1) {
                    goDown = false;
                    zigZagPutAt--;
                } else {
                    zigZagPutAt++;
                }
            } else {
                if (zigZagPutAt == 0) {
                    goDown = true;
                    zigZagPutAt++;
                } else {
                    zigZagPutAt--;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : zigZag) {
            result.append(sb);
        }
        return result.toString();
    }


}
