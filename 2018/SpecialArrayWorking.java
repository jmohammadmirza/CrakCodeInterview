
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
//import for Scanner and other utility classes
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
 
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
 
class TestClass {
    public static boolean isPrime(int n) {
        if (n <= 1 )
            return false;
        if (n == 2) 
            return true;
        if (n % 2 == 0)
            return false;
        for(int i = 3; i <= Math.sqrt(n); i+=2) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for(int i= 0;i<n;i++)
            a.add(sc.nextInt());
            
        List<Integer> primes = a.stream()
                                    .filter(i -> isPrime(i))
                                    .collect(Collectors.toList());
        List<Integer> others = a.stream()
                                    .filter(i -> !isPrime(i))
                                    .collect(Collectors.toList());
                                    
        Collections.sort(primes);
        Collections.sort(others, Collections.reverseOrder());
        
        a = new ArrayList<Integer>();
        a.addAll(primes);
        a.addAll(others);
        
        for(Integer i : a) {
            System.out.print(i + " ");
        }
        
 
    }
}
