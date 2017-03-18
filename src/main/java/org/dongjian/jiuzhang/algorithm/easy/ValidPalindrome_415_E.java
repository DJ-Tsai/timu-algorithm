package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Created by Dj on 1/11/17.
 */
public class ValidPalindrome_415_E {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        //
        s = s.trim();
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (!Character.isDigit(s.charAt(start)) && !Character.isAlphabetic(s.charAt(start)) && start < end) {
                start++;
            }
            while (!Character.isDigit(s.charAt(end)) && !Character.isAlphabetic(s.charAt(end)) && end > start) {
                end--;
            }
            if (start >= end) {
                return true;
            }
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
}
