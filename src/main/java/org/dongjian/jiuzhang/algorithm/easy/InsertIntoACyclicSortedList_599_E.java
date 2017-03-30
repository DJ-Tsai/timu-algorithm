package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.ListNode;

/**
 * Created by Dj on 3/30/17.
 */
public class InsertIntoACyclicSortedList_599_E {
    public ListNode insert(ListNode node, int x) {
        ListNode newNode = new ListNode(x);

        if (node == null) {
            newNode.next = newNode;
            return newNode;
        }

        ListNode head = node;

        while (true) {
            // milestone
            if (head.next.val < head.val) {
                if (head.val <= x || head.next.val >= x) {
                    newNode.next = head.next;
                    head.next = newNode;
                    return newNode.next;
                }
            }

            if (head.next.val > x && head.val <= x) {
                newNode.next = head.next;
                head.next = newNode;
                return newNode.next;
            }

            if (head.next == node) {
                newNode.next = head.next;
                head.next = newNode;
                return newNode.next;
            }

            head = head.next;
        }
    }
}
