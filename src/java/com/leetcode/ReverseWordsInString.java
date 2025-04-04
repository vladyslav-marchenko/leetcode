package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWordsInString {

    public static void main(String[] args) {
        System.out.println(reverseWordsV2("a good   example"));
    }

    public static String reverseWords(String str) {
        List<String> list = Arrays.stream(str.split(" "))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
        Collections.reverse(list);
        return String.join(" ", list);
    }

    public static String reverseWordsV2(String str) {
        String[] split = str.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]).append(" ");
        }
        return sb.toString().trim();
    }

}
