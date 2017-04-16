package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.ListNode;

/**
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 * Example
 * Given 7->1->6 + 5->9->2. That is, 617 + 295.
 * <p>
 * Return 2->1->9. That is 912.
 * <p>
 * Given 3->1->5 and 5->9->2, return 8->0->8.
 */
public class AddTwoNumbers_167_E {
    public AddTwoNumbers_167_E() {
    }

    public ListNode addLists(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while (l1 != null || l2 != null) {
            int cur;

            if (l1 != null && l2 != null) {
                cur = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                cur = l2.val;
                l2 = l2.next;
            } else {
                cur = l1.val;
                l1 = l1.next;
            }

            cur = cur + carry;
            head.next = new ListNode(cur % 10);
            head = head.next;

            if (cur >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
        }

        if (carry > 0) {
            head.next = new ListNode(carry);
        }

        return dummy.next;

    }
}
