/*
Author: Lori-Ann
Date: 22/07/2015
Purpose: My solution to the TapeEquilibrium demo test on @Codility!
Description: Given A[] {a1, ..., aN-1} find the minimum difference given by the expression |A[]

{a1,...aP-1} - A[]{aP,...,aN-1}|, for 0 < P < N.
Restrictions: O(N) worst-case runtime, O(N) worst-case space complexity

Score Received: 100%
Time used: 46 minutes

Website: https://codility.com/demo/take-sample-test/tape_equilibrium/
*/

// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.lang.*;

class MinDifference{
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length < 2 || A.length > 100000) return -1; //should never hit this case
        
        int aSum = 0;
        int bSum = 0;
        
        //set default 
        aSum = A[0];
        for (int i = 1; i < A.length; i++) {
            bSum += A[i];
        }
        int minDiff = difference(aSum,bSum);
        
        int P = 2;
        while (P < A.length) {
            aSum += A[P-1];
            bSum -= A[P-1];
            minDiff = min(minDiff,difference(aSum,bSum));
            P++;
        }
        
        return minDiff;
    }
    
    public int min(int a, int b) {
        return a < b ? a : b;
    }
    
    public int difference(int aSum, int bSum) {
        return Math.abs(aSum - bSum);
    }
}

public class MainClass {
    public static void main(String [] args){
    	MinDifference mi = new MinDifference();
        System.out.println(mi.solution(new int[] {1,2,3}, new int [] {7}));
    }
}
