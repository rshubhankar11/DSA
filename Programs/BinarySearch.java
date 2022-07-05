/**
 * BinarySearch
 * 
 * Binary Search is a searching algorithm used in a sorted array by repeatedly
 * dividing the search interval in half. The idea of binary search is to use the
 * information that the array is sorted and reduce the time complexity to
 * O(Log n).
 * 
 * The basic steps to perform Binary Search are:
 *
 * 1.Begin with the mid element of the whole array as a search key.
 * 2.If the value of the search key is equal to the item then return an index of
 * the search key.
 * 3.Or if the value of the search key is less than the item in the middle of
 * the interval, narrow the interval to the lower half.
 * 4.Otherwise, narrow it to the upper half.
 * 5.Repeatedly check from the second point until the value is found or the
 * interval is empty.
 * 
 * Binary Search Algorithm can be implemented in the following two ways
 *
 * 1.Iterative Method
 * 
 * binarySearch(arr, x, low, high)
 * repeat till low = high
 * mid = (low + high)/2
 * if (x == arr[mid])
 * return mid
 * 
 * else if (x > arr[mid]) // x is on the right side
 * low = mid + 1
 * 
 * lse // x is on the left side
 * high = mid - 1
 * 
 * 2.Recursive Method (The recursive method follows the divide and conquers
 * approach)
 * 
 * binarySearch(arr, x, low, high)
 * if low > high
 * return False
 * 
 * else
 * mid = (low + high) / 2
 * if x == arr[mid]
 * return mid
 * 
 * else if x > arr[mid] // x is on the right side
 * return binarySearch(arr, x, mid + 1, high)
 * 
 * else // x is on the right side
 * return binarySearch(arr, x, low, mid - 1)
 * 
 * 
 */
public class BinarySearch {

    // recursive Binary Search
    // Returns index of x if it is present in arr[l..
    // r], else return -1
    int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }

    // iterative Binary Search
    // Returns index of x if it is present in arr[],
    // else return -1
    int binarySearch(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

            // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }

    // Driver method to test above
    public static void main(String args[]) {
        BinarySearch ob = new BinarySearch();
        int arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        int resultFromIteration = ob.binarySearch(arr, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index : "
                    + result + " Using Iterator : " + resultFromIteration);
    }

}