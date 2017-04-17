package org.dongjian.jiuzhang.algorithm.easy;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * Next one is the count-and-say of the previous one.
 * <p>
 * 1, 11, 21, 1211, 111221, ...
 * <p>
 * 1 is read off as "one 1" or 11.
 * <p>
 * 11 is read off as "two 1s" or 21.
 * <p>
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n, generate the nth sequence.
 * <p>
 * Notice
 * <p>
 * The sequence of integers will be represented as a string.
 * <p>
 * Example
 * Given n = 5, return "111221".
 */
public class CountAndSay_420_E {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        String s = "1";

        for (int i = 1; i < n; i++) {
            s = getNext(s);
        }

        return s;
    }

    private String getNext(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        int count = 0;
        char c = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
                continue;
            } else {
                builder.append(count).append(c);
                c = s.charAt(i);
                count = 1;
            }
        }

        builder.append(count).append(c);
        return builder.toString();
    }
}
