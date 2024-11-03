public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 1, 9 };
        int n = arr.length;
        long startTime = System.nanoTime();
        int[] sortedArr = mergeSort(arr, n);
        // Record end time
        long endTime = System.nanoTime();

        // Calculate time taken in nanoseconds

        printArray(sortedArr);
        long duration = endTime - startTime;
        System.out.println("\nTime taken for Merge sort: " + duration + " nanoseconds");

    }

    public static void conquer(int[] arr, int si, int mid, int ei) {
        int merger[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                merger[k] = arr[i];
                i++;
            } else {
                merger[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            merger[k] = arr[i];
            i++;
            k++;
        }
        while (j <= ei) {
            merger[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < merger.length; l++) {
            arr[si + l] = merger[l];
        }
    }

    public static void divide(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2; // si + ei / 2 is could increase the chances of overflow
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conquer(arr, si, mid, ei);
    }

    public static int[] mergeSort(int[] arr, int n) {
        divide(arr, 0, n - 1);
        return arr;
    }

    public static void printArray(int[] arr) {
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
