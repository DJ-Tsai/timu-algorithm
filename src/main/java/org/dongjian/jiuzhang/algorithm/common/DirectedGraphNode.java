package org.dongjian.jiuzhang.algorithm.common;

import java.util.ArrayList;

/**
 * Created by Dj on 3/29/17.
 */
public class DirectedGraphNode {
    public int label;
    public ArrayList<DirectedGraphNode> neighbors;

    public DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}
