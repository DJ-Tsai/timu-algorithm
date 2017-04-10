package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Notice
 * <p>
 * You can only move either down or right at any point in time.
 */
public class MinimunPathSum_110_E {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] res = new int[row][col];
        // System.out.println(row);
        // System.out.println(col);

        res[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            res[i][0] = res[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < col; j++) {
            res[0][j] = res[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
            }
        }


        return res[row - 1][col - 1];

    }
}
