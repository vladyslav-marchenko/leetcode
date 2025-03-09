package com.leetcode;

import java.util.*;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcdbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> char2Index = new HashMap<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            if (!char2Index.containsKey(s.charAt(right)) || char2Index.get(s.charAt(right)) < left) {
                char2Index.put(s.charAt(right), right);
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left = char2Index.get(s.charAt(right)) + 1;
                char2Index.put(s.charAt(right), right);
            }
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstringV2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int result = 0;
        Set<Character> substring = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            substring.add(s.charAt(i));
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    continue;
                }
                if (!substring.add(s.charAt(j))) {
                    result = Math.max(result, substring.size());
                    substring.clear();
                    break;
                }
            }
        }
        return Math.max(result, substring.size());
    }

}
