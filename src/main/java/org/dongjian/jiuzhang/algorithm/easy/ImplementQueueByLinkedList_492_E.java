package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Created by Dj on 1/20/17.
 */
public class ImplementQueueByLinkedList_492_E {
    private Node first, last;

    // also call it @java.util.Deque
    public ImplementQueueByLinkedList_492_E() {
        // do initialize if necessary
    }

    public void push_front(int item) {
        // Write your code here
        if (first == null) {
            first = new Node(item);
            last = first;
        } else {
            Node pre = new Node(item);
            pre.next = first;
            first = pre;
        }
    }

    public void push_back(int item) {
        // Write your code here
        if (first == null) {
            first = new Node(item);
            last = first;
        } else {
            last.next = new Node(item);
            last = last.next;
        }
    }

    public int pop_front() {
        // Write your code here
        int pop = first.val;
        first = first.next;
        return pop;
    }

    public int pop_back() {
        // Write your code here
        if (first == last) {
            int pop = first.val;
            first = last = null;
            return pop;
        }

        Node temp = first;
        while (temp.next != last) {
            temp = temp.next;
        }
        int pop = last.val;
        last = temp;
        last.next = null;
        return pop;
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
