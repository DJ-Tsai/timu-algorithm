package org.dongjian.jiuzhang.algorithm.easy;

import java.util.Arrays;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * Example
 * Given [1,2,3] which represents 123, return [1,2,4].
 * <p>
 * Given [9,9,9] which represents 999, return [1,0,0,0].
 */
public class PlusOne_407_E {
    public int[] plusOne(int[] digits) {
        int carry = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                digits[i] += 1;
            }
            int cur = digits[i] + carry;
            digits[i] = cur % 10;
            carry = cur / 10;
        }

        if (carry == 1) {
            int[] res = new int[digits.length + 1];

            res[0] = 1;
            for (int i = 1; i < res.length; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        } else {
            return Arrays.copyOf(digits, digits.length);
        }
    }
}
