import java.util.*;

public class TopKFrequent {
    // Static variable to store the input array
    static int[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int N = scanner.nextInt();
        numbers = new int[N];

        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Enter the value of K: ");
        int K = scanner.nextInt();

        System.out.println("Top " + K + " numbers: " + Arrays.toString(findTopKFrequent(K)));

        scanner.close();
    }

    // Static method to find top K frequent numbers
    public static int[] findTopKFrequent(int K) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count frequency of each number
        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create a list from the frequency map
        List<Map.Entry<Integer, Integer>> frequencyList = new ArrayList<>(frequencyMap.entrySet());

        // Sort the list by frequency (descending) and then by value (descending)
        frequencyList.sort((a, b) -> {
            int freqCompare = Integer.compare(b.getValue(), a.getValue());
            return (freqCompare != 0) ? freqCompare : Integer.compare(b.getKey(), a.getKey());
        });

        // Prepare the result array
        int[] result = new int[K];
        for (int i = 0; i < K; i++) {
            result[i] = frequencyList.get(i).getKey();
        }

        return result;
    }
}
