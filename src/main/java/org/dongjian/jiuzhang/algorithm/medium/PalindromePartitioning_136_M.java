package org.dongjian.jiuzhang.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example
 * Given s = "aab", return:
 * <p>
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class PalindromePartitioning_136_M {
    public List<List<String>> partition(String s) {
        if (null == s) {
            return null;
        }

        List<List<String>> res = new ArrayList();
        List<String> sub = new ArrayList();

        if (s.length() == 1) {
            sub.add(s);
            res.add(new ArrayList(sub));
            return res;
        }

        dfs(s, 0, sub, res);

        return res;


    }

    private void dfs(String s, int startIndex, List<String> sub, List<List<String>> res) {
        if (startIndex == s.length()) {
            res.add(new ArrayList(sub));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String subString = s.substring(startIndex, i + 1);
            if (isP(subString)) {
                sub.add(subString);
                dfs(s, i + 1, sub, res);
                sub.remove(sub.size() - 1);
            }
        }


    }

    private boolean isP(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
