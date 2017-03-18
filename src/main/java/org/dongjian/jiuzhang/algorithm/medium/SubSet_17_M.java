package org.dongjian.jiuzhang.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of distinct integers, return all possible subsets.
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class SubSet_17_M {

    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        if (null == nums) {
            return null;
        }

        Arrays.sort(nums);

        ArrayList<ArrayList<Integer>> results = new ArrayList();

        dfsHelper(nums, 0, new ArrayList<Integer>(), results);


        return results;
    }

    public void dfsHelper(int[] nums,
                          int startIndex,
                          ArrayList<Integer> subSet,
                          ArrayList<ArrayList<Integer>> results) {
        results.add(new ArrayList<Integer>(subSet));
        for (int i = startIndex; i < nums.length; i++) {
            subSet.add(nums[i]);
            dfsHelper(nums, i + 1, subSet, results);
            subSet.remove(subSet.size() - 1);
        }
    }
}
