package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Created by Dj on 1/21/17.
 */
public class ImplementQueueByLinkedList_493_E {
    private Node head, last;

    public ImplementQueueByLinkedList_493_E() {
        // do initialize if necessary
    }

    public void enqueue(int item) {
        // Write your code here
        if (head == null) {
            head = new Node(item);
            last = head;
        } else {
            last.next = new Node(item);
            last = last.next;
        }
    }

    public int dequeue() {
        // Write your code here
        int rlt = head.val;
        head = head.next;
        return rlt;
    }

    protected class Node {
        protected int val;
        protected Node next;

        protected Node(int val) {
            this.val = val;
            next = null;
        }
    }
}
