package com.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t)); // true
        String s1 = "rat", t1 = "car";
        System.out.println(isAnagramV2(s1, t1)); // false
    }

    public static boolean isAnagram(String s, String t) {
        Map<String, Long> sMap = Arrays.stream(s.split("")).collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        Map<String, Long> tMap = Arrays.stream(t.split("")).collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        if (sMap.size() != tMap.size()) {
            return false;
        }
        for (Map.Entry<String, Long> sEntry : sMap.entrySet()) {
            if (!tMap.containsKey(sEntry.getKey()) ||
                    !Objects.equals(tMap.get(sEntry.getKey()), sEntry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramV2(String s, String t) {
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(ts);
        return Arrays.equals(ss, ts);
    }

}
