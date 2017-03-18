package org.dongjian.jiuzhang.algorithm.medium;

import com.faith.dj.jiuzhang.java.fundamental.common.ListNode;

/**
 * Reverse a linked list from position m to n.
 *
 * Notice: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 *
 * Created by Dj on 1/19/17.
 */
public class ReverseLinkedListII_36_M {
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code

        if (m == n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode start = head.next;
        ListNode end = null;

        for (int i = 1; true ; i++) {
            if (i < m) {
                head = head.next;
                start = head.next;
            } else if (i >= m && i < n) {
                end = start.next;
                start.next = end.next;
                end.next = head.next;
                head.next = end;
            } else {
                break;
            }
        }
        return dummy.next;
    }
}
