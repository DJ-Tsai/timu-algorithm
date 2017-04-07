package org.dongjian.jiuzhang.algorithm.medium;

import org.dongjian.jiuzhang.algorithm.common.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * <p>
 * Analyze and describe its complexity.
 * <p>
 * Example
 * Given lists:
 * <p>
 * [
 * 2->4->null,
 * null,
 * -1->null
 * ],
 * return -1->2->4->null.
 */
public class MergeKSortedList_104_M {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.isEmpty()) {
            return null;
        }

        Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {

            public int compare(ListNode o1, ListNode o2) {

                return o1.val - o2.val;
            }
        });

        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node);
                node = node.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (!queue.isEmpty()) {
            head.next = queue.remove();
            head = head.next;
        }

        head.next = null;

        return dummy.next;
    }
}
