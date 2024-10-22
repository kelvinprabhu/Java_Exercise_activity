import java.util.*;

public class TopKFrequentNumbersFinder {

    // Static variable to store the input array of N numbers
    private static int[] numbers;

    // Static method to find the top K numbers with the highest occurrences
    public static void findTopKFrequentNumbers(int K) {
        // Frequency map to store the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Priority queue to store the numbers based on their frequency and value
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue()) ? b.getKey() - a.getKey() : b.getValue() - a.getValue());

        // Add all entries from the frequency map to the priority queue
        pq.addAll(frequencyMap.entrySet());

        // Extract the top K elements from the priority queue
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            result.add(pq.poll().getKey());
        }

        // Print the result in descending order
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test case 1
        numbers = new int[] { 3, 1, 4, 4, 5, 2, 6, 1 };
        findTopKFrequentNumbers(2); // Output: 4 1

        // Test case 2
        numbers = new int[] { 7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9 };
        findTopKFrequentNumbers(4); // Output: 5 11 7 10
    }
}

class ShareTrader {

    // Static variable to store the maximum profit
    private static int maxProfit;

    // Static method to find the maximum profit with at most 2 transactions
    public static void findMaxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return;

        // Arrays to store the maximum profit up to day i
        int[] profit1 = new int[n];
        int[] profit2 = new int[n];

        // Calculate the maximum profit with one transaction
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            profit1[i] = Math.max(profit1[i - 1], prices[i] - minPrice);
        }

        // Calculate the maximum profit with two transactions
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            profit2[i] = Math.max(profit2[i + 1], maxPrice - prices[i]);
        }

        // Calculate the maximum profit with at most two transactions
        maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, profit1[i] + profit2[i]);
        }

        // Print the maximum profit
        System.out.println(maxProfit);
    }

    public static void main(String[] args) {
        // Test case 1
        int[] prices1 = { 10, 22, 5, 75, 65, 80 };
        findMaxProfit(prices1); // Output: 87

        // Test case 2
        int[] prices2 = { 2, 30, 15, 10, 8, 25, 80 };
        findMaxProfit(prices2); // Output: 100
    }
}