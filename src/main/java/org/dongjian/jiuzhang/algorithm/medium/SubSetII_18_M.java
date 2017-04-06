package org.dongjian.jiuzhang.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a list of numbers that may has duplicate numbers, return all possible subsets
 * If S = [1,2,2], a solution is:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class SubSetII_18_M {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        if (null == nums) {
            return null;
        }
        ArrayList<ArrayList<Integer>> results = new ArrayList();

        Arrays.sort(nums);

        dfsHelper(nums, 0, new ArrayList(), results);

        return results;
    }

    private void dfsHelper(int[] nums,
                           int startIndex,
                           ArrayList<Integer> subset,
                           ArrayList<ArrayList<Integer>> results) {
        results.add(new ArrayList(subset));
        for (int i = startIndex; i < nums.length; i++) {
            if (i == startIndex || nums[i] != nums[i - 1]) {
                subset.add(nums[i]);
                dfsHelper(nums, i + 1, subset, results);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
