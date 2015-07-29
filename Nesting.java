
/*
Author: Lori-Ann
Date: 28/07/2015
Purpose: My solution to the nesting demo test on @Codility!
Description: Maximum product of three elements from an array of integers
Restrictions: O(N) worst-case runtime, O(1) worst-case space complexity
Score Received: 100%
Time used: approx. 10 minutes
Website: https://codility.com/demo/take-sample-test/nesting/
*/

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

//Param: string consisting of '('  and/or ')' characters. (The code ignores all other chars)
class Nesting {
    public int solution(String S) {
        // write your code in Java SE 8
        int remainder = 0;

        for (int i = 0; i < S.length(); i++) {
            //If we encounter an open parenthesis, increment tracker
            if (S.charAt(i)  == '(')
                remainder++;
                
            //If we encounter a close parenthesis, decrement tracker
            else if (S.charAt(i) == ')')
                remainder--;
            
            //Tricky Case: 
            //if a closing parenthesis occurs without a matching open parenthesis, fail test
            if (remainder < 0) return 0; 
        }
        
        //if all opened parenthesis have been closed, pass test
        return remainder == 0 ? 1 : 0;
    }
}
