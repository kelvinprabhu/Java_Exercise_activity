import java.util.Scanner;

public class ShareTrader {
    // Static variable to store the maximum profit
    static int maxProfit;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of stock prices: ");
        int N = scanner.nextInt();
        int[] prices = new int[N];

        System.out.print("Enter the stock prices: ");
        for (int i = 0; i < N; i++) {
            prices[i] = scanner.nextInt();
        }

        System.out.println("Maximum profit: " + findMaxProfit(prices));

        scanner.close();
    }

    // Static method to find maximum profit with at most 2 transactions
    public static int findMaxProfit(int[] prices) {
        maxProfit = 0;

        // Check for edge cases
        if (prices == null || prices.length == 0) {
            return maxProfit;
        }

        // First transaction
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }

            // Second transaction after the first
            for (int k = i + 1; k < prices.length; k++) {
                for (int l = k + 1; l < prices.length; l++) {
                    maxProfit = Math.max(maxProfit, (prices[k] - prices[i]) + (prices[l] - prices[k]));
                }
            }
        }

        return maxProfit;
    }
}
