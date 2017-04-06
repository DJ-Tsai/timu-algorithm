package org.dongjian.jiuzhang.algorithm.medium;

import org.dongjian.jiuzhang.algorithm.common.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dj on 1/19/17.
 */
public class PalindromeLinkedList_223_MTest {

    @Test
    public void test1() {
        PalindromeLinkedList_223_M fun = new PalindromeLinkedList_223_M();

        ListNode node = new ListNode(3);
        node.next = new ListNode(4);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(3);

        fun.isPalindrome(node);
    }
}