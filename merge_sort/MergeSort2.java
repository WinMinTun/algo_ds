/**
*   Bottom Up Merge Sort
*   - Divide and conquer algorithm
*   Basic Plan
*   (1) Pass through array, merging subarrays of size 1
*   (2) Repeat subarrays of size 2, 4, 8, 16, ...
*   
*   Do Check 
*   (1) https://www.coursera.org/learn/algorithms-part1/lecture/PWNEl/bottom-up-mergesort
*   (2) https://www.toptal.com/developers/sorting-algorithms
*
*   Compare with Top Down Merge Sort. Unlike Top Down Merge Sort, no recursion needed and simpler
*/
import java.util.Random;

public class MergeSort2 {

    public static void sort(int[] sortee) {
        if (sortee == null) return;

        int N = sortee.length;
        for (int sz = 1; sz < N; sz = sz+sz) {
            for (int lo = 0; lo < N-sz; lo += sz+sz) {
                merge(sortee, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }

    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r]
    // Contents inside both of First and Second subarrays are sorted already respectively
    private static void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    }

    /* A utility function to print array of size n */
    private static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 

    public static void main(String[] args) {
        int[] sortee = new int[100];

        Random r = new Random();
        for(int i=0; i<=99; i++) {
            sortee[i] = r.nextInt(1000);
        }
        System.out.println("--- BEFORE SORT ---");
        printArray(sortee);

        MergeSort2.sort(sortee);

        System.out.println("--- AFTER SORT ---");
        printArray(sortee);
    }
}