public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 1, 9 };
        int n = arr.length;

        long startTime = System.nanoTime(); // Start time measurement
        quickSort(arr, 0, n - 1);
        long endTime = System.nanoTime(); // End time measurement

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        long executionTime = endTime - startTime;
        System.out.println("\nExecution time (in nanoseconds): " + executionTime);
    }
}
