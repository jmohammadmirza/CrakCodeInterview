/** 
 * Given a string, , matching the regular expression [A-Za-z !,?._'@]+, split the string into tokens. We define a token to be one or more consecutive English alphabetic letters. Then, print the number of tokens, followed by each token on a new line.

Note: You may find the String.split method helpful in completing this challenge.

Input Format

A single string, .

Constraints

 is composed of any of the following: English alphabetic letters, blank spaces, exclamation points (!), commas (,), question marks (?), periods (.), underscores (_), apostrophes ('), and at symbols (@).
Output Format

On the first line, print an integer, , denoting the number of tokens in string  (they do not need to be unique). Next, print each of the  tokens on a new line in the same order as they appear in input string .

Sample Input

He is a very very good boy, isn't he?
Sample Output

10
He
is
a
very
very
good
boy
isn
t
he
Explanation

We consider a token to be a contiguous segment of alphabetic characters. There are a total of  such tokens in string , and each token is printed in the same order in which it appears in string .++
 * */

import java.util.Scanner;

public class StringTokenizer {

	public static void main(String[] args) {
		  Scanner scan = new Scanner(System.in);
	        String s = scan.nextLine();
	        // Write your code here.
	        
	       // Handle empty or null string
	        if (s == null || s.isEmpty()) {
	            System.out.println(0);
	            return;
	        }
	        
	        // Split the string using a regex that matches anything that's not an alphabetic letter
	        // This will keep only consecutive alphabetic letters as tokens
	        String[] tokens = s.split("[^a-zA-Z]+");
	        
	        // Count non-empty tokens
	        int tokenCount = 0;
	        for (String token : tokens) {
	            if (!token.isEmpty()) {
	                tokenCount++;
	            }
	        }
	        
	        // Print the count of tokens
	        System.out.println(tokenCount);
	        
	        // Print each non-empty token on a new line
	        for (String token : tokens) {
	            if (!token.isEmpty()) {
	                System.out.println(token);
	            }
	        }
	        scan.close();

	}

}
