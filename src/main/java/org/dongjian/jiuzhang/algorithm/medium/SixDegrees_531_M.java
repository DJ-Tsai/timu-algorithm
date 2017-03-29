package org.dongjian.jiuzhang.algorithm.medium;

import org.dongjian.jiuzhang.algorithm.common.UndirectedGraphNode;

import java.util.*;

/**
 * Six degrees of separation is the theory that everyone and everything is six or fewer steps away, by way of introduction, from any other person in the world, so that a chain of "a friend of a friend" statements can be made to connect any two people in a maximum of six steps.
 * <p>
 * Given a friendship relations, find the degrees of two people, return -1 if they can not been connected by friends of friends.
 */
public class SixDegrees_531_M {
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {

        if (graph == null || s == null || t == null) {
            return -1;
        }
        if (!graph.contains(s) || !graph.contains(t)) {
            return -1;
        }
        if (s == t) {
            return 0;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        int steps = 0;
        queue.add(s);
        set.add(s);

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int j = 0; j < size; j++) {
                UndirectedGraphNode head = queue.remove();
                for (UndirectedGraphNode neib : head.neighbors) {
                    if (neib == t) {
                        return steps;
                    }

                    if (!set.contains(neib)) {
                        set.add(neib);
                        queue.add(neib);
                    }
                }
            }
        }

        return -1;
    }
}
