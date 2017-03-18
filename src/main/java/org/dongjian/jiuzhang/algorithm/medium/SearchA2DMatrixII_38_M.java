package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.
 * <p>
 * This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * Integers in each column are sorted from up to bottom.
 * No duplicate integers in each row or column.
 * <p>
 *
 * Example:
 * [
 * [1, 3, 5, 7],
 * [2, 4, 7, 8],
 * [3, 5, 9, 10]
 * ]
 *
 * Given target = 3, return 2.
 */
public class SearchA2DMatrixII_38_M {
    public int searchMatrix(int[][] matrix, int target) {
        int count = 0;

        if (null == matrix || matrix.length == 0) {
            return count;
        }

        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return count;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while (row <= matrix.length - 1 && col >= 0) {
            if (target < matrix[row][col]) {
                col -= 1;
            } else if (target > matrix[row][col]) {
                row += 1;
            } else {
                count += 1;
                col -= 1;
                row += 1;
            }
        }

        return count;
    }
}
