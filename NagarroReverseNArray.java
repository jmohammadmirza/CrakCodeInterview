package com.something.anyting;

import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Reverse First N elements in the array Solution
 */
public class Nagarro {

	public static void main(String[] args) {
		int temp=0;
		int n=4;
		int[] a={2,3,4,5,6,7,8,9};

		/*	for(int i=0;i<n--;i++){
			temp=a[i];
			a[i]=a[n];
			a[n]=temp;
                //pure array based no Lists used 

		}
		 */
		// Using List little complicated

		List<Integer> al=new ArrayList<Integer>();

		for(int i:a){
			al.add(i);
		}

		Collections.reverse(al);
		//Print List
		System.out.println("List Print "+al);

		int[] array = al.stream().mapToInt(i->i).toArray();

		//Print Array
		System.out.println("Array Print"+Arrays.toString(array));
		//Print Array without Square brackets
		System.out.println("Array Print sans Brackets "+Arrays.toString(array).replace("[","").replace("]",""));

	}

}
