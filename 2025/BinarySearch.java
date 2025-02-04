/**

Explanation:

search method:

Takes an array arr and a target value target as input.
Initializes low and high indices to represent the search range (initially whole array).
Uses a while loop to iterate until low is greater than high.
Calculates the mid index as the average of low and high.
Compares target with the element at mid:
If equal, returns the mid index (target found).
If target is greater, searches in the right half by setting low to mid + 1.
If target is smaller, searches in the left half by setting high to mid - 1.
If the loop exits without finding the target, returns -1 (target not found).
main method:

Creates a sample array and defines a target value.
Calls the search method to find the target index.
Prints a message based on the returned index (found or not found).
This code demonstrates a basic implementation of binary search and can be adapted to 
work with different data types and scenarios. Remember that the array must be sorted for binary search to function correctly.
*/

public class BinarySearch {

    public static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16};
        int target = 12;

        int index = search(arr, target);

        if (index == -1) {
            System.out.println("Target not found");
        } else {
            System.out.println("Target found at index: " + index);
        }
    }
}
