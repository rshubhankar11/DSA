/**
 * SmallestElementOfArray
 * In this program we will find the smallest element of an array
 * to do so we will apply #Divide and #Conquer Algo
 * 
 * Divide And Conquer
 * This technique can be divided into the following three parts:
 *
 * 1.Divide: This involves dividing the problem into smaller sub-problems.
 * 2.Conquer: Solve sub-problems by calling recursively until solved.
 * 3.Combine: Combine the sub-problems to get the final solution of the whole
 * problem.
 * 
 * Divide And Conquer algorithm :
 * 
 * DAC(a, i, j)
 * {
 * if(small(a, i, j))
 * return(Solution(a, i, j))
 * else
 * m = divide(a, i, j) // f1(n)
 * b = DAC(a, i, mid) // T(n/2)
 * c = DAC(a, mid+1, j) // T(n/2)
 * d = combine(b, c) // f2(n)
 * return(d)
 * }
 * 
 * Time Complexity of Divide and Conquer Algorithm:
 * 
 * T(n) = aT(n/b) + f(n),
 * 
 * where,
 * n = size of input
 * a = number of subproblems in the recursion
 * n/b = size of each subproblem. All subproblems are assumed to have the same
 * size.
 * f(n) = cost of the work done outside the recursive call, which includes the
 * cost of dividing the problem and cost of merging the solutions
 * 
 * Advantages of Divide and Conquer Algorithm:
 *
 * 1.The difficult problem can be solved easily.
 * 2.It divides the entire problem into subproblems thus it can be solved
 * 3.parallelly ensuring multiprocessing
 * 4.Efficiently uses cache memory without occupying much space
 * 5.Reduces time complexity of the problem
 *
 * Disadvantages of Divide and Conquer Algorithm:
 *
 * 1. It involves recursion which is sometimes slow
 * 2. Efficiency depends on the implementation of logic
 * 3.It may crash the system if the recursion is performed rigorously
 */
public class SmallestElementOfArray {

    public static void main(String[] args) {
        int[] arr = { 1, 4, 6, 7, 8, 5 };
        int arrSize = arr.length;
        System.out.println(arrSize);
        int arrI = 0;
        int num = DAC_Min(arr, arrI, arrSize);
        System.out.println("Minimum value is :" + num);
    }

    // Function to find the minimum no.
    // in a given array.
    static int DAC_Min(int a[], int index, int l) {
        int min;

        if (index >= l - 2) {
            if (a[index] < a[index + 1])
                return a[index];
            else
                return a[index + 1];
        }

        // Logic to find the Maximum element
        // in the given array.
        min = DAC_Min(a, index + 1, l);

        if (a[index] < min)
            return a[index];
        else
            return min;
    }

    // // Function to find the maximum no.
    // // in a given array.
    // static int DAC_Max(int a[], int index, int l) {
    // int max;

    // if (index >= l - 2) {
    // if (a[index] > a[index + 1])
    // return a[index];
    // else
    // return a[index + 1];
    // }

    // // Logic to find the Maximum element
    // // in the given array.
    // max = DAC_Max(a, index + 1, l);

    // if (a[index] > max)
    // return a[index];
    // else
    // return max;
    // }
}