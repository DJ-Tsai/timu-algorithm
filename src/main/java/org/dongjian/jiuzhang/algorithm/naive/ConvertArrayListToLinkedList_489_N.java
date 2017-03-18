package org.dongjian.jiuzhang.algorithm.naive;

import java.util.ArrayList;

/**
 * Created by Dj on 1/17/17.
 */
public class ConvertArrayListToLinkedList_489_N {
    public ListNode toLinkedList(ArrayList<Integer> nums) {
        // Write your code here
        ListNode dummy = new ListNode(0);
        ListNode tracker = dummy;

        for (int i = 0; i < nums.size(); i++) {
            tracker.next = new ListNode(nums.get(i));
            tracker = tracker.next;
        }

        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode (int value) {
            this.val = value;
            this.next = null;
        }
    }
}
