import java.util.Random;

public class MergeSortTest {

    public void sort(int[] sortee) {

    }

    public void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l+r)/2;

            sort(arr, l, m);
            sort(arr, m+1, r);

            merge(arr, l, m, r);

        }
    }

    public void merge(int[] arr, int l, int m, int r) {
        int lSize = m - l + 1;
        int rSize = r - m;

        int k=0;
        int j=0;
        int l=0;

        int[] L = new int[lSize];
        int[] R = new int[rSize];

        for (int i=l; i< lSize; i++) {
            L[j] = arr[i];
            j++;
        }

        for (int i=m+1; i< rSize; i++) {
            R[l] = arr[i];
            l++;
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

        for(int i=0; i<=99; i++) {
            sortee[i] = Random.nextInt(1000);
        }

        System.out.println("===== BEFORE =====");
        printArray(sortee);

        MergeSortTest.sort(sortee);

        System.out.println("==== AFTER =====");
        printArray(sortee);


    }
}