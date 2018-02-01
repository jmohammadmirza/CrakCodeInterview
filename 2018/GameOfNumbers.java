/*
See GameOfNumbers.PNG for questions
Input and Output
10
1
6
2
10
2
3
2
10
6
4

2 2 2 -1 2 6 6 -1 -1 -1 
*/
package com.something.anything;

import java.util.Scanner;

public class GameOfNumbers {

	    public static void main(String[] args) {
	 
	        Scanner sc = new Scanner(System.in);
	        int q = sc.nextInt();
	        int[] values = new int[q];
	 
	        for (int i = 0; i <q ; i++) {
	          values[i] = sc.nextInt() ;
	        }
	        int[] result = new int[q] ;
	 
	        for (int i = 0; i <q-1 ; i++) {
	            result[i] = check( values , i ) ;
	        }
	        // Last element does not have any next element . Since the array was initialized it will be 0.So making it -1
	        result[q-1] = -1 ;
	 
	        for(int e :result ){
	            System.out.print(e +" ");
	        }
	 
	 
	    }
	    public static int check ( int[] arr , int value ){
	        int max = firstGreater(arr , value) ;
	        if (max == -1 )
	            return max ;
	        else
	        {
	            return  firstLower( arr, max) ;
	        }
	    }
	 
	    public static int firstGreater ( int[] arr ,int  current ){
	 
	        int cur = arr[current] ;
	        for (int i = current +1 ; i <arr.length  ; i++) {
	            if (arr[i] >  cur )
	                return i ;
	        }
	        return  -1 ;
	    }
	 
	    public static int firstLower (int[] arr ,int  current)
	    {
	        int cur = arr[current] ;
	        for (int i = current +1 ; i <arr.length ; i++) {
	            if (arr[i] < cur )
	                return  arr[i] ;
	        }
	        return  -1 ;
	    }
	 
	 
	}
	
