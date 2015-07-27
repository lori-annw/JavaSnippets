/*
Author: Lori-Ann
Date: 22/07/2015
Purpose: My solution to the passingCars demo test on @Codility!
Description: Given A[] {a1, ..., aN-1} a list of consecutive cars driving east/west, find the number of passing cars (P,Q).
Two cars are defined as passing if 0 <= P < Q < N where P is an east travelling car and Q is a west travelling car.
An array element with value A[i] = 0 indicates an east travelling car
An array element with value A[i] = 1 indicates a west travelling car
(Basically, for each occurence of 0, sum all the following occurences of 1)

Restrictions: O(N) worst-case runtime, O(1) worst-case space complexity

Score Received: 100%
Time used: 

Website: https://codility.com/demo/take-sample-test/tape_equilibrium/
*/
// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class PassingCars {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int numPassing = 0;
        int numOnes = 0; //essentially the sum of a growing array suffix
        
        for (int i = A.length-1; i >= 0; i--) {
            if (A[i] == 0) numPassing += numOnes;
            else numOnes++;
            
            if (numPassing > 1000000000) return -1;
        }
        return numPassing;
    }

    public int[] prefix_sums(int[] A) {
        int n = A.length;
        int[] P = new int[n + 1]; //filled with 0 by default
    
        for (int i = 1; i < n; i++){
            P[i] = P[i-1] + A[i-1];
        }
        
        return P; //Array of the form {0, a0, a0 + a1, ...} = {p0, p1, p2, ...}
    }
    
    
    public int count_total(int[] prefix, int x, int y) {
        return prefix[y+1] - prefix[x];
    }
}
