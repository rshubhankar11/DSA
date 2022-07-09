/**
 * MergeSort
 * 
 * The Merge Sort algorithm is a sorting algorithm that is considered as an
 * example of the divide and conquer strategy. So, in this algorithm, the array
 * is initially divided into two equal halves and then they are combined in a
 * sorted manner. We can think of it as a recursive algorithm that continuously
 * splits the array in half until it cannot be further divided. This means that
 * if the array becomes empty or has only one element left, the dividing will
 * stop, i.e. it is the base case to stop the recursion. If the array has
 * multiple elements, we split the array into halves and recursively invoke the
 * merge sort on each of the halves. Finally, when both the halves are sorted,
 * the merge operation is applied. Merge operation is the process of taking two
 * smaller sorted arrays and combining them to eventually make a larger one.
 * 
 * Pseudocode :
 * 
 * • Declare left variable to 0 and right variable to n-1
 * • Find mid by medium formula. mid = (left+right)/2
 * • Call merge sort on (left,mid)
 * • Call merge sort on (mid+1,rear)
 * • Continue till left is less than right
 * • Then call merge function to perform merge sort.
 * 
 * Algorithm:
 * 
 * step 1: start
 * step 2: declare array and left, right, mid variable
 * step 3: perform merge function.
 * mergesort(array,left,right)
 * mergesort (array, left, right)
 * if left > right
 * return
 * mid= (left+right)/2
 * mergesort(array, left, mid)
 * mergesort(array, mid+1, right)
 * merge(array, left, mid, right)
 * step 4: Stop
 * 
 * 
 * Time Complexity:
 * 
 * O(n logn), Sorting arrays on different machines. Merge Sort
 * is a recursive algorithm and time complexity can be expressed as following
 * recurrence relation.
 * T(n) = 2T(n/2) + θ(n)
 * 
 * The above recurrence can be solved either using the Recurrence Tree method or
 * the Master method. It falls in case II of Master Method and the solution of
 * the recurrence is θ(nLogn). Time complexity of Merge Sort is θ(nLogn) in all
 * 3 cases (worst, average and best) as merge sort always divides the array into
 * two halves and takes linear time to merge two halves.
 * Auxiliary Space: O(n)
 * 
 * Space Complexity :
 * 
 * • In merge sort all elements are copied into an auxiliary array
 * • so N auxiliary space is required for merge sort.
 */
public class MergeSort {

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}