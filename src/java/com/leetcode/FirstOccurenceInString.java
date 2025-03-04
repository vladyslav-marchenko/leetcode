package com.leetcode;

public class FirstOccurenceInString {

    public static void main(String[] args) {
        System.out.println(strStr("sssadbutsad", "sad"));
    }

    public static int strStr(String haystack, String needle) {
        int length = haystack.length();
        int needleLength = needle.length();
        for (int i = 0; i < length; i++) {
            if (needleLength <= length - i &&
                    needle.equals(haystack.substring(i, i + needleLength))) {
                return i;
            }
        }
        return -1;
    }

}
