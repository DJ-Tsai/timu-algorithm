package org.dongjian.jiuzhang.algorithm.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * <p>
 * Return all such possible sentences.
 * <p>
 * Example
 * Gieve s = lintcode,
 * dict = ["de", "ding", "co", "code", "lint"].
 * <p>
 * A solution is ["lint code", "lint co de"].
 */
public class WordBreakII_582_H {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();

        if (wordDict == null || s == null || s.length() == 0) {
            return res;
        }

        boolean[][] inDict = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (wordDict.contains(sub)) {
                    inDict[i][j] = true;
                }
                // System.out.print(inDict[i][j]);
            }
            // System.out.println("\n");
        }


        boolean[] isPossible = new boolean[s.length() + 1];
        isPossible[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (inDict[i][j] && isPossible[j + 1]) {
                    isPossible[i] = true;
                }

            }

            // System.out.print(isPossible[i] + " ");
        }


        dfs(s, inDict, isPossible, res, new ArrayList<String>(), 0);

        return res;
    }

    private void dfs(String s, boolean[][] inDict, boolean[] isPossible, List<String> res, List<String> sub, int startIndex) {
        if (startIndex == s.length()) {
            res.add(toStr(new ArrayList<String>(sub)));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (inDict[startIndex][i] && isPossible[i + 1]) {
                sub.add(s.substring(startIndex, i + 1));
                dfs(s, inDict, isPossible, res, sub, i + 1);
                sub.remove(sub.size() - 1);
            }
        }
    }

    private String toStr(List<String> list) {
        StringBuilder builder = new StringBuilder();
        builder.append(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            builder.append(" ").append(list.get(i));
        }

        return builder.toString();
    }
}
