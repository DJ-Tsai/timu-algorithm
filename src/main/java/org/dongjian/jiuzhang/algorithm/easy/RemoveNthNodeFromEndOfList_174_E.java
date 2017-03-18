package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Created by Dj on 1/15/17.
 */
public class RemoveNthNodeFromEndOfList_174_E {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (head == null) {
            return null;
        }

        ListNode p2 = new ListNode(0);
        p2.next = head;
        head = p2;
        ListNode p1 = p2;

        for (int i = 0; i < n ; i++) {
            p2 = p2.next;
        }

        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        p1.next = p1.next.next;
        return head.next;
    }

    class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }
}
