package org.dongjian.jiuzhang.algorithm.naive;

import java.util.ArrayList;

/**
 * Created by Dj on 1/19/17.
 */
public class GenerateArrayListWithGivenSize_485_N {
    /**
     * Generate an arrayList with given size, initialize the array list with numbers from 1 to size.
     *
     * @param size an integer
     * @return an array list
     */
    public ArrayList<Integer> generate(int size) {
        // Write your code here
        ArrayList<Integer> newList = new ArrayList<Integer>(size);

        for (int i = 1; i <= size; i++) {
            newList.add(i);
        }

        return newList;
    }
}
