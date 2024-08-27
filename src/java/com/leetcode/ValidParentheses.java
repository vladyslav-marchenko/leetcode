package com.leetcode;

import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid(")(")); // true
        System.out.println(isValid("([{}])")); // true
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("[({])}")); // false
        System.out.println(isValid("(}{)")); // false
        System.out.println(isValid("(]")); // false
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> parentheses = getParentheses();

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (parentheses.containsKey(c)) {
                stack.push(parentheses.get(c));
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private static Map<Character, Character> getParentheses() {
        return Map.of(
        '(', ')',
        '[', ']',
        '{', '}'
        );
    }

}
