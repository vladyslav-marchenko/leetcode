package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class IsomorphicStrings {

    public static void main(String[] args) {
        String s = "paper", t = "title";
        String s1 = "egg", t1 = "add";
        String s2 = "foo", t2 = "bar";
        String s3 = "badc", t3 = "baba";
        System.out.println(isIsomorphic(s, t)); // true
        System.out.println(isIsomorphic(s1, t1)); // true
        System.out.println(isIsomorphic(s2, t2)); // false
        System.out.println(isIsomorphic(s3, t3)); // false
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        char[] sChs = s.toCharArray();
        char[] tChs = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(sChs[i]) && tMap.containsKey(tChs[i])) {
                if (!sMap.get(sChs[i]).equals(tChs[i])) {
                    return false;
                }
            } else if (sMap.containsKey(sChs[i]) || tMap.containsKey(tChs[i])) {
                return false;
            } else {
                sMap.put(sChs[i], tChs[i]);
                tMap.put(tChs[i], sChs[i]);
            }
        }
        return true;
    }

}
