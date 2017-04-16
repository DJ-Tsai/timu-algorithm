package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Write a method anagram(s,t) to decide if two strings are anagrams or not.
 * <p>
 * Clarification
 * What is Anagram?
 * - Two strings are anagram if they can be the same after change the order of characters.
 * <p>
 * Example
 * Given s = "abcd", t = "dcab", return true.
 * Given s = "ab", t = "ab", return true.
 * Given s = "ab", t = "ac", return false.
 * <p>
 * Challenge
 * O(n) time, O(1) extra space
 */
public class TwoStringsAreAnagrams_158_E {
    public boolean anagram(String s, String t) {
        int[] map = new int[256];

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            map[c]++;

        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
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
