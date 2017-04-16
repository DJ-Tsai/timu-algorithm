package org.dongjian.jiuzhang.algorithm.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Compare two strings A and B, determine whether A contains all of the characters in B.
 * <p>
 * The characters in string A and B are all Upper Case letters.
 * <p>
 * Notice
 * <p>
 * The characters of B in A are not necessary continuous or ordered.
 * <p>
 * Example
 * For A = "ABCD", B = "ACD", return true.
 * <p>
 * For A = "ABCD", B = "AABC", return false.
 */
public class CompareString_55_E {
    public boolean compareStrings(String A, String B) {
        Map<Character, Integer> map = new HashMap();

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < B.length(); i++) {
            char c = B.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
