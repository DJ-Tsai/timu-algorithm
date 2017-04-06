package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dj on 1/17/17.
 */
public class RemovedDuplicatedFromUnsortedLinkedList_217_E {
    public ListNode removeDuplicates(ListNode head) {
        // Write your code here

        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null) {
            if (map.get(head.next.val) != null) {
                head.next = head.next.next;
            }else {
                map.put(head.next.val,true);
                head = head.next;
            }

        }

        return dummy.next;
    }
}
