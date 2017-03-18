package org.dongjian.jiuzhang.algorithm.naive;

import com.faith.dj.jiuzhang.java.fundamental.common.ListNode;

/**
 * Created by Dj on 1/17/17.
 */
public class MiddleOfLinkedList_228_N {

    public ListNode middleNode(ListNode head) {
        // Write your code here
        if (head == null) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head;

        while (p2.next != null && p2.next.next != null) {
            p2 = p2.next.next;
            p1 = p1.next;
        }

        return p1;
    }

}
