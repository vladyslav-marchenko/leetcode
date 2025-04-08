package com.leetcode;

// https://leetcode.com/problems/word-pattern/?envType=study-plan-v2&envId=top-interview-150

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

    public static void main(String[] args) {
        var pattern = "abba";
        var s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s)); // true

        pattern = "abab";
        s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s)); // false

        pattern = "abac";
        s = "dog cat dog cat";
        System.out.println(wordPattern(pattern, s)); // false
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        char[] patternChars = pattern.toCharArray();
        Map<Character, String> patternMatches = new HashMap<>();
        Set<String> matchedWords = new HashSet<>();

        for (int i = 0; i < patternChars.length; i++) {
            String matchedWord = patternMatches.get(patternChars[i]);
            if (matchedWord == null) {
                if (!matchedWords.add(words[i])) {
                    return false;
                }
                patternMatches.put(patternChars[i], words[i]);
            } else if (!matchedWord.equals(words[i])){
                return false;
            }
        }
        return true;
    }

}
