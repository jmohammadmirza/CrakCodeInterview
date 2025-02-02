import java.util.Arrays;

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
