package org.dongjian.jiuzhang.algorithm.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * <p>
 * Notice
 * <p>
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * <p>
 * Example
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 */
public class WordLadderII_121_H {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        Map<String, Integer> distMap = new HashMap<String, Integer>();

        initGraph(map, dict, start, end);

        // bfs to pupulate distMap
        Queue<String> queue = new LinkedList<String>();
        int dist = 0;

        queue.add(end);
        distMap.put(end, dist);

        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            // loop through words on current level
            for (int i = 0; i < size; i++) {
                String head = queue.remove();

                // add words on next level to queue
                for (String next : map.get(head)) {
                    if (distMap.containsKey(next)) {
                        continue;
                    }
                    queue.add(next);
                    distMap.put(next, dist);
                }
            }
        }

        // dfs
        List<List<String>> res = new ArrayList();
        List<String> path = new ArrayList<String>();
        path.add(start);

        dfs(map, distMap, start, path, res);

        return res;
    }


    private void dfs(Map<String, Set<String>> map, Map<String, Integer> distMap, String start, List<String> path, List<List<String>> res) {
        if (distMap.get(start) == 0) {
            res.add(new ArrayList(path));
            return;
        }

        int dist = distMap.get(start);
        Set<String> nextWords = map.get(start);
        for (String next : nextWords) {
            if (distMap.get(next) < dist) {
                path.add(next);
                dfs(map, distMap, next, path, res);
                path.remove(path.size() - 1);
            }
        }

    }


    private void initGraph(Map<String, Set<String>> map, Set<String> dict, String start, String end) {

        if (!dict.contains(start)) {
            dict.add(start);
        }

        if (!dict.contains(end)) {
            dict.add(end);
        }

        for (String s : dict) {
            map.put(s, findNextWords(dict, s));
        }
    }

    private Set<String> findNextWords(Set<String> dict, String s) {
        Set<String> nextWords = new HashSet<String>();

        for (int i = 0; i < s.length(); i++) { // L
            char c = s.charAt(i);
            for (char j = 'a'; j < 'z' + 1; j++) { // 25
                if (j != c) {
                    StringBuilder builder = new StringBuilder(s);
                    builder.setCharAt(i, j);
                    String newS = builder.toString();// L?
                    if (dict.contains(newS)) { // L
                        nextWords.add(newS); // L
                    }
                }
            }
        }

        return nextWords;
    }
}
