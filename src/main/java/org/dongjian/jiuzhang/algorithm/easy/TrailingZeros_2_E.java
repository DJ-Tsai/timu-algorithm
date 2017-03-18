package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 *
 * 11! = 39916800, so the out should be 2
 */
public class TrailingZeros_2_E {
    public long trailingZeros(long n) {
        // write your code here
        long count = 0;
        while (n / 5 > 0) {
            count = count + n / 5;
            n = n / 5;
        }

        return count;
    }
}
