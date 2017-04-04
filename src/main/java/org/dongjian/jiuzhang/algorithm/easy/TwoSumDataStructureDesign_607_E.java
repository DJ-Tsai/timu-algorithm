package org.dongjian.jiuzhang.algorithm.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * <p>
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * <p>
 * Example
 * add(1); add(3); add(5);
 * find(4) // return true
 * find(7) // return false
 */
public class TwoSumDataStructureDesign_607_E {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    // Add the number to an internal data structure.
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (Integer i : map.keySet()) {
            int rest = value - i;

            if (rest == i && map.get(i) > 1) {
                return true;
            }

            if (rest != i && map.containsKey(rest)) {
                return true;
            }
        }

        return false;
    }
}
