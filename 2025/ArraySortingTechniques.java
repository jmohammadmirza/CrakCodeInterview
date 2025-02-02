public class ArraySorting {
    // Method 1: Direct Arrays.sort() - Most concise
    public static void sortArray1(int[] nums) {
        Arrays.sort(nums);
    }
    
    // Method 2: Using parallel sort for large arrays
    public static void sortArray2(int[] nums) {
        Arrays.parallelSort(nums);
    }
    
    // Method 3: Using Stream API (returns new array)
    public static int[] sortArray3(int[] nums) {
        return Arrays.stream(nums)
                    .sorted()
                    .toArray();
    }
    
    // Method 4: Using Stream API with parallel processing (returns new array)
    public static int[] sortArray4(int[] nums) {
        return Arrays.stream(nums)
                    .parallel()
                    .sorted()
                    .toArray();
    }
    
    public static void main(String[] args) {
        // Test all methods
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = nums1.clone();
        int[] nums3 = nums1.clone();
        int[] nums4 = nums1.clone();
        
        System.out.println("Original array: " + Arrays.toString(nums1));
        
        // Test Method 1
        sortArray1(nums1);
        System.out.println("After Arrays.sort(): " + Arrays.toString(nums1));
        
        // Test Method 2
        sortArray2(nums2);
        System.out.println("After parallel sort: " + Arrays.toString(nums2));
        
        // Test Method 3
        int[] sorted3 = sortArray3(nums3);
        System.out.println("After stream sort: " + Arrays.toString(sorted3));
        
        // Test Method 4
        int[] sorted4 = sortArray4(nums4);
        System.out.println("After parallel stream sort: " + Arrays.toString(sorted4));
    }
}

/***
Arrays.sort() (Method 1)

Best for small to medium arrays
In-place sorting
Uses dual-pivot quicksort
Most concise solution


Arrays.parallelSort() (Method 2)

Best for large arrays (> 8192 elements)
Automatically uses multiple threads
In-place sorting
Better performance on multi-core systems


Stream API (Method 3)

Creates new array
More functional programming style
Good when you need to chain operations
Not in-place sorting


Parallel Stream (Method 4)

Creates new array
Best for very large datasets
Combines functional style with parallel processing
Higher overhead for small arrays
  
  */
