package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Given 2*n + 1 numbers, every numbers occurs twice except one, find it.
 * <p>
 * Example
 * Given [1,2,2,1,3,4,3], return 4
 * <p>
 * Challenge
 * One-pass, constant extra space.
 */
public class SingleNumber_82_E {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res = res ^ A[i];
        }

        return res;
    }
}
