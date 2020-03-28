Alice is taking a cryptography class and finding anagrams to be very useful.
We consider two strings to be anagrams of each other if the first string's letters can be rearranged to form the second string. 
In other words, both strings must contain the same exact letters in the same exact frequency For example, bacdc and dcbac are anagrams, 
but bacdc and dcbad are not.

Alice decides on an encryption scheme involving two large strings where encryption is dependent on the minimum number of character 
deletions required to make the two strings anagrams. Can you help her find this number?
Given two strings,  and , that may or may not be of the same length, determine the minimum number of character deletions 
required to make  and  anagrams. Any characters can be deleted from either of the strings.

Sample Input

cde
abc
Sample Output

4
Explanation

We delete the following characters from our two strings to turn them into anagrams of each other:

Remove d and e from cde to get c.
Remove a and b from abc to get c.
We must delete  characters to make both strings anagrams, so we print  on a new line.

Thanks to http://techieme.in/make-anagrams-from-two-strings/  for giving the Algo
************************************************************************************************************************************

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class MakeAnagrams {
    public static int numberNeeded(String first, String second) {
        
        int[] count=new int[26];
         char a = 'a';
        char[] arrayA=first.toCharArray();
        char[] arrayB=second.toCharArray();
        
        for (int i=0;i<arrayA.length;i++){
           count[arrayA[i]-a]++; 
        }
        
         for (int i=0;i<arrayB.length;i++){
           count[arrayB[i]-a]--;  
        }
        
      
        int sum = 0;
        for(int i = 0 ; i< count.length ;i++){
            sum+= Math.abs(count[i]);
        }
        
      //Below commented code does not satisfy all test cases
        //String encrypt=first+second;
        //int n=encrypt.length();
        //
       // int temp=n;
        
      //  char characters[] = second.toCharArray();
    
      //  for (int i = 0; i < characters.length; i++) {
              //if ( first.indexOf(characters[i])>=0) {
        //                n=n-2;
         //   }
         //   else{
                
        //    }
       //  }
        // return n;
        
       return sum;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}






