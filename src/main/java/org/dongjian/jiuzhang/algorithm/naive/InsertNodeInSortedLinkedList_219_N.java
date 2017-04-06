package org.dongjian.jiuzhang.algorithm.naive;


import org.dongjian.jiuzhang.algorithm.common.ListNode;

/**
 * Created by Dj on 1/14/17.
 */
public class InsertNodeInSortedLinkedList_219_N {
    public ListNode insertNode(ListNode head, int val) {
        // Write your code here
        ListNode newNode = new ListNode(val);

        if(head == null || head.val > val){
            newNode.next = head;
            return newNode;
        }

        ListNode pointer1 = head;

        while(pointer1 != null){
            if(pointer1.next == null || pointer1.next.val > val){
                newNode.next = pointer1.next;
                pointer1.next = newNode;
                return head;
            }
            pointer1 = pointer1.next;

        }

        return head;


    }
}
