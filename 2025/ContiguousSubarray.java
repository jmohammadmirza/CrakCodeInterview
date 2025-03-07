/**
* The Problem: Finding a Subarray with a Specific Sum

Imagine you have a series of daily expenses (nums array), and you want to 
find the shortest period (subarray) where your total expenses equal a target amount (k).

Key Idea: Prefix Sums

A prefix sum is the cumulative sum of elements up to a certain point.
For example, if nums = [1, 2, 3, 4], the prefix sums would be [1, 3, 6, 10].
***********************************************
The sum of any subarray can be calculated by subtracting prefix sums. 
For example, the sum of the subarray [2, 3] (from index 1 to 2) is 6 - 1 = 5.
******************************************************
The Logic Inside the if Statement

currentSum: This variable keeps track of the prefix sum up to the current index i.
currentSum - k: This is the crucial part. We're looking for a previous prefix sum that, when subtracted from the currentSum,
gives us k.
In other words, we're asking: "Was there a time in the past when my cumulative expenses were currentSum - k?"
prefixSumMap.containsKey(currentSum - k): This checks if we've encountered currentSum - k before.
If it's true, it means there's a subarray ending at the current index i with a sum of k.
startIndex = prefixSumMap.get(currentSum - k): If we found currentSum - k in the map, we retrieve its index (startIndex).
This index marks the beginning of the subarray with sum k.
minLength = Math.min(minLength, i - startIndex): We calculate the length of the subarray (i - startIndex) and update minLength if this subarray is shorter than the shortest one we've found so far.
Why This Works

If prefixSumMap contains currentSum - k, it means:
There was a previous point in time when the cumulative sum was currentSum - k.
The difference between currentSum and currentSum - k is k.
Therefore, the subarray between the index of currentSum - k and the current index i has a sum of k.
Real Life Example

Lets say:

nums = [2, 3, 1, 2, 4, 3]
k = 7
i = 0: currentSum = 2. prefixSumMap is {0: -1, 2: 0}.
i = 1: currentSum = 5. prefixSumMap is {0: -1, 2: 0, 5: 1}.
i = 2: currentSum = 6. prefixSumMap is {0: -1, 2: 0, 5: 1, 6:2}.
i = 3: currentSum = 8. Now, currentSum - k = 8 - 7 = 1. prefixSumMap does not contain 1. 
prefixSumMap is {0: -1, 2: 0, 5: 1, 6: 2, 8: 3}
i = 4: currentSum = 12. Now, currentSum - k = 12 - 7 = 5. prefixSumMap does contain 5.
startIndex = prefixSumMap.get(5) = 1.
minLength = 4 - 1 = 3.
This shows that the subarray from index 1 to 4 [3,1,2,4] sums to 7.
i = 5: currentSum = 15. Now, currentSum - k = 15 - 7 = 8. prefixSumMap does contain 8.
startIndex = prefixSumMap.get(8) = 3
minLength = Math.min(3, 5-3) = 2.
This means the subarray from index 3 to 5 [2,4,3] sums to 7.
In summary: The if condition checks if a previous prefix sum exists that, when subtracted from the current prefix sum,
equals the target sum k. 
If it does, it means we've found a subarray with the desired sum, and we update the minimum length accordingly.
* 
*
*
*
*
*
*
*/

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
