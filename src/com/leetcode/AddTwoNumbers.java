package com.leetcode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);

        ListNode l2 = new ListNode(1,
                new ListNode(9,
                        new ListNode(9)));
                        //        new ListNode(9,
                        //                new ListNode(9,
                        //                        new ListNode(9,
                        //                                new ListNode(9,
                        //                                        new ListNode(9,
                        //                                                new ListNode(9,
                        //                                                        new ListNode(9))))))))));
        //System.out.println(addTwoNumbers(l1, l2));
        System.out.println(addTwoNumbersV2(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        String s1 = stringifyAndReverse(l1);
        String s2 = stringifyAndReverse(l2);
        //Long sum = Long.parseLong(s1) + Long.parseLong(s2);
        int sum = Integer.parseInt(s1) + Integer.parseInt(s2);
        return toListNode(new StringBuilder().append(sum).reverse().toString());
    }

    private static String stringifyAndReverse(ListNode nodes) {
        StringBuilder sb = new StringBuilder();
        ListNode current = nodes;
        while (current != null) {
            sb.append(current.val);
            current = current.next;
        }
        return sb.reverse().toString();
    }


    public static ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }

    private static ListNode toListNode(String s) {
        ListNode nodes = null;
        ListNode current = null;
        String[] split = s.split("");

        for (int i = 0; i < split.length; i++) {
            if (i == 0) {
                current = new ListNode(Integer.parseInt(split[i]));
                nodes = current;
            } else {
                current.next = new ListNode(Integer.parseInt(split[i]));
                current = current.next;
            }
        }
        return nodes;
    }

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
