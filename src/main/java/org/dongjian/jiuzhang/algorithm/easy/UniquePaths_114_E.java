package org.dongjian.jiuzhang.algorithm.easy;

/**
 * A robot is located at the top-left corner of a m x n grid.
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
 * <p>
 * How many possible unique paths are there?
 * <p>
 * Notice
 * <p>
 * m and n will be at most 100.
 * <p>
 * Example
 * Given m = 3 and n = 3, return 6.
 * Given m = 4 and n = 5, return 35.
 */
public class UniquePaths_114_E {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            res[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }

        return res[m - 1][n - 1];
    }
}
