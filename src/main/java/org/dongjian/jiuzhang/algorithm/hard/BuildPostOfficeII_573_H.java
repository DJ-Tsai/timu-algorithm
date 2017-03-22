package org.dongjian.jiuzhang.algorithm.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D grid, each cell is either a wall 2, an house 1 or empty 0 (the number zero, one, two), find a place to build a post office so that the sum of the distance from the post office to all the houses is smallest.
 * <p>
 * Return the smallest sum of distance. Return -1 if it is not possible.
 * <p>
 * Notice
 * <p>
 * You cannot pass through wall and house, but can pass through empty.
 * You only build post office on an empty.
 * Given a grid:
 * <p>
 * 0 1 0 0 0
 * 1 0 0 2 1
 * 0 1 0 0 0
 * return 8, You can build at (1,1). (Placing a post office at (1,1), the distance that post office to all the house sum is smallest.)
 * <p>
 * Challenge
 * Solve this problem within O(n^3) time.
 */
public class BuildPostOfficeII_573_H {
    public int shortestDistance(int[][] grid) {
        ArrayList<Point> houseList = new ArrayList();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        // find all houses and add them to queue
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    houseList.add(new Point(row, col));
                }
            }
        }

        // loop through all house to find the distance to all empty point
        for (Point point : houseList) {
            bfs(point, grid, visited);
        }

        // find min distance
        int minDistance = Integer.MIN_VALUE;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] < 0 && grid[row][col] > minDistance) {
                    minDistance = grid[row][col];
                }
            }
        }

        return minDistance > Integer.MIN_VALUE ? -1 * minDistance : -1;
    }

    private void bfs(Point point, int[][] grid, boolean[][] visited) {
        int[] DIRECTION_X = {1, -1, 0, 0};
        int[] DIRECTION_Y = {0, 0, -1, 1};
        int distance = 0;

        Queue<Point> queue = new LinkedList();
        queue.add(point);

        while (!queue.isEmpty()) {
            int size = queue.size();
            distance += -1;

            for (int level = 0; level < size; level++) {
                Point head = queue.remove();
                for (int i = 0; i < 4; i++) {
                    Point neighbor = new Point(head.x + DIRECTION_X[i], head.y + DIRECTION_Y[i]);
                    if (inMatrix(grid, neighbor) && !visited[neighbor.x][neighbor.y]) {
                        if (grid[neighbor.x][neighbor.y] < 1) {
                            grid[neighbor.x][neighbor.y] += distance;
                            queue.add(new Point(neighbor.x, neighbor.y));
                        }
                        visited[neighbor.x][neighbor.y] = true;
                    }
                }
            }
        }
        reset(visited, grid);

    }

    // every point shoule be reached, otherwise the point with value zeor is not reachable
    private void reset(boolean[][] visited, int[][] grid) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if (visited[i][j] == false) {
                    grid[i][j] = 2;
                    continue;
                }
                visited[i][j] = false;
            }
        }
    }

    private boolean inMatrix(int[][] grid, Point point) {
        int row = grid.length;
        int col = grid[0].length;

        return point.x >= 0 && point.x <= row - 1 && point.y >= 0 && point.y <= col - 1;
    }

    class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
