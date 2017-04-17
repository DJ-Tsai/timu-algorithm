package org.dongjian.jiuzhang.algorithm.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is happy.
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * Example
 * 19 is a happy number
 * <p>
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber_488_E {
    public boolean isHappy(int n) {
        Set<Integer> history = new HashSet<Integer>();

        while (n != 1) {
            if (history.contains(n)) {
                return false;
            }
            history.add(n);
            n = trans(n);
        }

        return true;
    }

    private int trans(int n) {
        int res = 0;

        while (n != 0) {
            int digit = n % 10;
            res = res + digit * digit;
            n = n / 10;
        }

        return res;
    }
}
