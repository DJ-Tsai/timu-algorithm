package org.dongjian.jiuzhang.algorithm.easy;


import org.dongjian.jiuzhang.algorithm.common.ListNode;

/**
 * Created by Dj on 1/18/17.
 */
public class SwapNodesInPairs_451_E {
    public ListNode swapPairs(ListNode head) {
        // Write your code
        ListNode tracker = head;
        int temp;

        while (tracker != null && tracker.next != null) {
            temp = tracker.val;
            tracker.val = tracker.next.val;
            tracker.next.val = temp;
            tracker = tracker.next.next;
        }

        return head;
    }
}
