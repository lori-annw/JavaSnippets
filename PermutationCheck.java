/*
Author: Lori-Ann
Problem: Counting
Score: 100%
Difficulty: Trivial if youi understand how to deal with counting problems.

Trip-ups: Forgot else condition inside loop initially

https://codility.com/demo/take-sample-test/perm_check/
*/

// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class PermutationCheck {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int [] tracker = new int [A.length + 1];
        
        for (int a : A ) {
            if (1 <= a && a <= A.length && tracker[a] == 0){
                tracker[a]++;
            }
            else return 0;
        }
        return 1;
    }
}
