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
