package org.dongjian.jiuzhang.algorithm.easy;

import java.util.ArrayList;

/**
 * Created by Dj on 1/20/17.
 */
public class ImplementStack_495_E {
    ArrayList<Integer> stackList = new ArrayList<Integer>();

    // Push a new item into the stack
    public void push(int x) {
        // Write your code here
        stackList.add(x);
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        stackList.remove(stackList.size()-1);
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        return stackList.get(stackList.size()-1);
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return stackList.isEmpty();
    }
}
