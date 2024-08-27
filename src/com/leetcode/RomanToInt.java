package com.leetcode;

import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/roman-to-integer/description/
public class RomanToInt {

    public static void main(String[] args) {
        ZoneOffset.systemDefault();
        System.out.println(romanToIntV2("III")); // III - 44
        romanToIntV2("XLIV"); // XLIV - 44
        romanToInt("MCMXCIV"); // MCMXCIV - 1994
    }

    public static int romanToIntV2(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
                result -= m.get(s.charAt(i));
            } else {
                result += m.get(s.charAt(i));
            }
        }

        return result;
    }

    public static int romanToInt(String s) {
        // MCMXCIV - 1994
        String[] chars = s.split("");
        RomanCountHelper romanCountHelper = new RomanCountHelper(chars);
        return romanCountHelper.getInt();
    }

    /**
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     */
     /*
        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
    */
    public static class RomanCountHelper {

        private final String[] chars;

        private boolean currentSymbolUsedInCount = false;

        public RomanCountHelper(String[] chars) {
            this.chars = chars;
        }

        public int getInt() {
            int sum = 0;
            for (int i = 0; i < chars.length; i++) {
                sum += getCheckingNext(i);
            }
            return sum;
        }

        private int getCheckingNext(int i) {
            if (currentSymbolUsedInCount) {
                currentSymbolUsedInCount = false;
                return 0;
            }
            return switch (chars[i]) {
                case "I": yield getWithNext(i, "V", "X", 1);
                case "V": yield 5;
                case "X": yield getWithNext(i, "L", "C", 10);
                case "L": yield 50;
                case "C": yield getWithNext(i, "D", "M", 100);
                case "D": yield 500;
                case "M": yield 1000;
                default:
                    throw new IllegalStateException("Unexpected value: " + chars[i]);
            };
        }

        private int getWithNext(int i, String five, String ten, int multiplier) {
            if (i + 1 >= chars.length) {
                return toRoman(chars[i]);
            } else {
                String next = chars[i + 1];
                if (next.equals(five)) {
                    currentSymbolUsedInCount = true;
                    return 4 * multiplier;
                } else if (next.equals(ten)){
                    currentSymbolUsedInCount = true;
                    return 9 * multiplier;
                } else {
                    return toRoman(chars[i]);
                }
            }
        }

        // TODO: Maybe use map instead
        private int toRoman(String ch) {
            return switch (ch) {
                case "I": yield 1;
                case "V": yield 5;
                case "X": yield 10;
                case "L": yield 50;
                case "C": yield 100;
                case "D": yield 500;
                case "M": yield 1000;
                default:
                    throw new IllegalStateException("Unexpected value: " + ch);
            };
        }

    }

}
