package org.dongjian.jiuzhang.algorithm.easy;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Example
 * Given an example n=3 , 1+1+1=2+1=1+2=3
 * <p>
 * return 3
 */
public class ClimbingStairs_111_E {
    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }

        int[] res = new int[]{1, 2};
        if (n <= 2) {
            return res[n - 1];
        }

        while (n - 2 > 0) {
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp + res[0];
            n = n - 1;
        }

        return res[1];
    }
}
