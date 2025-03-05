package com.leetcode;

// https://leetcode.com/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150

import java.util.Map;
import java.util.stream.Collectors;

public class RansomNote {

    public static void main(String[] args) {

        System.out.println(canConstruct("aab", "ab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Long> charByCount = magazine.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        char[] ransomNoteChars = ransomNote.toCharArray();
        for (var ch : ransomNoteChars) {
            if (!charByCount.containsKey(ch) || charByCount.get(ch) <= 0) {
                return false;
            }
            charByCount.put(ch, charByCount.get(ch) - 1);
        }

        return true;
    }


}
