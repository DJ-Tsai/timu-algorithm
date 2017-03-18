package org.dongjian.jiuzhang.algorithm.easy;

import com.faith.dj.jiuzhang.java.fundamental.common.ListNode;

/**
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList_173_E {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        ListNode dummy = new ListNode(head.val);
        dummy.next = head;
        head = dummy;

        while (head.next != null) {
            ListNode preMin = head;
            ListNode start = head;

            while (start.next != null) {
                if (start.next.val < preMin.next.val) {
                    preMin = start;
                }
                start = start.next;
            }

            if (preMin == head) {
                head = head.next;
            } else {
                ListNode min = preMin.next;
                preMin.next = min.next;
                min.next = head.next;
                head.next = min;
                head = head.next;
            }

        }

        return dummy.next;

    }
}
