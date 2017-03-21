package org.dongjian.jiuzhang.algorithm.medium;

import org.dongjian.jiuzhang.algorithm.common.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Deep Copy
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * <p>
 * How we serialize an undirected graph:
 * <p>
 * Nodes are labeled uniquely.
 * <p>
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * <p>
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * <p>
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * <p>
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 */
public class CloneGraph_137_M {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node == null) {
            return null;
        }

        ArrayList<UndirectedGraphNode> graph = constructGraph(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> newMap = new HashMap();

        // copy all nodes
        for (UndirectedGraphNode oldNode : graph) {
            newMap.put(oldNode, new UndirectedGraphNode(oldNode.label));
        }

        // copy all edges
        for (UndirectedGraphNode oldNode : graph) {
            ArrayList<UndirectedGraphNode> newNeighbors = new ArrayList();
            for (UndirectedGraphNode neighbor : oldNode.neighbors) {
                newNeighbors.add(newMap.get(neighbor));
            }
            newMap.get(oldNode).neighbors = newNeighbors;
        }

        return newMap.get(node);
    }


    private ArrayList<UndirectedGraphNode> constructGraph(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList();
        Set<UndirectedGraphNode> map = new HashSet();

        queue.add(node);
        map.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.remove();

            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (!map.contains(neighbor)) {
                    queue.add(neighbor);
                    map.add(neighbor);
                }
            }
        }

        return new ArrayList<UndirectedGraphNode>(map);

    }
}
