package org.dongjian.jiuzhang.algorithm.naive;

/**
 * Created by Dj on 1/11/17.
 */
public class Reference_456_N {
    /**
     * Definition of Node:
     * class Node {
     * public int val;
     * public Node(int val) {
     * this.val = val;
     * }
     * }
     */
    public class ReferenceManager {
        public Node node;

        public void copyValue(Node obj) {
            // copy value from obj to node
            this.node = new Node(obj.val);
        }

        public void copyReference(Node obj) {
            // copy reference from obj to node
            this.node = obj;
        }
    }

    class Node {
        public int val;

        public Node(int val) {
            this.val = val;
        }
    }
}