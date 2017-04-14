package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p>
 * Example
 * Given n = 12, return 3 because 12 = 4 + 4 + 4
 * Given n = 13, return 2 because 13 = 4 + 9
 */
public class PerfectSquare_513_M {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        // init
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }

        return dp[n];
    }
}
