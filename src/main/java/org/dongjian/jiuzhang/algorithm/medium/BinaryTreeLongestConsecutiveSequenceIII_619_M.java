package org.dongjian.jiuzhang.algorithm.medium;

import org.dongjian.jiuzhang.algorithm.common.MultiTreeNode;

/**
 * It's follow up problem for Binary Tree Longest Consecutive Sequence II
 * <p>
 * Given a k-ary tree, find the length of the longest consecutive sequence path.
 * The path could be start and end at any node in the tree
 *
 * Example
 * An example of test data: k-ary tree 5<6<7<>,5<>,8<>>,4<3<>,5<>,3<>>>, denote the following structure:
 * <p>
 * <p>
 *      5
 *    /   \
 *   6     4
 *  /|\   /|\
 * 7 5 8 3 5 3
 * <p>
 * Return 5, // 3-4-5-6-7
 */
public class BinaryTreeLongestConsecutiveSequenceIII_619_M {
    public int longestConsecutive3(MultiTreeNode root) {
        return dfs(root).maxLen;
    }

    private ResultType dfs(MultiTreeNode root) {
        if (null == root) {
            return new ResultType(0, 0, 0);
        }

        ResultType curResult = new ResultType(1, 1, 1);

        if (root.children == null | root.children.isEmpty()) {
            return curResult;
        }

        ResultType[] childs = new ResultType[root.children.size()];
        for (int i = 0; i < childs.length; i++) {
            childs[i] = dfs(root.children.get(i));
        }

        for (int i = 0; i < childs.length; i++) {
            if (root.children.get(i).val + 1 == root.val) {
                curResult.btotInc = Math.max(curResult.btotInc, childs[i].btotInc + 1);
            }

            if (root.children.get(i).val - 1 == root.val) {
                curResult.btotDec = Math.max(curResult.btotDec, childs[i].btotDec + 1);
            }

            curResult.maxLen = Math.max(curResult.maxLen, childs[i].maxLen);
        }

        curResult.maxLen = Math.max(curResult.maxLen, curResult.btotInc + curResult.btotDec - 1);

        return curResult;
    }

    private class ResultType {
        int maxLen;
        int btotInc, btotDec;

        ResultType(int maxLen, int btotInc, int btotDec) {
            this.maxLen = maxLen;
            this.btotInc = btotInc;
            this.btotDec = btotDec;
        }
    }
}
