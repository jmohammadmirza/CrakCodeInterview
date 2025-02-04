package com.something.anything;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Product1 {

	public static void main(String[] args) {
		int nums[]= {1,2,3,4,5};
		
		System.out.println(productExceptSelf(nums));
		
		/**
		 * Given n positive integers, find the minimum and maximum values that can be calculated by summing exactly n-1 of the n integers
		 */

		
		 sumInternallyArray(nums);
		 
		 sumInternallyArrayEight(nums);
		 
		 
	}
    private static void sumInternallyArrayEight(int[] nums) {
    	
    	List<Long> listSum=Arrays.stream(nums)
    			.mapToLong(i->Arrays.stream(nums)
    			.filter(j->i!=j)
    			.mapToLong(j->j)
    			.sum())
    			.boxed()
    			.collect(Collectors.toList());
    	
    	System.out.println(listSum); // Output: [14, 13, 12, 11, 10]
    	
	   /**
	    * Alternative approach 	
	    */
    	
    	
    	long totalSum=Arrays.stream(nums).mapToLong(i->i).sum();
    	
    	List<Long> l=Arrays.stream(nums)
    			     .mapToLong(i->totalSum-i)
    			     .boxed()
    			     .collect(Collectors.toList());
    	
    	
    	
    	System.out.println("Alternative "+l);
    	
   
    	
 }
	private static void sumInternallyArray(int[] nums) {
    	
    	List<Long> listSum=new ArrayList<>();
    	
    	long sum=0L;
    	
    	 for(int i:nums){
    		 for(int j:nums) {
    			 
    			 if(i!=j) {
    				 sum+=j;
    			 }
    			 
    		 }
         	
    		listSum.add(sum);  
    	   sum=0;
         }
    	 System.out.println("sum :: "+listSum);
    	 
    	 System.out.println("Min "+Collections.min(listSum));
    	 
    	 System.out.println("Max  "+Collections.max(listSum));
		
	}
	public static List<Long> productExceptSelf(int[] nums) {
        
        List<Long> list=new ArrayList<>();
        
        long product=1L;

        for(int i:nums){
        	
        	product*=i;
        	
        	list.add(product);
        	
        }
                 
		return list; 
        
    }
}
