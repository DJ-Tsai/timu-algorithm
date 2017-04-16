package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.ListNode;

/**
 * Find the nth to last element of a singly linked list.
 * <p>
 * The minimum number of nodes in list is n.
 * <p>
 * Example
 * Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.
 */
public class NthToLastNodeInList_166_E {
    ListNode nthToLast(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode fast = head, slow = head;

        for (int i = 0; i < n - 1; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
