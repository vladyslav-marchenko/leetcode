package com.leetcode;

// https://leetcode.com/problems/sort-list/?envType=study-plan-v2&envId=top-interview-150

public class SortLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(5,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(0)))));
        ListNode listNode = sortList(head);
    }

    //  head = [-1,5,3,4,0]
    // Output: [-1,0,3,4,5]
    /**
     * current = head
     * beforeInitCurrent = null; // node before current when current is started to be sorted
     * prevCurrent = null
     * nodeToSort = head
     * while
     *  if current > current.next // move on
     *      prevNodeToSort = current.next
     *  if current < current.next
     *      if beforeInitCurrent != null // head
     *          beforeInitCurrent.next = prevCurrent
     *          current = prevCurrent
     *
     * */
    public static ListNode sortList(ListNode head) {
        ListNode currentNode = head;
        ListNode beforeInitCurrent = null;
        ListNode lastLessNode = null;
        ListNode nodeToSort = head;
        ListNode nodeWithMinVal = head;
        while (currentNode.next != null) {


        }
        return nodeWithMinVal;
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }

    }

}


