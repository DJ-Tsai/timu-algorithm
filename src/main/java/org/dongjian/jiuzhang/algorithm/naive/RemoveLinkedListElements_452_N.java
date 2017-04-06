package org.dongjian.jiuzhang.algorithm.naive;


import org.dongjian.jiuzhang.algorithm.common.ListNode;

/**
 * Created by Dj on 1/15/17.
 */
public class RemoveLinkedListElements_452_N {
    public ListNode removeElements(ListNode head, int val) {
        // Write your code here

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while(dummy.next != null){
            if(dummy.next.val == val){
                dummy.next = dummy.next.next;
            }else {
                dummy = dummy.next;
            }
        }

        return head.next;
    }
}
