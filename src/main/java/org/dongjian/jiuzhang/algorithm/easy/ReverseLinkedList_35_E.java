package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Created by Dj on 1/17/17.
 */
public class ReverseLinkedList_35_E {

    /**
     *
     * @param head {@link ListNode}
     * @return
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode dummy = new ListNode(0);

        while (head != null) {
            ListNode newNode = new ListNode(head.val);
            newNode.next = dummy.next;
            dummy.next = newNode;
            head = head.next;
        }

        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int value) {
            this.val = value;
        }
    }
}
