import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

// Main class should be named 'Solution' and should not be public.
class Solution {
    public static void main(String[] args) {
      //  System.out.println("Hello, World");
        int N=10;
        displayMatrix(N);
    }
    
    public static void displayMatrix(int N){
        
         for (int i = 1; i <= N; i++) {
        // Print spaces before the asterisks
             for (int j = 1; j <= N - i; j++) {
            System.out.print(" ");
            }
        
           // Print asterisks with spaces between them
            for (int k = 1; k <= i; k++) {
            System.out.print("* ");
            }
        
           // Move to the next line
           System.out.println(); 
        }
   }
}

/**
OUTPUT
=============================================

         * 
        * * 
       * * * 
      * * * * 
     * * * * * 
    * * * * * * 
   * * * * * * * 
  * * * * * * * * 
 * * * * * * * * * 
* * * * * * * * * * 

*/
  
