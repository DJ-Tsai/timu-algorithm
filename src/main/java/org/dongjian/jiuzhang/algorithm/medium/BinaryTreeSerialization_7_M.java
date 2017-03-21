package org.dongjian.jiuzhang.algorithm.medium;

import org.dongjian.jiuzhang.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.
 * 
 */
public class BinaryTreeSerialization_7_M {
    public String serialize(TreeNode root) {
        if (null == root) {
            return null;
        }

        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);

        for (int i = 0; i < queue.size(); i++) {
            TreeNode currentNode = queue.get(i);
            if (null == currentNode) {
                continue;
            }
            queue.add(currentNode.left);
            queue.add(currentNode.right);
        }

        return translate(queue);

    }

    private String translate(LinkedList<TreeNode> queue) {
        if (null == queue || queue.isEmpty()) {
            return "{}";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append(queue.remove().val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (null != node) {
                builder.append(",").append(node.val);
            } else {
                builder.append(",#");
            }
        }
        builder.append("}");
        return builder.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (null == data || data == "{}") {
            return null;
        }

        String[] values = data.substring(1, data.length() - 1).split(",");

        List<TreeNode> tree = new ArrayList();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        tree.add(root);
        // index to track the current node for adding child
        int index = 0;
        boolean isLeft = true;

        for (int i = 1; i < values.length; i++) {
            if (values[i].equals("#")) {
                if (isLeft) {
                } else {
                    index++;
                }
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(values[i]));
                tree.add(node);
                if (isLeft) {
                    tree.get(index).left = node;
                } else {
                    tree.get(index).right = node;
                    index++;
                }
            }
            isLeft = !isLeft;
        }

        return tree.get(0);
    }
}
