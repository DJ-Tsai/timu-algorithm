package org.dongjian.jiuzhang.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of numbers, return all possible permutations.
 * For nums = [1,2,3], the permutations are:
 * <p>
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutation_15_M {
    public List<List<Integer>> permute(int[] nums) {
        if (null == nums) {
            return null;
        }

        List<List<Integer>> results = new ArrayList();
        List<Integer> subset = new ArrayList();
        if (nums.length == 0) {
            results.add(subset);
            return results;
        }

        helper(nums, subset, results);

        return results;
    }

    private void helper(int[] nums, List<Integer> subset, List<List<Integer>> results) {
        if (subset.size() == nums.length) {
            results.add(new ArrayList(subset));
            return;
        }

        for (int num : nums) {
            if (subset.contains(num)) {
                continue;
            }
            subset.add(num);
            helper(nums, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
}
