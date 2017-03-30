package org.dongjian.jiuzhang.algorithm.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * <p>
 * <p>
 * Notice
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * <p>
 * Example
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 */
public class WordLadder_120_M {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end)) {
            return 1;
        }

        int res = 0;

        Set<String> lib = new HashSet<String>();

        Queue<String> queue = new LinkedList();
        queue.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                String head = queue.remove();

                for (int i = 0; i < head.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == head.charAt(i)) {
                            continue;
                        }
                        String newS = head.substring(0, i) + c + head.substring(i + 1, head.length());
                        if (newS.equals(end)) {
                            return res + 2;
                        }
                        if (dict.contains(newS) && !lib.contains(newS)) {
                            queue.add(newS);
                            lib.add(newS);
                        }
                    }
                }
            }

            res++;
        }

        return -1;
    }
}
