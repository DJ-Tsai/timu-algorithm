package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.NestedInteger;

import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth. Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * <p>
 * Example
 * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1, 4 * 1 * 2 + 1 * 2 * 1 = 10)
 * Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 42 + 63 = 27)
 */
public class NestedListWeightSum_551_E {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return 0;
        }
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger nestInt : nestedList) {
            if (nestInt.isInteger()) {
                sum = sum + nestInt.getInteger() * depth;
                continue;
            }

            sum = sum + helper(nestInt.getList(), depth + 1);
        }

        return sum;
    }
}
