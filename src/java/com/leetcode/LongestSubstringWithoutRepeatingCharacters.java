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

}
