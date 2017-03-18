package org.dongjian.jiuzhang.algorithm.medium;

import com.faith.dj.jiuzhang.java.fundamental.common.ListNode;

/**
 * Created by Dj on 1/19/17.
 */
public class SwapTwoNodesInLinkedList_511_M {
    /**
     * Given a linked list and two values v1 and v2. Swap the two nodes in the linked list with values v1 and v2. It's
     * guaranteed there is no duplicate values in the linked list. If v1 or v2 does not exist in the given linked list,
     * do nothing.
     *
     * Notice: You should swap the two nodes with values v1 and v2. Do not directly swap the values of the two nodes.
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        ListNode prefirst = null;
        ListNode presecond = null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null) {
            if (head.next.val == v1 || head.next.val == v2) {
                if (null == prefirst) {
                    prefirst = head;
                }else {
                    presecond = head;
                    break;
                }
            }
            head = head.next;
        }

        if (prefirst == null || presecond == null) {
            return dummy.next;
        }

        if (prefirst.next == presecond) {
            prefirst.next = presecond.next;
            presecond.next = presecond.next.next;
            prefirst.next.next = presecond;
            return dummy.next;
        }

        ListNode postsecond = presecond.next.next;
        ListNode first = prefirst.next;
        prefirst.next = presecond.next;
        presecond.next.next = first.next;
        presecond.next = first;
        first.next = postsecond;

        return dummy.next;
    }
}
