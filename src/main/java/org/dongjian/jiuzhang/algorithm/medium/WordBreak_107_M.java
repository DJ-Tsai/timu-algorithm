package org.dongjian.jiuzhang.algorithm.medium;

import java.util.Set;

/**
 * Created by Dj on 3/25/17.
 */
public class WordBreak_107_M {
    public boolean wordBreak(String s, Set<String> dict) {
        // boolean[][] isWord = new boolean[s.length()][s.length()];

        // check substring from index i to index j is in dict
        // for (int i = 0; i< s.length(); i++) {
        //     for (int j = i; j < s.length(); j++) {
        //         String sub = s.substring(i, j + 1);
        //         if (dict.contains(sub)) {
        //             isWord[i][j] = true;
        //         }
        //     }
        // }


        // optimize when the input string s is very long
        int maxLen = 0;
        for (String word : dict) {
            if (word.length() > maxLen) {
                maxLen = word.length();
            }
        }

        // start at index i, is possible
        boolean[] isPossible = new boolean[s.length() + 1];
        isPossible[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (sub.length() > maxLen) {
                    break;
                }
                if (isPossible[j + 1] && dict.contains(sub)) {
                    isPossible[i] = true;
                    break;
                }
            }
            // System.out.print("" + i + isPossible[i]);
        }

        return isPossible[0];
    }
}
