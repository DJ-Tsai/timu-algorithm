package org.dongjian.jiuzhang.algorithm.medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given some points and a point origin in two dimensional space, find k points out of the some points which are nearest to origin.
 * Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.
 * <p>
 * Example
 * Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
 * return [[1,1],[2,5],[4,4]]
 */
public class KthClosestPoint_612_M {
    public Point[] kClosest(Point[] points, final Point origin, int k) {
        Queue<Point> queue = new PriorityQueue<Point>(k, new Comparator<Point>() {

            public int compare(Point o1, Point o2) {
                int dist1 = (o1.x - origin.x) * (o1.x - origin.x) + (o1.y - origin.y) * (o1.y - origin.y);
                int dist2 = (o2.x - origin.x) * (o2.x - origin.x) + (o2.y - origin.y) * (o2.y - origin.y);

                if (dist1 != dist2) {
                    return dist2 - dist1;
                } else if (o1.x != o2.x) {
                    return o2.x - o1.x;
                } else {
                    return o2.y - o1.y;
                }
            }

        });

        for (int i = 0; i < points.length; i++) {
            queue.add(points[i]);
            if (queue.size() > k) {
                queue.remove();
            }
        }

        // return results
        Point[] res = new Point[queue.size()];
        for (int i = queue.size() - 1; i >= 0; i--) {
            res[i] = queue.remove();
        }

        return res;
    }

    private class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
