package org.dongjian.jiuzhang.algorithm.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source position, find the shortest path to a destination position, return the length of the route.
 * Return -1 if knight can not reached.
 * <p>
 * Clarification
 * If the knight is at (x, y), he can get to the following positions in one step:
 * <p>
 * (x + 1, y + 2)
 * (x + 1, y - 2)
 * (x - 1, y + 2)
 * (x - 1, y - 2)
 * (x + 2, y + 1)
 * (x + 2, y - 1)
 * (x - 2, y + 1)
 * (x - 2, y - 1)
 * Example
 * [[0,0,0],
 * [0,0,0],
 * [0,0,0]]
 * source = [2, 0] destination = [2, 2] return 2
 * <p>
 * [[0,1,0],
 * [0,0,0],
 * [0,0,0]]
 * source = [2, 0] destination = [2, 2] return 6
 * <p>
 * [[0,1,0],
 * [0,0,1],
 * [0,0,0]]
 * source = [2, 0] destination = [2, 2] return -1
 */
public class KnightShortestPath_611_M {
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        int[] DIRECTION_X = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] DIRECTION_Y = {2, -2, 2, -2, 1, -1, 1, -1};

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int path = 0;
        Queue<Point> queue = new LinkedList();
        queue.add(source);
        grid[source.x][source.y] = true;

        while (!queue.isEmpty()) {

            // size of current level
            int size = queue.size();

            // traver current level
            for (int j = 0; j < size; j++) {
                Point head = queue.remove();
                if (head.x == destination.x && head.y == destination.y) {
                    return path;
                }

                // add next level
                for (int i = 0; i < DIRECTION_X.length; i++) {
                    Point dest = new Point(head.x + DIRECTION_X[i], head.y + DIRECTION_Y[i]);
                    if (inMatrix(grid, dest) && grid[dest.x][dest.y] == false) {
                        queue.add(dest);
                        grid[dest.x][dest.y] = true;
                    }
                }
            }

            path += 1;
        }

        return -1;
    }

    private boolean inMatrix(boolean[][] grid, Point point) {
        int rowNum = grid.length;
        int colNum = grid[0].length;

        return point.x >= 0 && point.x <= rowNum - 1 && point.y >= 0 && point.y <= colNum - 1;
    }

    public class Point {
        public int x, y;

        public Point() {
            x = 0;
            y = 0;
        }

        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
