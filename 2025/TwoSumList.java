/**
The HashMap solution (Method 1) is more efficient with:

Time complexity: O(n)
Space complexity: O(n)
Single pass through the list
Early termination when solution is found

The Stream solution (Method 2) is more functional but less efficient with:

Time complexity: O(n²)
More readable/functional style
Good for learning Java 8 features

Both methods will find the indices [1, 2] because:

al.get(1) = 2
al.get(2) = 4
2 + 4 = 5 (target)
*/


public class TwoSumList {
    // Method 1: Using HashMap - Most efficient
    public static List<Integer> findTwoSum(List<Integer> nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        
        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums.get(i);
            if (numMap.containsKey(complement)) {
                return Arrays.asList(numMap.get(complement), i);
            }
            numMap.put(nums.get(i), i);
        }
        
        return Collections.emptyList(); // Return empty list if no solution found
    }
    
    // Method 2: Using Java 8 Stream API
    public static List<Integer> findTwoSumStream(List<Integer> nums, int target) {
        return IntStream.range(0, nums.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, nums.size())
                        .filter(j -> nums.get(i) + nums.get(j) == target)
                        .mapToObj(j -> Arrays.asList(i, j)))
                .findFirst()
                .orElse(Collections.emptyList());
    }
     // Method 3: Using Java 8 Stream API returns all combination of indices
    public static List<List<Integer>> findTwoSumStreamAllIndices(List<Integer> nums, int target) {
        return IntStream.range(0, nums.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, nums.size())
                        .filter(j -> nums.get(i) + nums.get(j) == target)
                        .mapToObj(j -> Arrays.asList(i, j)))
                        .collect(Collectors.toList());
                .orElse(Collections.emptyList());
    }
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 2, 4, 1);
        int target = 5;
        
        // Test HashMap solution
        List<Integer> result1 = findTwoSum(nums, target);
        System.out.println("HashMap Solution: " + result1);
        if (!result1.isEmpty()) {
            System.out.println("Values: " + nums.get(result1.get(0)) + " + " 
                             + nums.get(result1.get(1)) + " = " + target);
        }
        
        // Test Stream solution
        List<Integer> result2 = findTwoSumStream(nums, target);
        System.out.println("\nStream Solution: " + result2);
        if (!result2.isEmpty()) {
            System.out.println("Values: " + nums.get(result2.get(0)) + " + " 
                             + nums.get(result2.get(1)) + " = " + target);
        }
    }
}
