/*
Author: Lori-Ann
Language: C (Although Java/C++ code would be exactly the same. This is especially true considering that I thought 
I had changed the preferred language to Java.)
Description: minJumps required to jump past destination Y given that we start at X. Each jump is a
constant distance D and we are jumping along one dimension. X <= Y.
Restrictions: O(1) runtime, O(1) space
Score: 100%
Time: approx 10 minutes

Tried using Math.ceil then realized I wasn't allowed to import java packages. **
**[or] it may be (read: most definitely is) because I was writing in C (not Java) and didn't realize until after I submitted ;)

https://codility.com/demo/take-sample-test/frog_jmp/
*/

// you can write to stdout for debugging purposes, e.g.
// printf("this is a debug message\n");

int solution(int X, int Y, int D) {
    // write your code in C99
    if (X > Y) return -1; //should never hit this case
    
    int minJumps = (Y-X)%D == 0 ? (Y-X)/D : (Y-X)/D + 1;
    return minJumps;
}
