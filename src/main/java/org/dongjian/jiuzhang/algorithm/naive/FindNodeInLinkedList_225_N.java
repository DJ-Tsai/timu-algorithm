package org.dongjian.jiuzhang.algorithm.naive;

public class FindNodeInLinkedList_225_N {
    public ListNode findNode(ListNode head, int val) {
        // Write your code here
        while (head != null) {
            if (head.val == val) {
                return head;
            } else {
                head = head.next;
            }
        }
        return null;
    }

    //Definition for ListNode
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}


