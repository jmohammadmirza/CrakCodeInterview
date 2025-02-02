package com.something.anything;

import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {
		
		int nums[]= {2,7,11,15};
	

      Arrays.stream(twoSum(nums,9)).forEach(System.out::println);
	}

/**
 * 
 * @param numbers
 * @param target
 * @return
 */

	public static int[] twoSum(int[] numbers, int target) {
		int r =numbers.length-1;
		int l=0;
		while(r>l){
			if(numbers[r]+numbers[l] ==target){
				return new int[]{l+1,r+1};
			}else if (numbers[r]+numbers[l]<target){
				l++;
			}else{
				r--;
			}           
		}
		return new int[]{0,0};
	}
	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	 public static int search(int[] nums, int target) {
	        int i = 0;
	        int j = nums.length - 1;

	        while (i <= j) {
	            int mid = (i + j) / 2;

	            if (nums[mid] == target) 
	            	return mid;
	            else if (nums[mid] < target) 
	            	i = mid + 1;
	            else j = mid - 1;
	        }

	        return -1;
	    }

}

/****
This is for Sorted array if its not sorted then sort check ArraySortingTechnique.java
  
  
 */
