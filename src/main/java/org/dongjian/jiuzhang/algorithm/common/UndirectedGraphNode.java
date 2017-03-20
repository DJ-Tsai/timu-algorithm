package org.dongjian.jiuzhang.algorithm.common;

import java.util.ArrayList;

/**
 * Created by dc044031 on 3/20/17.
 */
public class UndirectedGraphNode {
    public int label;
    public ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
