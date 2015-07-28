/*
Author: Lori-Ann
Date: 28/07/2015
Purpose: My solution to the count_div demo test on @Codility!
Description: Given three integers A, B and K, return the number of integers within the range [A..B] that are divisible by K, 
i.e.: { i : A ≤ i ≤ B, i mod K = 0 }
Restrictions: O(1) worst-case runtime, O(1) worst-case space complexity
Score Received: 100%
Time used:

Straightforward Approach 1/2: O(N) time soln with a loop and counter, unrealistic when N = 2 billion.
Awesome Approach 3: We want the number of digits in some range that are divisible by K.

  *Simple case: assume range [0 .. n*K]
  N/K returns the number of digits between [0,N) that are divisible by K, assuming N%K = 0 (aka. N is divisible by K)
  ex. N = 9, K = 3, Num digits = |{0 3 6}| = 3 = 9/3
  
  Similarly for N/K + 1 and [0,N]
  ex. N = 9, K = 3, Num digits = |{0 3 6 9}| = 4 = 9/3 + 1
  
  I think really understanding the above fact is the trickiest part of this question.
  
  
  The rest boils down to prefix sums and handling special cases.
  
  -----
  
  Now we don't always have a range that begins with 0, and we cannot assume the two bounds will be divisible by K.
  But wait! We can fix this by calculating our own nice upper and lower bounds and using some subtraction magic :)
  
  1. First find the closest upper and lower in the range [A,B] that are divisible by K.
  Lower bound: ex. A = 10, K = 3, new_A = 12
  
  
  2. Then calculate the following using the above technique*:
  Determine the total number of digits X between [0,B] that are divisible by K
  Determine the total number of digits Y between [0,A) that are divisible by K
  
  3. Calculate the number of digits between [A,B] that are divisible by K in constant time by the expression X - Y
  


Website: https://codility.com/demo/take-sample-test/count_div/
*/
class Solution {
    public int solution(int A, int B, int K) {
        int firstDivisble = A%K == 0 ? A : A + (K - A%K);
        int lastDivisible = B%K == 0 ? B : B - B%K; //unnecessary since B/K behaves this way automatically.
        return (lastDivisible - firstDivisible)/K + 1;
    }
}
