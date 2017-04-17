package org.dongjian.jiuzhang.algorithm.easy;

import java.util.ArrayList;

/**
 * Example
 * Given
 * <p>
 * {
 * "dog",
 * "google",
 * "facebook",
 * "internationalization",
 * "blabla"
 * }
 * the longest words are(is) ["internationalization"].
 * <p>
 * Given
 * <p>
 * {
 * "like",
 * "love",
 * "hate",
 * "yes"
 * }
 * the longest words are ["like", "love", "hate"].
 */
public class LongestWord_133_E {
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        int maxLen = 0;
        ArrayList<String> ans = new ArrayList<String>();
        for (int i = 0; i < dictionary.length; ++i)
            if (dictionary[i].length() > maxLen) maxLen = dictionary[i].length();
        for (int i = 0; i < dictionary.length; ++i)
            if (dictionary[i].length() == maxLen) ans.add(dictionary[i]);
        return ans;
    }
}
