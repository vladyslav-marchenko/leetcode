package com.leetcode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IsSubsequence {

    public static void main(String[] args) {
        String  s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

}
