package org.dongjian.jiuzhang.algorithm.easy;

public class MergeTwoSortedLists_165_E {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // if (l1 == null) {
        //     return l2;
        // }

        // if (l2 == null) {
        //     return l1;
        // }

        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        l1 = dummy;

        while (l2 != null) {

            if (l1.next == null) {
                l1.next = l2;
                return dummy.next;
            }

            ListNode copyFromL2 = new ListNode(l2.val);

            if (l1.next.val > copyFromL2.val) {
                copyFromL2.next = l1.next;
                l1.next = copyFromL2;
                l1 = l1.next;
                l2 = l2.next;
            }else{
                l1 = l1.next;
            }
        }

        return dummy.next;
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