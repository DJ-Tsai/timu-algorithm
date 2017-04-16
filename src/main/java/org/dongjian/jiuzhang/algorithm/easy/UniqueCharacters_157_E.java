package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Example
 * Given "abc", return true.
 * <p>
 * Given "aab", return false.
 * <p>
 * Challenge
 * What if you can not use additional data structures?
 * <p>
 * Can use primitive type
 */
public class UniqueCharacters_157_E {
    public boolean isUnique(String str) {
        boolean[] lib = new boolean[256];

        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (lib[c]) {
                return false;
            }
            lib[c] = true;
        }

        return true;
    }
}
