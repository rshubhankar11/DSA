/**
 * BinarySearchProgramTwo
 * 
 * Q3. Find the first or last occurrence of a given number in a sorted array?
 * 
 * Given a sorted integer array, find the index of a given number’s first or
 * last occurrence. If the element is not present in the array, report that as
 * well.
 * Input:
 * 
 * nums = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9]
 * target = 5
 * 
 * Output:
 * 
 * The first occurrence of element 5 is located at index 1
 * The last occurrence of element 5 is located at index 3
 * 
 * 
 * Input:
 * 
 * nums = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9]
 * target = 4
 * 
 * Output:
 * 
 * Element not found in the array
 */
public class BinarySearchProgramTwo {
    // Function to find the first occurrence of a given number
    // in a sorted integer array
    public static int findFirstOccurrence(int[] nums, int target) {
        // search space is nums[left…right]
        int left = 0;
        int right = nums.length - 1;

        // initialize the result by -1
        int result = -1;

        // loop till the search space is exhausted
        while (left <= right) {
            // find the mid-value in the search space and compares it with the target
            int mid = (left + right) / 2;

            // if the target is located, update the result and
            // search towards the left (lower indices)
            if (target == nums[mid]) {
                result = mid;
                right = mid - 1;
            }

            // if the target is less than the middle element, discard the right half
            else if (target < nums[mid]) {
                right = mid - 1;
            }

            // if the target is more than the middle element, discard the left half
            else {
                left = mid + 1;
            }
        }

        // return the leftmost index, or -1 if the element is not found
        return result;
    }

    // Function to find the last occurrence of a given number
    // in a sorted integer array
    public static int findLastOccurrence(int[] nums, int target) {
        // search space is nums[left…right]
        int left = 0;
        int right = nums.length - 1;

        // initialize the result by -1
        int result = -1;

        // loop till the search space is exhausted
        while (left <= right) {
            // find the mid-value in the search space and compares it with the target
            int mid = (left + right) / 2;

            // if the target is located, update the result and
            // search towards the right (higher indices)
            if (target == nums[mid]) {
                result = mid;
                left = mid + 1;
            }

            // if the target is less than the middle element, discard the right half
            else if (target < nums[mid]) {
                right = mid - 1;
            }

            // if the target is more than the middle element, discard the left half
            else {
                left = mid + 1;
            }
        }

        // return the leftmost index, or -1 if the element is not found
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 5, 5, 5, 6, 6, 8, 9, 9, 9 };
        int target = 5;

        int index = findFirstOccurrence(nums, target);

        if (index != -1) {
            System.out.println("The first occurrence of element " + target +
                    " is located at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }
    }
}