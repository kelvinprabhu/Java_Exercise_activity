public class HeapSort {
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build the max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move the root to the end of the array
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 1, 9 };

        // Record start time
        long startTime = System.nanoTime();

        // Perform heap sort
        heapSort(arr);

        // Record end time
        long endTime = System.nanoTime();

        // Calculate time taken in nanoseconds
        long duration = endTime - startTime;

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println("\nTime taken for heap sort: " + duration + " nanoseconds");
    }
}
