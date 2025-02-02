/**
A left rotation operation on an array shifts each of the array's elements  unit to the left. For example, if  left rotations are performed on array , then the array would become . Note that the lowest index item moves to the highest index in a rotation. This is called a circular array.

Given an array  of  integers and a number, , perform  left rotations on the array. Return the updated array to be printed as a single line of space-separated integers.

Function Description

Complete the function rotLeft in the editor below.

rotLeft has the following parameter(s):

int a[n]: the array to rotate
int d: the number of rotations
Returns

int a'[n]: the rotated array
Input Format

The first line contains two space-separated integers  and , the size of  and the number of left rotations.
The second line contains  space-separated integers, each an .

Constraints

Sample Input

5 4
1 2 3 4 5
Sample Output

5 1 2 3 4
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
    // Write your code here
    if(a==null || a.isEmpty()||d==0){
        return a;
    }
    
    int n=a.size();
    
    d=d%n;
    if(d==0){
       return a; 
    }
       // Using circular buffer approach
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));
        for (int i = 0; i < n; i++) {
            int newPosition = (i - d + n) % n;  // Calculate new position after left rotation
            result.set(newPosition, a.get(i));
        }
        
        return result;
  
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.rotLeft(a, d);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
/***

*****************************************************


Let me break down the circular buffer approach step by step:

First, let's look at creating the result list:

javaCopyList<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));

Creates a new ArrayList of size n
Initializes all elements to 0
Collections.nCopies(n, 0) creates n copies of 0
This pre-sizes our list so we can use set() instead of add()


The rotation formula:

javaCopyint newPosition = (i - d + n) % n;
Let's see how this works with an example:
CopyInput list: [1, 2, 3, 4, 5]
n = 5 (length)
d = 2 (left rotation)

For each index i:
i = 0: newPosition = (0 - 2 + 5) % 5 = 3
      1 moves from index 0 to index 3
i = 1: newPosition = (1 - 2 + 5) % 5 = 4
      2 moves from index 1 to index 4
i = 2: newPosition = (2 - 2 + 5) % 5 = 0
      3 moves from index 2 to index 0
i = 3: newPosition = (3 - 2 + 5) % 5 = 1
      4 moves from index 3 to index 1
i = 4: newPosition = (4 - 2 + 5) % 5 = 2
      5 moves from index 4 to index 2
Original:  [1, 2, 3, 4, 5]
Result:    [3, 4, 5, 1, 2]

The placement:

javaCopyresult.set(newPosition, a.get(i));

Gets element from original position i
Places it in its new calculated position

Let's see the complete transformation step by step:
CopyStarting:     [0, 0, 0, 0, 0]
i=0: 1 → 3:  [0, 0, 0, 1, 0]
i=1: 2 → 4:  [0, 0, 0, 1, 2]
i=2: 3 → 0:  [3, 0, 0, 1, 2]
i=3: 4 → 1:  [3, 4, 0, 1, 2]
i=4: 5 → 2:  [3, 4, 5, 1, 2]
Why add n in the formula (i - d + n)?

Without +n, negative numbers could occur
Example: when i=0, d=2: (0-2) = -2
Adding n ensures positive numbers: (0-2+5) = 3
The modulo operator then keeps it in range

This approach is efficient because:

Single pass through the array
Each element is moved exactly once
No extra temporary storage needed beyond the result list
Works for any rotation amount
O(n) time complexity
No need for multiple swaps or reversals

*******************************************************

  Compiler Message
  Success
  Input (stdin)
  5 4
  1 2 3 4 5
  Expected Output
  5 1 2 3 4

*/
