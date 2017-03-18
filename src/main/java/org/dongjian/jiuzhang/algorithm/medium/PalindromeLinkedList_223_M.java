package org.dongjian.jiuzhang.algorithm.medium;

import com.faith.dj.jiuzhang.java.fundamental.common.ListNode;

/**
 * Created by Dj on 1/19/17.
 */
public class PalindromeLinkedList_223_M {

    public boolean isPalindrome(ListNode head) {
        // Write your code here

        // assume null is true
        if (head == null) {
            return true;
        }

        if (head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        // find node in the middle
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode reversedNode = reverse(slow.next);

        while (reversedNode != null) {
            if (head.val == reversedNode.val) {
                head = head.next;
                reversedNode = reversedNode.next;
            } else {
                return false;
            }
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);

        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }

        return dummy.next;
    }
}
