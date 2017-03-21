package org.dongjian.jiuzhang.algorithm.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D grid, each cell is either a wall 2, a zombie 1 or people 0 (the number zero, one, two).Zombies can turn the nearest people(up/down/left/right) into zombies every day, but can not through wall. How long will it take to turn all people into zombies? Return -1 if can not turn all people into zombies.
 * <p>
 * Example
 * Given a matrix:
 * <p>
 * 0 1 2 0 0
 * 1 0 0 2 1
 * 0 1 0 0 0
 * return 2
 */
public class ZombieInMatrix_598_M {
    public int zombie(int[][] grid) {
        int[] DIRECTION_X = {1, -1, 0, 0};
        int[] DIRECTION_Y = {0, 0, 1, -1};

        int count = -1;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return count;
        }

        Queue<Point> queue = new LinkedList<Point>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    queue.add(new Point(row, col));
                }
            }
        }

        while (!queue.isEmpty()) {
            count += 1;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point point = queue.remove();

                for (int j = 0; j < DIRECTION_X.length; j++) {
                    Point adj = new Point(point.x + DIRECTION_X[j], point.y + DIRECTION_Y[j]);
                    if (inGrid(grid, adj) && grid[adj.x][adj.y] == 0) {
                        queue.add(adj);
                        grid[adj.x][adj.y] = 1;
                    }
                }
            }
        }

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 0) {
                    return -1;
                }
            }
        }

        return count;
    }

    private boolean inGrid(int[][] grid, Point p) {
        int row = grid.length;
        int col = grid[0].length;

        return p.x >= 0 && p.x <= row - 1 && p.y >= 0 && p.y <= col - 1;
    }

    class Point {
        public int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
