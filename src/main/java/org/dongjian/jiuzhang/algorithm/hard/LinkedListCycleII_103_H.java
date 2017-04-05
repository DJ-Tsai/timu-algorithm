package org.dongjian.jiuzhang.algorithm.hard;

import org.dongjian.jiuzhang.algorithm.common.ListNode;

/**
 * Given a linked list, return the node where the cycle begins.
 * <p>
 * If there is no cycle, return null.
 * <p>
 * Example
 * Given -21->10->4->5, tail connects to node index 1，return 10
 */
public class LinkedListCycleII_103_H {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;

        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) {
            return null;
        } else {
            while (head != fast) {
                head = head.next;
                fast = fast.next;
            }
            return head;
        }


    }
}
