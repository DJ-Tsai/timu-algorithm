package org.dongjian.jiuzhang.algorithm.naive;

/**
 * Created by Dj on 1/11/17.
 */
public class StudentLevel_218_N {
    /**
     * Declare two public attributes name(string) and score(int).
     */
    // write your code here
    public String name;
    public int score;
    /**
     * Declare a constructor expect a name as a parameter.
     */
    // write your code here
    public StudentLevel_218_N(final String name){
        this.name = name;
    }
    /**
     * Declare a public method `getLevel` to get the level(char) of this student.
     */
    // write your code here
    public char getLevel(){
        if(score >= 90) {
            return 'A';
        }else if(score >= 80){
            return 'B';
        }else if(score >= 60){
            return 'C';
        }else{
            return 'D';
        }
    }
}
