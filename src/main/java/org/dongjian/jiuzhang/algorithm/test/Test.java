package org.dongjian.jiuzhang.algorithm.test;

import org.junit.Assert;

/**
 * Created by Dj on 1/28/17.
 */
public class Test {
     String str = "string";
     Integer integer = new Integer(10);

     @org.junit.Test
     public void test1() {
          appendString(str);
          System.out.println(str);


     }

     public void appendString(String string) {
          string = string + "append";
     }

     public void incrementInt(Integer integer) {

     }

}
