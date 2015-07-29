// you can also use imports, for example:
// import java.util.*;
import java.util.Deque;
import java.util.ArrayDeque;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
Author: Lori-Ann
Date: 29/07/2015
Purpose: N voracious fish are moving along a river. Calculate how many fish are alive.
Restrictions: O(N) worst-case runtime, O(N) worst-case space complexity
Score Received: 100%
Time used: 119 minutes

Approach: 
The problem specifies that two fish travelling in the same direction will never meet (all fish travel at the same speed)
It also specifies that for two fish to meet an upstream fish must start further downstream than a downstream fish 
and there must not be any fish between.
One fish eats another if it is larger.
Fish continue on their way unless they are eaten.

The size of the fish are indicated in the given array A
The direction of the fish are indicated in the given array B (0-upstream, 1-downstream)

The last encountered fish will be the first to potentially meet with an oncoming fish (LIFO).
We can use a stack and 'tuple' to track the size and direction of the surviving fish.
As we iterate through the array A/B we move downstream

Website: https://codility.com/demo/take-sample-test/fish/
*/

class VoraciousFish {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        Deque<int[]> stack  = new ArrayDeque<>();
        
        for (int i = 0; i < A.length; i++) {
            //Case 1: Next fish will not meet previous fish
            //if there are no previous fish or the next fish is travelling downstream, track the next fish 
            if (stack.isEmpty() || B[i] == 1) 
                stack.addFirst(new int[] {A[i], B[i]});
                
            //Case 2: Next fish may meet with previous fish
            //if the next fish is travelling upstream, handle collisions with previous downstream fish
            else if (B[i] == 0) 
            {
                //while the upstream fish is larger, remove the downstream fish from tracking
                while (!stack.isEmpty() && stack.peekFirst()[0] < A[i] && stack.peekFirst()[1] == 1)
                    stack.removeFirst();
                
                //if the upstream fish no longer encounters downstream fish, keep track of it
                if (stack.isEmpty() || stack.peekFirst()[1] == 0) 
                    stack.addFirst(new int[] {A[i], B[i]});
                    
                //else: the fish has been eaten by a larger downstream fish, do nothing
            }
        }
        
        return stack.size();
        
    }
}        
