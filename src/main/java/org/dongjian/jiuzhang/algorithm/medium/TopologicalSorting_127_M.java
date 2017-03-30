package org.dongjian.jiuzhang.algorithm.medium;

import org.dongjian.jiuzhang.algorithm.common.DirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Dj on 3/29/17.
 */
public class TopologicalSorting_127_M {


    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();

        if (graph == null) {
            return res;
        }

        Map<DirectedGraphNode, Integer> indegree = getIndegree(graph);

        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : indegree.keySet()) {
            if (indegree.get(node) == 0) {
                queue.add(node);
            }
        }

        while(!queue.isEmpty()) {
            DirectedGraphNode head = queue.remove();
            res.add(head);
            for (DirectedGraphNode nb : head.neighbors) {
                int curIndegree = indegree.get(nb) - 1;
                if (curIndegree == 0) {
                    queue.add(nb);
                }
                indegree.put(nb, curIndegree);
            }
        }

        return res;

    }

    private Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> indegree = new HashMap<DirectedGraphNode, Integer>();

        for (DirectedGraphNode node : graph) {
            if (!indegree.containsKey(node)) {
                indegree.put(node, 0);
            }

            for (DirectedGraphNode n : node.neighbors) {
                if (!indegree.containsKey(n)) {
                    indegree.put(n, 1);
                } else {
                    indegree.put(n, indegree.get(n) + 1);
                }
            }
        }

        return indegree;
    }
}
