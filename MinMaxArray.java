
/*
Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.

Input Format

A single line of five space-separated integers.

Constraints

Each integer is in the inclusive range .
Output Format

Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers. (The output can be greater than 32 bit integer.)

Sample Input

1 2 3 4 5
Sample Output

10 14
Explanation

Our initial numbers are 1, 2, 3, 4, and 5. We can calculate the following sums using four of the five integers:

If we sum everything except 1, our sum is 2+3+4+5=14.
If we sum everything except 2, our sum is 3+4+5+1=13.
If we sum everything except 3, our sum is 4+5+1+2=12.
If we sum everything except 4, our sum is 5+1+2+3=11.
If we sum everything except 5, our sum is 1+2+3+4=10.
and so on
As you can see, the minimal sum is 10 and the maximal sum is 14. Thus, we print these minimal and maximal sums as two space-separated integers on a new line.

Hints: Beware of integer overflow! Use 64-bit Integer.
*/
**************************************************************************************************************************************************
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        // Using Long to avoid integer overflow
        List<Long> l=new ArrayList<Long>();
        int count=1;
        long sum=0;
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        for(int i=0;i<5;i++){
            
            while(count!=5){
                int step=(i+count)%5;
               sum+=arr[step]; 
               count++;
            }
           count=1;
           l.add(sum); 
           sum=0;
        }
       
       System.out.println(Collections.min(l) + " " +Collections.max(l));
    }
}

