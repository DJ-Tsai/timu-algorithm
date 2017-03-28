package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Implement double sqrt(double x) and x >= 0.
 * <p>
 * Compute and return the square root of x.
 */
public class sqrtOfXII_586_M {
    public double sqrt(double x) {
        double start = 0;
        double end = x;
        double delta = 1e-12;

        if (end < 1) {
            end = 1;
        }

        while (end - start > delta) {
            double mid = (start + end) / 2;

            if (mid * mid > x) {
                end = mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                return mid;
            }
        }

        if (end * end > x) {
            return start;
        } else {
            return end;
        }
    }
}
