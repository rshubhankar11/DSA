/**
 * LinearSearch
 * 
 * A simple approach is to do a linear search, i.e
 *
 * 1. Start from the leftmost element of arr[] and one by one compare x with
 * each
 * element of arr[]
 * 2. If x matches with an element, return the index.
 * 3. If x doesn’t match with any of the elements, return -1.
 * 
 * 
 * The time complexity will be O(n) in Worst and Average case and in Best case
 * it will be O(1).
 */
public class LinearSearch {

    public static int search(int[] arr, int x) {
        for (int i : arr) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // This is another approche to do liner search
    public static void searchOne(int arr[], int search_Element) {
        int left = 0;
        int length = arr.length;
        int right = length - 1;
        int position = -1;
        // run loop from 0 to right
        for (left = 0; left <= right;) {
            // if search_element is found with left variable
            if (arr[left] == search_Element) {
                position = left;
                System.out.println(
                        "Element found in Array at "
                                + (position + 1) + " Position with "
                                + (left + 1) + " Attempt");
                break;
            }
            // if search_element is found with right variable
            if (arr[right] == search_Element) {
                position = right;
                System.out.println(
                        "Element found in Array at "
                                + (position + 1) + " Position with "
                                + (length - right) + " Attempt");
                break;
            }
            left++;
            right--;
        }
        // if element not found
        if (position == -1)
            System.out.println("Not found in Array with "
                    + left + " Attempt");
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;
        int result = search(arr, x);
        if (result == -1) {
            System.out.println("sorry this element: " + x + " is not in array");
        } else {
            System.out.println("this element: " + x + " is in idex no: " + result);
        }
    }

    // This apporch use recursion to apply linear serach
    // This code is written in c++ need to modify it before uncommenting it
    // int linearsearch(int arr[], int size, int key)
    // {
    // if (size == 0)
    // {
    // return -1;
    // }
    // if (arr[size] == key)
    // {
    // return size;
    // }
    // else
    // {
    // int ans = linearsearch(arr, size - 1, key);
    // return ans;
    // }
    // }

}