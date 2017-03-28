package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * <p>
 * This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example
 * Consider the following matrix:
 * <p>
 * [
 * [1, 3, 5, 7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 *
 * Challenge: O(log(n) + log(m)) time
 */
public class SearchA2DMatrix_28_E {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        if (matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target) {
            return false;
        }

        int start = 0;
        int end = matrix.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (matrix[mid][0] < target) {
                start = mid;
            } else if (matrix[mid][0] > target) {
                end = mid;
            } else {
                return true;
            }
        }

        int row;
        if (matrix[end][0] < target) {
            row = end;
        } else {
            row = start;
        }

        start = 0;
        end = matrix[row].length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (matrix[row][mid] < target) {
                start = mid;
            } else if (matrix[row][mid] > target) {
                end = mid;
            } else {
                return true;
            }
        }

        if (matrix[row][start] == target || matrix[row][end] == target) {
            return true;
        }
        return false;

    }
}
