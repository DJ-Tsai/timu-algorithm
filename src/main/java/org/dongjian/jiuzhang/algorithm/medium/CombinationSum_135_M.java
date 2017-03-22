package org.dongjian.jiuzhang.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dc044031 on 3/22/17.
 */
public class CombinationSum_135_M {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        if (null == candidates || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);

        dfs(candidates, target, 0, new ArrayList<Integer>(), res);

        return res;
    }

    private void dfs(int[] candidates, int target, int index, List<Integer> subset, List<List<Integer>> res) {
        if (target == 0) {
            // deep copy!!!!!!!!!
            res.add(new ArrayList(subset));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; ++i) {

            // remove dup
            if (i > 0 && candidates[i] == candidates[i -1]) {
                continue;
            }
            subset.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}
