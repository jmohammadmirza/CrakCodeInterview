/*You are given an array AA. Now you need to convert this array into special array which has the following characteristics. 
1. All prime numbers come before all non prime numbers in the special array even if they are greater
2. All prime numbers are sorted in increasing order
3. All non prime numbers are sorted in decreasing order 
For example let the array AA is 1,4,3,2,61,4,3,2,6 then the array after special sorting will become 2,3,6,4,12,3,6,4,1. Note that 11is not a prime number. Here 22 and 33 are prime so they are sorted in increasing order and 6,4,16,4,1 are non prime so they are sorted in decreasing order. Also all the prime numbers come before non prime
Input
First line contains an integer NN as input denoting total elements in the array AA. Next line contains NN space separated integers that denotes the element of array AA.
Output
In the output you need to print the array elements separated by space after it is specially sorted. 
Constraints
1≤N≤1051≤N≤105
1≤A[i]≤1061≤A[i]≤106
SAMPLE INPUT
 
5
1 4 3 2 6
SAMPLE OUTPUT
 
2 3 6 4 1 
Explanation
.
Time Limit:1.0 sec(s) for each input file.
Memory Limit:256 MB
Source Limit:1024 KB
Marking Scheme:Marks are awarded when all the testcases pass.
Allowed Languages:C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, Haskell, Java, Java 8, JavaScript(Rhino), JavaScript(Node.js), Julia, Kotlin, Lisp, Lisp (SBCL), Lua, Objective-C, OCaml, Octave, Pascal, Perl, PHP, Python, Python 3, R(RScript), Racket, Ruby, Rust, Scala, Swift, Visual Basic
*/

package com.something.anyting;

import java.util.*;
	 
	class SpecialArraySapeint {
		
		SpecialArraySapeint(int n){
			this.n = n;
			primeArray = new ArrayList<Integer>(n);
			nonPrimeArray = new ArrayList<Integer>(n);
		}
		
	
	    private ArrayList<Integer> primeArray;
		private ArrayList<Integer> nonPrimeArray;
		public int n;
	
		
		private boolean isPrime(int n)
		{
		       if((n > 2 && n % 2 == 0) || n == 1) {
		            return false;
		        }
		 
		        for (int i = 3; i <= (int)Math.sqrt(n); i += 2) {
		 
		            if (n % i == 0) {
		                return false;
		            }
		        }
		 
		        return true;
		}
		
		public void addInput(int no)
		{
			if(isPrime(no))
				primeArray.add(no);
			else
				nonPrimeArray.add(no);
		}
		
		public void print()
		{
			Collections.sort(primeArray);
			Collections.sort(nonPrimeArray);
			Collections.reverse(nonPrimeArray);
			Iterator<Integer> itr = primeArray.iterator();
			while(itr.hasNext())
				System.out.print(itr.next()+" ");
			itr = nonPrimeArray.iterator();
			while(itr.hasNext())
				System.out.print(itr.next()+" ");
			System.out.println();
		}
		
		public static void main(String args[])
		{
			try
			{
				Scanner s = new Scanner(System.in);
				int n = s.nextInt();
				SpecialArraySapeint input = new SpecialArraySapeint(n);
				int i;
				for(i = 1;i<=n;i++)
					input.addInput(s.nextInt());
				input.print();
			}
			catch(Exception e)
			{
				System.out.println("Exception caught - "+e);
			}
		}
	}
