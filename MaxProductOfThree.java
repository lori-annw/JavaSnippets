/*
Author: Lori-Ann
Date: 28/07/2015
Purpose: My solution to the max_product_of_three demo test on @Codility!
Description: Maximum product of three elements from an array of integers
Restrictions: O(N * log(N)) worst-case runtime, O(1) worst-case space complexity
Score Received: 100%
Time used: 15-20 minutes
Website: https://codility.com/demo/take-sample-test/max_product_of_three/
*/
import java.util.*;

class MaxProductOfThree {
    public int solution(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        
        //Case 1:
        int posProduct = A[n-1]*A[n-2]*A[n-3];
        
        //Case 2: Where the two smallest numbers are < 0 but A[0]*A[1] > A[n-2]*A[n-3]
        int negProduct = A[n-1]*A[0]*A[1]; 
   
        
        return posProduct > negProduct ? posProduct : negProduct;
    }
}
