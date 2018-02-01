Left Array Rotation Hacker Rank Solution.

A left rotation operation on an array of size  shifts each of the array's elements  unit to the left.
For example, if  left rotations are performed on array , then the array would become .

 Print a single line of n space-separated integers denoting the final state of the array after performing left rotations.

Sample Input

5 4              //size of array  //no. of shift/rotations 
1 2 3 4 5       //original array
Sample Output

5 1 2 3 4       // final array
*******************************************************************************************************************
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int[] arrayLeftRotation(int[] a, int n, int k) {
    if (a == null || k < 0) {
    	        throw new IllegalArgumentException("The array must be non-null and the order must be non-negative");
    	    }
    	    int offset = a.length + k % a.length;// (a.length - k % a.length) for right rotation.
    	    if (offset > 0) {
    	        int[] copy = a.clone();
    	        for (int i = 0; i < a.length; ++i) {
    	            int j = (i + offset) % a.length;
    	            a[i] = copy[j];
    	        }
    	    }
      return a;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
      
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();
      
    }
}
