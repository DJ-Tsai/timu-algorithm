package org.dongjian.jiuzhang.algorithm.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 10^4. Reconstruction means building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.
 * <p>
 * Example
 * Given org = [1,2,3], seqs = [[1,2],[1,3]]
 * Return false
 * Explanation:
 * [1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.
 * <p>
 * Given org = [1,2,3], seqs = [[1,2]]
 * Return false
 * Explanation:
 * The reconstructed sequence can only be [1,2].
 * <p>
 * Given org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
 * Return true
 * Explanation:
 * The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
 * <p>
 * Given org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
 * Return true
 */
public class SequenceReconstruction_605_M {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if (org.length != 0 && (seqs == null || seqs.length == 0 || seqs[0].length == 0)) {
            return false;
        }

        Map<Integer, Integer> indegree = new HashMap();

        Map<Integer, Set<Integer>> list = new HashMap();

        for (int i = 0; i < org.length; i++) {
            indegree.put(org[i], 0);
            list.put(org[i], new HashSet());
        }

        // build graph
        for (int i = 0; i < seqs.length; i++) {
            if (seqs[i].length == 1 && list.get(seqs[i][0]) == null) {
                return false;
            }
            for (int j = 0; j < seqs[i].length - 1; j++) {
                if (list.get(seqs[i][j]) == null) {
                    return false;
                }
                if (list.get(seqs[i][j]).add(seqs[i][j + 1])) {
                    if (indegree.get(seqs[i][j + 1]) == null) {
                        return false;
                    }
                    indegree.put(seqs[i][j + 1], indegree.get(seqs[i][j + 1]) + 1);
                }
            }
        }

        // System.out.println(list);
        // System.out.println(indegree);

        Queue<Integer> queue = new LinkedList();

        for (int i = 0; i < indegree.size(); i++) {
            if (indegree.get(org[i]) == 0) {
                queue.add(org[i]);
            }
        }

        // System.out.println(queue);
        for (int i = 0; i < org.length; i++) {
            if (!queue.isEmpty() && queue.size() == 1) {
                int head = queue.remove();
                // System.out.println(head);
                if (head != org[i]) {
                    // System.out.println("reach");
                    return false;
                }
                for (Integer k : list.get(head)) {
                    indegree.put(k, indegree.get(k) - 1);
                    if (indegree.get(k) == 0) {
                        queue.add(k);
                    }
                }
            } else {
                return false;
            }
        }

        return queue.isEmpty();
    }
}
