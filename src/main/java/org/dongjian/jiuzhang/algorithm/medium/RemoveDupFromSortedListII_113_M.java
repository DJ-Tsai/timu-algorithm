package org.dongjian.jiuzhang.algorithm.medium;


import org.dongjian.jiuzhang.algorithm.common.ListNode;

/**
 * Created by Dj on 1/19/17.
 */
public class RemoveDupFromSortedListII_113_M {
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        boolean isDup = false;

        while (head != null) {
            while (head.next != null && head.val == head.next.val) {
                isDup = true;
                head = head.next;
            }

            if (isDup) {
                head = head.next;
                isDup = false;
            } else {
                prev.next = head;
                head = head.next;
                prev = prev.next;
            }
        }

        prev.next = head;

        return dummy.next;


    }
}
