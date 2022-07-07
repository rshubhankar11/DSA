/**
 * BinarySearchProgramOne
 * 
 * Q2.Find the number of rotations in a circularly sorted array?
 * 
 * Given a circularly sorted integer array, find the total number of times the
 * array is rotated. Assume there are no duplicates in the array, and the
 * rotation is in the anti-clockwise direction.
 * 
 * For example,
 * 
 * Input: nums = [8, 9, 10, 2, 5, 6]
 * Output: The array is rotated 3 times
 * 
 * 
 * Input: nums = [2, 5, 6, 8, 9, 10]
 * Output: The array is rotated 0 times
 * 
 * https://www.techiedelight.com/find-number-rotations-circularly-sorted-array/
 */
public class BinarySearchProgramOne {
    // This logic will only work when therer is no duplicate values
    // Function to find the total number of times the array is rotated
    public static int findRotationCount(int[] nums) {
        // search space is nums[left…right]
        int left = 0;
        int right = nums.length - 1;

        // loop till the search space is exhausted
        while (left <= right) {
            // if the search space is already sorted, we have
            // found the minimum element (at index `left`)
            if (nums[left] <= nums[right]) {
                return left;
            }

            int mid = (left + right) / 2;

            // find the next and previous element of the `mid` element
            // (in a circular manner)
            int next = (mid + 1) % nums.length;
            int prev = (mid - 1 + nums.length) % nums.length;

            // if the `mid` element is less than both its next and previous
            // neighbor, it is the array's minimum element

            if (nums[mid] <= nums[next] && nums[mid] <= nums[prev]) {
                return mid;
            }

            // if nums[mid…right] is sorted, and `mid` is not the minimum element,
            // then the pivot element cannot be present in nums[mid…right],
            // discard nums[mid…right] and search in the left half

            else if (nums[mid] <= nums[right]) {
                right = mid - 1;
            }

            // if nums[left…mid] is sorted, then the pivot element cannot be present
            // in it; discard nums[left…mid] and search in the right half

            else if (nums[mid] >= nums[left]) {
                left = mid + 1;
            }
        }

        // invalid input
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 8, 9, 10, 1, 2, 3, 4, 5, 6, 7 };

        System.out.println("Array is rotated " + findRotationCount(nums) + " times");
    }

}