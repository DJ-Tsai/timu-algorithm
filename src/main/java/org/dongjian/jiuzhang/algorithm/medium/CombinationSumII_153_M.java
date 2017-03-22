package org.dongjian.jiuzhang.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * Each number in C may only be used once in the combination.
 * <p>
 * Notice
 * <p>
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * <p>
 * Given candidate set [10,1,6,7,2,1,5] and target 8,
 * <p>
 * A solution set is:
 * <p>
 * [
 * [1,7],
 * [1,2,5],
 * [2,6],
 * [1,1,6]
 * ]
 */
public class CombinationSumII_153_M {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList();

        if (null == num || num.length == 0) {
            return res;
        }

        Arrays.sort(num);
        boolean[] visited = new boolean[num.length];

        dfs(num, target, 0, new ArrayList<Integer>(), res, visited);

        return res;
    }

    private void dfs(int[] num, int target, int startIndex, List<Integer> subset, List<List<Integer>> res, boolean[] visited) {
        if (target == 0) {
            res.add(new ArrayList(subset));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = startIndex; i < num.length; i++) {

            // 去重 remove duplicate
            // 当后一个数和前一个数相同时,
            // 当他们在同一层, 则只执行一次,
            // 当他们呢在不同层, 则不用去重
            // 区别在于 同一层, 当执行到后一个数的时候, 前一个数是没有被访问的
            // 不同层时, 执行到后一个数是前一个数是被访问的,
            if (i > 0 && num[i] == num[i - 1] && !visited[i - 1]) {
                continue;
            }
            subset.add(num[i]);
            visited[i] = true;
            dfs(num, target - num[i], i + 1, subset, res, visited);
            visited[i] = false;
            subset.remove(subset.size() - 1);
        }
    }
}
