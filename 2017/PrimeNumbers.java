import java.util.*;
import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		int sum=0;
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number till which the prime numbers are to be calculated from : ");
        int input = scanner.nextInt();
        System.out.print("Enter the number till which the prime numbers are to be calculated to : ");
        int input2=scanner.nextInt();
        scanner.close();
        List<Integer> primes = new ArrayList<Integer>();

        // loop through the numbers one by one
        for (int i = input; i < input2; i++) {
            boolean isPrimeNumber = true;

            // check to see if the number is prime
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break; // exit the inner for loop
                }
            }

            // print the number if prime
            if (isPrimeNumber) {
            	sum+=i;
                primes.add(i);
            }
        }
        String s = primes.toString().replace("[", "").replace("]", "");
        System.out.println("The number of prime is: " + primes.size() + ", and they are: " + s);
        System.out.println("\nThe Sum is "+sum);
	}

} 
