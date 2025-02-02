package com.something.anything;
/**
 * Input: s = "anagram", t = "nagaram"
   Output: true
 * @author javed
 *
 */

public class Anagrams {

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaaram"));

	}
	  public static  boolean isAnagram(String s, String t) {
	        
	        int count[]=new int[26];
	        
	         char a = 'a';
	        
	        char[] arrayS=s.toLowerCase().toCharArray();
	        char[] arrayT=t.toLowerCase().toCharArray();
	        
	        for (int i=0;i<arrayS.length;i++){
	           count[arrayS[i]-a]++; 
	        }
	        
	        
	         for (int i=0;i<arrayT.length;i++){
	           count[arrayT[i]-a]--;  
	        }
	        
	      
	        int sum = 0;
	        for(int i = 0 ; i< count.length ;i++){
	            sum+= Math.abs(count[i]);
	        }	  
	        
	        /**
	         * boolean allNonZero = true;
			for (int i = 0; allNonZero && i < array.length; ++i) {
			    if (array[i] == 0) {
			        allNonZero = false;
			    }
}
	         */
	        
	        return sum==0 ?true:false;
	        
	    }
	}
/**
 *
94.69 %
36 / 36 test cases passed.
Status: Accepted
Runtime: 3 ms
Memory Usage: 43.8 MB

*/
