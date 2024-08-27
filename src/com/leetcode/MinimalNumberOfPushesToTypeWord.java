package com.leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/description/?envType=daily-question&envId=2024-08-06
public class MinimalNumberOfPushesToTypeWord {

    public static void main(String[] args) {
        System.out.println(minimumPushesV2("aabbccddeeffgghhiiiiii")); // expected: 24

    }

    private static int minimumPushesV2(String word) {
        int[] occurrences = new int[26]; // 26 is a length of english alphabet
        for (int i = 0; i < word.length(); i++) {
            occurrences[word.charAt(i) - 'a']++;
        }
        Arrays.sort(occurrences);

        int presses = 0;
        for (int i = occurrences.length - 1, j = 0; i >= 0; i--, j++) {
            presses += (j / 8 + 1) * occurrences[i];
        }
        return presses;
    }

}
