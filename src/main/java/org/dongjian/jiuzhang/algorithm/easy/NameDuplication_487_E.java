package org.dongjian.jiuzhang.algorithm.easy;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Dj on 1/29/17.
 */
public class NameDuplication_487_E {
    /**
     * @param names a string array
     * @return a string array
     */
    public List<String> nameDeduplication(String[] names) {
        // Write your code here
        Hashtable<Integer,String> table = new Hashtable<Integer,String>();
        int count = 0;
        for(int i = 0; i < names.length; i++) {
            String s = names[i].toLowerCase();
            if(!table.containsValue(s)){
                table.put(count++,s);
            }
        }

        List<String> result = new ArrayList();
        for(int i = 0; i < table.size(); i++) {
            result.add(table.get(i));
        }

        return result;
    }
}
