package org.dongjian.jiuzhang.algorithm.medium;

import org.dongjian.jiuzhang.algorithm.common.RandomListNode;

import java.util.HashMap;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 * <p>
 * Challenge
 * Could you solve it with O(1) space?
 */
public class CopyListWithRandomPointer_105_M {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
        head = dummy;

        // copy all nodes
        while (head.next != null) {
            head = head.next;
            RandomListNode newNode = new RandomListNode(head.label);
            map.put(head, newNode);
        }

        head = dummy;

        while (head.next != null) {
            head = head.next;
            if (head.next != null)
                map.get(head).next = map.get(head.next);

            if (head.random != null)
                map.get(head).random = map.get(head.random);
        }

        return map.get(dummy.next);
    }
}
