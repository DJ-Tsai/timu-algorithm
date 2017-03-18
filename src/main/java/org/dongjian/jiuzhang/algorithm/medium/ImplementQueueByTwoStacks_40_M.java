package org.dongjian.jiuzhang.algorithm.medium;

import java.util.Stack;

/**
 * Created by Dj on 1/20/17.
 */
public class ImplementQueueByTwoStacks_40_M {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public ImplementQueueByTwoStacks_40_M() {
        // do initialization if necessary
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return result;
    }

    public int top() {
        // write your code here
        return stack1.firstElement();
    }
}
