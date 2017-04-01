package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.ListNode;

/**
 * Given a node from a cyclic linked list which has been sorted, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be any single node in the list. Return the inserted new node.
 * <p>
 * Notice
 * <p>
 * 3->5->1 is a cyclic list, so 3 is next node of 1.
 * 3->5->1 is same with 5->1->3
 * <p>
 * Example
 * Given a list, and insert a value 4:
 * 3->5->1
 * Return 5->1->3->4
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
