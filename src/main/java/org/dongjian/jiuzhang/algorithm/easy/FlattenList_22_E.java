package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.NestedInteger;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list, each element in the list can be a list or integer. flatten it into a simply list with integers.
 * <p>
 * Notice
 * <p>
 * If the element in the given list is a list, it can contain list too.
 * <p>
 * Example
 * Given [1,2,[1,2]], return [1,2,1,2].
 * <p>
 * Given [4,[3,[2,[1]]]], return [4,3,2,1].
 * <p>
 * Challenge
 * Do it in non-recursive.
 */
public class FlattenList_22_E {
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> res = new ArrayList<Integer>();

        if (nestedList == null || nestedList.size() == 0) {
            return res;
        }

        helper(nestedList, res);

        return res;
    }

    private void helper(List<NestedInteger> nestedList, List<Integer> res) {
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                res.add(n.getInteger());
                continue;
            }

            helper(n.getList(), res);
        }
    }
}
