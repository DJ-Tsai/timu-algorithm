package org.dongjian.jiuzhang.algorithm.naive;

import java.util.ArrayList;
import java.util.List;

public class ConvertLinkedListToArrayList_483_N {
    /**
     * @param head the head of linked list.
     * @return an array list
     */
    public List<Integer> toArrayList(ListNode head) {
        // Write your code here
        List<Integer> arrayList = new ArrayList<Integer>();

        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }
        return arrayList;
    }

    //  Definition for ListNode.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
