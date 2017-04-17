package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * Example
 * a = 11
 * <p>
 * b = 1
 * <p>
 * Return 100
 */
public class AddBinary_408_E {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }

        int indexA = a.length() - 1;
        String res = "";
        int carry = 0;
        for (int i = b.length() - 1; i >= 0; i--) {
            char curB = b.charAt(i);
            char curA = a.charAt(indexA--);

            if (curB != curA) {
                if (carry == 1) {
                    res = "0" + res;
                    carry = 1;
                } else {
                    res = "1" + res;
                    carry = 0;
                }
            } else {
                if (curA == '0') {
                    res = carry + res;
                    carry = 0;
                } else {
                    res = carry + res;
                    carry = 1;
                }
            }
        }

        if (carry == 1) {
            while (indexA >= 0 && a.charAt(indexA--) == '1') {
                res = "0" + res;
            }
            res = "1" + res;
            // indexA--;
        }


        if (indexA >= 0) {
            res = a.substring(0, indexA + 1) + res;
        }

        return res;
    }
}
