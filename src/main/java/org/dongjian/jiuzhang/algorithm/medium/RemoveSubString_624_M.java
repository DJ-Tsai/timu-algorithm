package org.dongjian.jiuzhang.algorithm.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given a string s and a set of n substrings. You are supposed to remove every instance of those n substrings from s so that s is of the minimum length and output this minimum length.
 * <p>
 * Given s = ccdaabcdbb, substrs = ["ab", "cd"]
 * Return 2
 * <p>
 * Explanation:
 * ccdaabcdbb -> ccdacdbb -> cabb -> cb (length = 2)
 */
public class RemoveSubString_624_M {
    public int minLength(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int minLen = s.length();
        Queue<String> queue = new LinkedList();
        Set<String> lib = new HashSet<String>();
        queue.add(s);
        lib.add(s);

        while (!queue.isEmpty()) {
            String head = queue.remove();

            for (String sample : dict) {
                int index = head.indexOf(sample);
                while (index != -1) {
                    String newS = head.substring(0, index) + head.substring(index + sample.length(), head.length());
                    if (!lib.contains(newS)) {
                        queue.add(newS);
                        lib.add(newS);
                        if (newS.length() < minLen) {
                            minLen = newS.length();
                        }
                    }
                    index = head.indexOf(sample, index + sample.length());
                }
            }
        }

        return minLen;
    }
}
