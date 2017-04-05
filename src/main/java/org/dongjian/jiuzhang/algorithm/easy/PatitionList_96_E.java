package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>e
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example
 * Given 1->4->3->2->5->2->null and x = 3,
 * return 1->2->2->4->3->5->null.
 */
public class PatitionList_96_E {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode larger = new ListNode(0);

        dummy.next = head;
        head = dummy;

        ListNode index = larger;

        while (head.next != null) {
            if (head.next.val < x) {
                head = head.next;
            } else {
                index.next = head.next;
                index = index.next;
                head.next = head.next.next;
            }
        }

        head.next = larger.next;
        index.next = null;
        return dummy.next;
    }
}
