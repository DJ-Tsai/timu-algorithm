package org.dongjian.jiuzhang.algorithm.hard;

import org.dongjian.jiuzhang.algorithm.common.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * <p>
 * Example
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInKGroup_450_H {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        if (k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        int len = 0;
        while (head.next != null) {
            len++;
            head = head.next;
        }

        head = dummy;

        ListNode cur = head.next;
        ListNode next = cur.next;
        ListNode pre = null;
        ListNode start = cur;

        int loop = len / k;

        while (loop > 0) {
            for (int i = 0; i < k; i++) {
                cur.next = pre;
                pre = cur;
                cur = next;
                if (cur == null) {
                    break;
                }
                next = next.next;
            }

            head.next = pre;
            head = start;
            start = cur;

            loop--;
        }

        if (start != null) {
            head.next = start;
        }

        return dummy.next;
    }
}
