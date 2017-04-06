package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.ParentTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 * <p>
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 * <p>
 * The node has an extra attribute parent which point to the father of itself. The root's parent is null.
 */
public class LowestCommonAncesterII_474_E {
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        if (null == root || null == A || null == B) {
            return null;
        }

        List<ParentTreeNode> pathA = getPath(A);
        List<ParentTreeNode> pathB = getPath(B);

        int lastA = pathA.size() - 1;
        int lastB = pathB.size() - 1;

        int loop = Math.min(lastA, lastB);

        // A and B are not in the same tree
        if (pathA.get(lastA) != pathB.get(lastB)) {
            return null;
        }

        for (int i = 0; i <= loop; i++) {
            if (pathA.get(lastA) != pathB.get(lastB)) {
                return pathA.get(lastA + 1);
            }
            lastA--;
            lastB--;
        }

        return lastA == -1 ? A : B;
    }

    private List<ParentTreeNode> getPath(ParentTreeNode leaf) {
        List<ParentTreeNode> path = new ArrayList();

        if (null == leaf) {
            return null;
        }

        while (null != leaf) {
            path.add(leaf);
            leaf = leaf.parent;
        }

        return path;
    }
}