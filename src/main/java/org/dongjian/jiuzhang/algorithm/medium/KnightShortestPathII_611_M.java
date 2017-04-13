package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Given a knight in a chessboard n * m (a binary matrix with 0 as empty and 1 as barrier). the knight initialze position is (0, 0) and he wants to reach position (n - 1, m - 1), Knight can only be from left to right. Find the shortest path to the destination position, return the length of the route. Return -1 if knight can not reached.
 * <p>
 * Clarification
 * If the knight is at (x, y), he can get to the following positions in one step:
 * <p>
 * (x + 1, y + 2)
 * (x - 1, y + 2)
 * (x + 2, y + 1)
 * (x - 2, y + 1)
 * <p>
 * Example
 * [[0,0,0,0],
 * [0,0,0,0],
 * [0,0,0,0]]
 * <p>
 * Return 3
 * <p>
 * [[0,0,0,0],
 * [0,0,0,0],
 * [0,1,0,0]]
 * <p>
 * Return -1
 */
public class KnightShortestPathII_611_M {
    public int shortestPath2(boolean[][] grid) {
        // ---------------DP------------------//
        int r = grid.length;
        int c = grid[0].length;

        int[] dir_x = {1, -1, 2, -2};
        int[] dir_y = {2, 2, 1, 1};

        int[][] path = new int[r][c];
        // init
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                path[i][j] = Integer.MAX_VALUE;
            }
        }
        // path[0][0] = 0;
        for (int i = 0; i < dir_x.length; i++) {
            int x = 0 + dir_x[i];
            int y = 0 + dir_y[i];

            if (inBound(x, y, grid)) {
                path[x][y] = 1;
            }
        }

        // loop
        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++) {
                if (grid[i][j] || path[i][j] == Integer.MAX_VALUE) {
                    continue;
                } else {
                    for (int k = 0; k < dir_x.length; k++) {
                        int x = i + dir_x[k];
                        int y = j + dir_y[k];

                        if (inBound(x, y, grid) && !grid[x][y]) {
                            path[x][y] = Math.min(path[x][y], path[i][j] + 1);
                        }
                    }
                }


            }
        }

        return path[r - 1][c - 1] == Integer.MAX_VALUE ? -1 : path[r - 1][c - 1];
    }

    private boolean inBound(int x, int y, boolean[][] grid) {
        int r = grid.length;
        int c = grid[r - 1].length;

        return x >= 0 && x <= r - 1 && y >= 0 && y <= c - 1;
    }
}
