import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConversionIntStringCharJava8 {

public static void main(String[] args) {
		int[] intArray = {1, 2, 3, 4, 5};
		
		List<Integer> intList=Arrays.stream(intArray).boxed().collect(Collectors.toList());
		
		System.out.println(intList);
		
		String[] stringArray = {"apple", "banana", "cherry"};

		// Java 8+
		List<String> stringList = Arrays.asList(stringArray);
		
		//stringList.add("javed");  Uncomment to see error
		//Exception in thread "main" java.lang.UnsupportedOperationException
		//at java.base/java.util.AbstractList.add(AbstractList.java:153)

		// Older Java versions (or if you need a mutable list)
		List<String> stringListMutable = new ArrayList<>(Arrays.asList(stringArray)); // Create a new ArrayList

		System.out.println(stringList); // Output: [apple, banana, cherry]
		System.out.println(stringListMutable); // Output: [apple, banana, cherry]
		
		
		//List<String> to String[]:
		
		List<String> listString = Arrays.asList("apple", "banana", "cherry");

		String[] listStringArray = stringList.toArray(new String[0]); // Important!

		System.out.println(Arrays.toString(listStringArray)); // Output: [apple, banana, cherry]
		
		//char[] to List<Character>
}
}
		
		char[] charArray = {'a', 'b', 'c'};

		List<Character> charList = new String(charArray).chars().mapToObj(ch->(char)ch).collect(Collectors.toList());
		                                                   
		System.out.println(charList); // Output: [a, b, c]
