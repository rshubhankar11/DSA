/**
 * BinarySearchProgram
 * 
 * Q1.Search insert position of K in a sorted array';?
 * 
 * Given a sorted array arr[] consisting of N distinct integers
 * and an integer K, the task is to find the index of K,
 * if it’s present in the array arr[].
 * Otherwise, find the index where K must be inserted to keep the array sorted.
 * 
 * Input: arr[] = {1, 3, 5, 6}, K = 5
 * Output: 2
 * Explanation: Since 5 is found at index 2 as arr[2] = 5, the output is 2.
 * 
 * Input: arr[] = {1, 3, 5, 6}, K = 2
 * Output: 1
 * Explanation: Since 2 is not present in the array but can be inserted at index
 * 1 to make the array sorted.
 * 
 * as the given array is shorted we have to first think about applying Binary
 * Search
 * So tha we cah have O(log n) as time complexity
 */
public class BinarySearchProgram {

    public static int findAnElement(int[] arr, int start, int end, int element) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == element) {
                return mid;
            } else if (arr[mid] < element) {
                start = mid + 1;
            } else if (arr[mid] > element) {
                end = mid - 1;
            }
        }
        return end + 1;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 3, 5, 6 };
        int n = arr.length;
        int K = 2;

        System.out.println(findAnElement(arr, 0, n, K));
    }
}