package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 * <p>
 * Example
 * abcd is a permutation of bcad, but abbe is not a permutation of abe
 */
public class StringPermutation_211_E {
    public boolean stringPermutation(String A, String B) {
        if (A == null && B == null) {
            return true;
        }

        if (A == null || B == null) {
            return false;
        }

        if (A.length() != B.length()) {
            return false;
        }

        int[] map = new int[256];

        for (int i = 0; i < A.length(); i++) {
            int c = A.charAt(i);
            map[c]++;

        }

        for (int i = 0; i < B.length(); i++) {
            char c = B.charAt(i);
            if (map[c] == 0) {
                return false;
            } else {
                map[c]--;
            }
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                return false;
            }
        }

        return true;

    }
}
