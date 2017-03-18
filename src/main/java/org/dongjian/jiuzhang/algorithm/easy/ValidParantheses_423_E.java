package org.dongjian.jiuzhang.algorithm.easy;

import java.util.Stack;

/**
 * Created by Dj on 1/20/17.
 */
public class ValidParantheses_423_E {
    public boolean isValidParentheses(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<Character>();

        for (Character c : s.toCharArray()) {
            if (!"([{}])".contains(c.toString())) {
                continue;
            }
            if (stack.isEmpty()) {
                if ("}])".contains(c.toString())) {
                    return false;
                } else {
                    stack.push(c);
                }
            } else {
                if ("{[(".contains(c.toString())) {
                    stack.push(c);
                } else {
                    if (isValid(stack.peek(), c)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(Character a, Character b) {
        return (a == '[' && b == ']') || (a == '(' && b == ')') || (a == '{' && b == '}');
    }
}
