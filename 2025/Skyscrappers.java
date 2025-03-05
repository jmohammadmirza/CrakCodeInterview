/**
 * 
 PayPay Japan.
 ========================
 Find the largest square area that can fit within a cityscape represented by an array cityLine, where each element denotes the height of a skyscraper with a width of 1. The skyscrapers are adjacent to each other without gaps.

Input:

An array cityLine representing the heights of the skyscrapers. For example, cityLine = [1, 2, 3, 2, 1].

Output:

The largest square area that can fit within the cityscape. For the example input, the output is 4 (a 2x2 square).

The example provided illustrates the problem:

Code



cityLine = [1, 2, 3, 2, 1]

In this case, several 2x2 squares can fit within the configuration of skyscrapers, but no larger square can. Therefore, the largest square area is 2 * 2 = 4..

SOLUTION:: 

Well this questions drills down to  find first two consecutive numbers with the maximum sum

And the square of minmium of the  two consecutive numbers will give the  area
 * 
 * 
 */


public class Skyscrappers {
    

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 2, 1};

        int[] array2 = {4,3,4};

        int[] result = findMaxConsecutiveSum(array2);

        System.out.println("The first two consecutive numbers with the maximum sum are: "
         + result[0] + ", " + result[1]);
                
        int square=Math.min(result[0], result[1]);

        System.out.println("Largest Area Square "+ square*square);
        
    }
        
        
    public static int[] findMaxConsecutiveSum(int[] array) {
        if (array == null || array.length < 2) {
            return null; // Or throw an exception, depending on your requirements
        }

        int maxSum = array[0] + array[1];
        int[] maxIndices = {0, 1};

        for (int i = 1; i < array.length - 1; i++) {
            int currentSum = array[i] + array[i + 1];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxIndices[0] = i;
                maxIndices[1] = i + 1;
            }
        }

        return new int[]{array[maxIndices[0]], array[maxIndices[1]]};
    }
}
