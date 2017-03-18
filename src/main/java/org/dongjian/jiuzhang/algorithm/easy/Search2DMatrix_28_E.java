package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * <p>
 * This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * [
 * [1, 3, 5, 7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 *
 * Given target = 3, return true.
 */
public class Search2DMatrix_28_E {
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here

        if (matrix == null || matrix.length == 0 || matrix[0][0] > target) {
            return false;
        }

        int row = -1;

        for (int i = 0; i < matrix.length; i++) {
            if (target <= matrix[i][matrix[i].length - 1]) {
                row = i;
                break;
            }
        }
        if (row == -1) {
            return false;
        }

        for (int i = 0; i < matrix[row].length; i++) {
            if (target == matrix[row][i]) {
                return true;
            }
        }
        return false;
    }
}
