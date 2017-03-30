package org.dongjian.jiuzhang.algorithm.medium;

import org.dongjian.jiuzhang.algorithm.common.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * Example
 * Given -21->10->4->5, tail connects to node index 1, return true
 *
 * Challenge
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle_102_M {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode p1 = head;
        ListNode p2 = head;

        while (p2.next != null && p2.next.next != null) {
            p2 = p2.next.next;
            p1 = p1.next;
            if (p1 == p2) {
                return true;
            }
        }

        return false;
    }
}
