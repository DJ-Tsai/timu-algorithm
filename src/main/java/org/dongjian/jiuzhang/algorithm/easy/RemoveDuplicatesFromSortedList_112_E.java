package org.dongjian.jiuzhang.algorithm.easy;

import com.faith.dj.jiuzhang.java.fundamental.common.ListNode;

/**
 * Created by Dj on 1/18/17.
 */
public class RemoveDuplicatesFromSortedList_112_E {
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }

        ListNode dummy = head;

        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }
        return dummy;
    }
}
