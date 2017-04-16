package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in ZigZag-order.
 * <p>
 * Example
 * Given a matrix:
 * <p>
 * [
 * [1, 2,  3,  4],
 * [5, 6,  7,  8],
 * [9,10, 11, 12]
 * ]
 * return [1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12]
 */
public class MatrixZigzagTraversal_185_E {
    public int[] printZMatrix(int[][] matrix) {

        if (matrix == null) {
            return null;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int[] res = new int[row * col];

        //int i = 0, j = 0;

        int count = 0;
        for (int c = 0; c <= row - 1 + col - 1; c++) {
            int bottom, up;

            if (c <= Math.min(row - 1, col - 1)) {
                bottom = 0;
                up = c;
            } else if (c >= Math.max(row - 1, col - 1)) {
                bottom = c - (col - 1);
                up = row - 1;
            } else {
                if (c > row - 1) {
                    bottom = 0;
                    up = row - 1;
                } else {
                    bottom = c - (col - 1);
                    up = c;
                }
            }
            if (c % 2 != 0) {
                for (int i = bottom; i <= up; i++) {
                    res[count++] = matrix[i][c - i];
                }
            } else {
                for (int i = up; i >= bottom; i--) {
                    res[count++] = matrix[i][c - i];
                }
            }
        }

        return res;
    }
}
