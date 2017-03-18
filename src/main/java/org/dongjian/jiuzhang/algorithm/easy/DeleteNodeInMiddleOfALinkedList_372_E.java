package org.dongjian.jiuzhang.algorithm.easy;

import com.faith.dj.jiuzhang.java.fundamental.common.ListNode;

/**
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
 * Created by Dj on 1/18/17.
 */
public class DeleteNodeInMiddleOfALinkedList_372_E {
    public void deleteNode(ListNode node) {
        // write your code here
        if (node == null || node.next == null) {
            return;
        }

        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
