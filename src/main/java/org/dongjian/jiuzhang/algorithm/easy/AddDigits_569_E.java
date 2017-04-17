package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * Example
 * Given num = 38.
 * The process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return 2.
 * <p>
 * Challenge
 * Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits_569_E {
    public int addDigits(int num) {
        while (num >= 10) {
            num = trans(num);
        }

        return num;
    }

    private int trans(int num) {
        int res = 0;

        while (num > 0) {
            res = res + num % 10;
            num = num / 10;
        }

        return res;
    }
}
