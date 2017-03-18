package org.dongjian.jiuzhang.algorithm.easy;

import java.util.ArrayList;

/**
 * Created by Dj on 1/9/17.
 */
public class PalindromeNumber_491_E {
    public static boolean palindromeNumber2(int num) {
        // Write your code here
        int result = num;
        ArrayList<Integer> list = new ArrayList<>();
        while (num / 10 != 0) {
            list.add(num % 10);
            num = num / 10;
        }
        list.add(num);
        for (int i = 0; i<list.size()/2;i++) {
            if (list.get(i) != list.get(list.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean palindromeNumber(int num) {
        int temp = num;
        int reverse = 0;
        while (temp != 0) {
            reverse = reverse * 10 + temp % 10;
            temp = temp / 10;

        }
        return num == reverse;
    }
}
