/*
Author: Lori-Ann
Date Created: 22/07/2015
Description: Given an array of length N A[]{a1,...,aN} 
s.t array elements are distinct and 1 < element < N+1. Find the missing number.

Programming language used: Java
Total time used: approx 6-10 minutes
Detected time complexity: O(N) or O(N * log(N))

https://codility.com/demo/take-sample-test/perm_missing_elem/
*/

// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class MissingInteger{
    public int solution(int[] A) {
        // write your code in Java SE 8

	//OR you can calculate sumRange as (N+1)(N+2)/2 according to summation rules
        int sumRange = 0;
        for (int i = 1; i <= A.length+1; i++){
            sumRange+=i;
        }
        
        int sumArray = 0;
        for(int a : A) {
            sumArray+=a;
        }

	//Take the total without the missing number, and subtract the total with the missing number
        return sumRange-sumArray;
    }
}

public class MainClass {
    public static void main(String [] args){
    	MissingInteger mi = new MissingInteger();
        System.out.println(mi.solution(new int [] {1,2,4,5}));
    }
}
