/*
Author: Lori-Ann
Date: 28/07/2015
Purpose: My solution for a demo test on @Codility!
Description: Validate properly nested string S. 
S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.

Restrictions: O(N) worst-case runtime, O(N) worst-case space complexity
Score Received: 100%
Time used: 
Website: https://codility.com/demo/take-sample-test/brackets/

Note: I tried using peekFirst() and pollFirst() so I could skip the isEmpty() check 
but the methods seemed to throw an exception even though the javadoc says they should not. Why?
*/
// you can also use imports, for example:
import java.util.ArrayDeque;
import java.util.Deque;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Brackets {
    public int solution(String S) {
        // write your code in Java SE 8
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            
            //Add open brackets/parenthesis to queue to open a block
            if ( c == '(' || c == '{' || c == '[') {
                stack.addFirst(c);
            }
            
            //verify that closing brackets/parenthesis close a matching open bracket/parenthesis
            //remove the open bracket/parenthesis from the stack to close a block
            else if (c == ')') {
                if (stack.isEmpty() || stack.removeFirst() != '(') return 0;
            }
            else if (c == '}') {
                if (stack.isEmpty() || stack.removeFirst() != '{' ) return 0;
            }
            else if (c == ']') {
                if (stack.isEmpty() || stack.removeFirst() != '[' ) return 0;
           }
        }
        
        //check that there are no unclosed brackets or parenthesis
        return stack.isEmpty() ? 1 : 0;
    }
}
