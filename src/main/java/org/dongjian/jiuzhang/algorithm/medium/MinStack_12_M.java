package org.dongjian.jiuzhang.algorithm.medium;

import java.util.Stack;

/**
 * Implement a stack with min() function, which will return the smallest number in the stack.
 *
 * It should support push, pop and min operation all in O(1) cost.
 *
 * Notice: min operation will never be called if there is no number in the stack.
 */
public class MinStack_12_M {
    Stack<Integer> stack;
    Stack<Integer> miniStack;

    public MinStack_12_M(){
        // do initialize if necessary
        stack = new Stack<Integer>();
        miniStack = new Stack<Integer>();
    }

    public void push(int number){
        // write your code here
        stack.push(number);
        if (miniStack.isEmpty()) {
            miniStack.push(number);
        } else {
            miniStack.push(Math.min(miniStack.peek(),number));
        }

    }

    public int pop(){
        // write your code here
        miniStack.pop();
        return stack.pop();
    }

    public int min(){
        // write your code here
        return miniStack.peek();
    }
}
