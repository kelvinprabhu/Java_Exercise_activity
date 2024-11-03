import java.util.Arrays;

public class SortingComparison {

    public static void main(String[] args) {
        int[] dataset = { 20, 78, 12, 15, 8, 10, 5, 7, 6, 3 };

        // Clone dataset for each sorting algorithm to keep input consistent
        int[] heapArr = dataset.clone();
        int[] quickArr = dataset.clone();
        int[] mergeArr = dataset.clone();

        // Measure Heap Sort time
        long heapStart = System.nanoTime();
        HeapSort.heapSort(heapArr);
        long heapEnd = System.nanoTime();
        System.out.println("Heap Sort Time: " + (heapEnd - heapStart) + " ns");

        // Measure Quick Sort time
        long quickStart = System.nanoTime();
        QuickSort.quickSort(quickArr, 0, quickArr.length - 1);
        long quickEnd = System.nanoTime();
        System.out.println("Quick Sort Time: " + (quickEnd - quickStart) + " ns");

        // Measure Merge Sort time
        long mergeStart = System.nanoTime();
        MergeSort.mergeSort(mergeArr, mergeArr.length);
        long mergeEnd = System.nanoTime();
        System.out.println("Merge Sort Time: " + (mergeEnd - mergeStart) + " ns");

        // Print sorted arrays (optional)
        System.out.println("Heap Sorted Array: " + Arrays.toString(heapArr));
        System.out.println("Quick Sorted Array: " + Arrays.toString(quickArr));
        System.out.println("Merge Sorted Array: " + Arrays.toString(mergeArr));
    }
}
