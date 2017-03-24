package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x.
 * <p>
 * Example
 * sqrt(3) = 1
 * <p>
 * sqrt(4) = 2
 * <p>
 * sqrt(5) = 2
 * <p>
 * sqrt(10) = 3
 *
 * Challenge: O(log(x))
 */
public class SqrtOfX_141_E {
    public int sqrt(int x) {
        if (x < 0) {
            return -1;
        }

        long start = 0;
        long end = x;

        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            long prod = mid * mid;

            if (prod < x) {
                start = mid;
            } else if (prod > x) {
                end = mid;
            } else {
                return (int) mid;
            }
        }

        if (end * end > x) {
            return (int) start;
        } else {
            return (int) end;
        }
    }
}
