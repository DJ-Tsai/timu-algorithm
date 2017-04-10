package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Follow up for "Unique Paths":
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * Notice
 * <p>
 * m and n will be at most 100.
 * <p>
 * Example
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 */
public class UniquePathII_115_E {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int[][] res = new int[row][col];

        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                res[i][0] = 0;
                break;
            }
            res[i][0] = 1;
        }

        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }

            res[0][i] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }

        return res[row - 1][col - 1];
    }
}
