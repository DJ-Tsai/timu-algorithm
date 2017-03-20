package org.dongjian.jiuzhang.algorithm.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.
 * <p>
 * Find the number of islands.
 * <p>
 * Example
 * Given graph:
 * <p>
 * [
 * [1, 1, 0, 0, 0],
 * [0, 1, 0, 0, 1],
 * [0, 0, 0, 1, 1],
 * [0, 0, 0, 0, 0],
 * [0, 0, 0, 0, 1]
 * ]
 * return 3.
 */
public class NumberOfIsLands_433_E {
    public int numIslands(boolean[][] grid) {

        int count = 0;
        if (null == grid || grid.length == 0 || grid[0].length == 0) {
            return count;
        }

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col]) {
                    bfs(grid, row, col);
                    count += 1;
                }

            }
        }

        return count;
    }

    // invoke bfs on coordiate(x,y) and update grid to false for all traversed node
    private void bfs(boolean[][] grid, int row, int col) {
        int[] DIRECTION_X = {1, 0, -1, 0};
        int[] DIRECTION_Y = {0, 1, 0, -1};

        Queue<Coordinate> queue = new LinkedList();
        queue.add(new Coordinate(row, col));
        grid[row][col] = false;

        while (!queue.isEmpty()) {
            Coordinate current = queue.remove();

            for (int i = 0; i < 4; i++) {
                Coordinate adj = new Coordinate(current.x + DIRECTION_X[i], current.y + DIRECTION_Y[i]);
                if (inMatrix(grid, adj) && grid[adj.x][adj.y] == true) {
                    queue.add(adj);
                    grid[adj.x][adj.y] = false;
                }
            }
        }
    }

    private boolean inMatrix(boolean[][] grid, Coordinate a) {
        int rowLength = grid.length;
        int colLength = grid[0].length;

        return a.x <= rowLength - 1 && a.x >= 0 && a.y >= 0 && a.y <= colLength - 1;
    }

    private class Coordinate {
        private int x, y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
