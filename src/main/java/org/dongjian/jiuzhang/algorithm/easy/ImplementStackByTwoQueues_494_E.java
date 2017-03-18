package org.dongjian.jiuzhang.algorithm.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dj on 1/20/17.
 */
public class ImplementStackByTwoQueues_494_E {
    public Queue<Integer> q1;
    public Queue<Integer> q2;

    ImplementStackByTwoQueues_494_E() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        // Write your code here
        q1.add(x);
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        int count = 0;
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
            count++;
        }
        for (int i = 0; i < count-1; i++) {
            q1.add(q2.poll());
        }
        q2.poll();
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        int top = 0;

        while (!q1.isEmpty()){
            top = q1.poll();
            q2.add(top);
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return q1.isEmpty();
    }
}
