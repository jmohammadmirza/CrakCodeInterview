import java.util.HashMap;
import java.util.Map;

class ContiguousSubarray {

    // 1. Maximum Subarray Sum (Kadane's Algorithm)
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // Or throw an exception, depending on requirements
        }

        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]); // Key step in Kadane's
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }


    // 2. Subarray with Given Sum (using HashMap for prefix sums)
    public int shortestSubarrayWithSum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) { // k must be positive for lengths to make sense
            return 0; 
        }

        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, -1); // Crucial: Handles cases where a prefix itself sums to k

        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (prefixSumMap.containsKey(currentSum - k)) {
                int startIndex = prefixSumMap.get(currentSum - k);
                minLength = Math.min(minLength, i - startIndex);
            }

            prefixSumMap.put(currentSum, i); // Store current sum *after* checking for the target sum
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }



    public static void main(String[] args) {
        ContiguousSubarray cs = new ContiguousSubarray();

        // Test cases for maxSubArray
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max Subarray Sum: " + cs.maxSubArray(nums1)); // Output: 6

        int[] nums2 = {-1};
        System.out.println("Max Subarray Sum: " + cs.maxSubArray(nums2)); // Output: -1

        int[] nums3 = {-2, -1};
        System.out.println("Max Subarray Sum: " + cs.maxSubArray(nums3)); // Output: -1


        // Test cases for shortestSubarrayWithSum
        int[] arr1 = {2, 3, 1, 2, 4, 3};
        int k1 = 7;
        System.out.println("Shortest Subarray Length: " + cs.shortestSubarrayWithSum(arr1, k1)); // Output: 2

        int[] arr2 = {1, 2, 3, 4, 5};
        int k2 = 9;
        System.out.println("Shortest Subarray Length: " + cs.shortestSubarrayWithSum(arr2, k2)); // Output: 1

        int[] arr3 = {1, 1, 1, 1, 1};
        int k3 = 3;
         System.out.println("Shortest Subarray Length: " + cs.shortestSubarrayWithSum(arr3, k3)); // Output: 3

        int[] arr4 = {-1, -2, -3, -4, -5}; // Demonstrating negative numbers
        int k4 = -9;
        System.out.println("Shortest Subarray Length: " + cs.shortestSubarrayWithSum(arr4, k4)); // Output: 1

        int[] arr5 = {1};
        int k5 = 1;
        System.out.println("Shortest Subarray Length: " + cs.shortestSubarrayWithSum(arr5, k5)); // Output: 1

        int[] arr6 = {1,2,3};
        int k6 = 6;
        System.out.println("Shortest Subarray Length: " + cs.shortestSubarrayWithSum(arr6, k6)); // Output: 1
    }
}
