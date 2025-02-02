import java.util.Arrays;
/**
Let me explain how the circular buffer approach works:

Basic Concept

Instead of creating a new array, we rotate elements in-place
We move each element to its final position in a circular manner
We keep track of elements we've moved to avoid moving them again


The Algorithm Steps:
Let's say we have array ["A", "B", "C", "D", "E"] and want to rotate right by k=2
Initial state: ["A", "B", "C", "D", "E"]
Starting from index 0:
Copy1st cycle (start = 0):
- Current position = 0 ("A")
- Next position = (0 + 2) % 5 = 2
- Move "A" → position 2
["A", "B", "A", "D", "E"]  // A is placed

- Current position = 2 ("C")
- Next position = (2 + 2) % 5 = 4
- Move "C" → position 4
["A", "B", "A", "D", "C"]  // C is placed

- Current position = 4 ("E")
- Next position = (4 + 2) % 5 = 1
- Move "E" → position 1
["A", "E", "A", "D", "C"]  // E is placed

- Current position = 1 ("B")
- Next position = (1 + 2) % 5 = 3
- Move "B" → position 3
["A", "E", "A", "B", "C"]  // B is placed

Key Advantages:

Space Efficient: O(1) extra space
In-place rotation: No need for extra array
Handles all array sizes efficiently
Each element is moved exactly once


Time Complexity: O(n) where n is array length

Each element is moved exactly once
No extra space needed beyond a few variables



Here's how you would use it:
javaCopyString[] array = {"A", "B", "C", "D", "E"};

// Right rotation by 2
rotateUsingCircularBuffer(array, 2, true);
// Result: ["D", "E", "A", "B", "C"]

// Left rotation by 2
rotateUsingCircularBuffer(array, 2, false);
// Result: ["C", "D", "E", "A", "B"]
The circular buffer approach is particularly useful when:

Memory is constrained (works in-place)
You're working with large arrays
You need to minimize memory allocation
Performance is critical



*/

public class CircularBufferRotation {

	public static void main(String[] args) {
		      String[] array = {"A", "B", "C", "D", "E", "F"};
		 
	        System.out.println("Original array: " + Arrays.toString(array));
	        
	        rotateUsingCircularBuffer(array, 2, false);
	        System.out.println("After left rotation by 2: " + Arrays.toString(array));
	        
	        int[] arrayInt= {1,2,3,4,5};
	        
	        rotateUsingCircularBufferInt(arrayInt,2,true);
	        System.out.println("After right rotation by 2: " + Arrays.toString(arrayInt));

	}
		
	}
	private static void rotateUsingCircularBuffer(String[] array, int k, boolean isRightRotate) {
        int n = array.length;
        if (n <= 1) return;
        
        // Normalize k and handle rotation direction
        k = k % n;
        if (!isRightRotate) {
            k = (n - k) % n;
        }
        if (k == 0) return;

        // Keep track of how many elements we've moved
        int count = 0;
        
        // Continue until we've moved all elements
        for (int start = 0; count < n; start++) {
            int current = start;
            String prev = array[start];
            
            do {
                // Calculate the next position
                int next = (current + k) % n;
                
                // Store current value of next position
                String temp = array[next];
                
                // Place prev value in its new position
                array[next] = prev;
                
                // Update prev and current for next iteration
                prev = temp;
                current = next;
                count++;
                
            } while (start != current);
        }
    }
	private static void rotateUsingCircularBufferInt(int[] array, int k, boolean isRightRotate) {
        int n = array.length;
        if (n <= 1) return;
        
        // Normalize k and handle rotation direction
        k = k % n;
        if (!isRightRotate) {
            k = (n - k) % n;
        }
        if (k == 0) return;

        // Keep track of how many elements we've moved
        int count = 0;
        
        // Continue until we've moved all elements
        for (int start = 0; count < n; start++) {
            int current = start;
            int prev = array[start];
            
            do {
                // Calculate the next position
                int next = (current + k) % n;
                
                // Store current value of next position
                int temp = array[next];
                
                // Place prev value in its new position
                array[next] = prev;
                
                // Update prev and current for next iteration
                prev = temp;
                current = next;
                count++;
                
            } while (start != current);
        }
    
}
