package org.dongjian.jiuzhang.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of numbers with duplicate number in it. Find all unique permutations.
 * <p>
 * For numbers [1,2,2] the unique permutations are:
 * <p>
 * [
 * [1,2,2],
 * [2,1,2],
 * [2,2,1]
 * ]
 */
public class PermutationII_16_M {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList();
        boolean[] visited = new boolean[nums.length];

        if (null == nums) {
            return results;
        }

        Arrays.sort(nums);

        helper(nums, new ArrayList<Integer>(), visited, results);
        return results;
    }

    private void helper(int[] nums, List<Integer> container, boolean[] visited, List<List<Integer>> results) {
        if (container.size() == nums.length) {
            results.add(new ArrayList(container));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            container.add(nums[i]);
            visited[i] = true;
            helper(nums, container, visited, results);
            visited[i] = false;
            container.remove(container.size() - 1);
        }
    }
}
