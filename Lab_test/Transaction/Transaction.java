package Transaction;

import java.util.Scanner;
import java.util.ArrayList;

interface TransactionAnalyzer {
    String countPairsWithSum(int[] arr, int target);

}

public class Transaction implements TransactionAnalyzer {
    public String countPairsWithSum(int[] arr, int target) {
        ArrayList<String> PairsList = new ArrayList<>();
5
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i != j && arr[i] + arr[j] == target) {

                    PairsList.add("(" + arr[i] + " ," + arr[j] + ")");
                    System.out.println("(" + arr[i] + " ," + arr[j] + ")");
                }

            }
        }
        return PairsList.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Transaction analyzer = new Transaction();

        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Enter the target sum:");
        int target = scanner.nextInt();

        System.out.println("Output: " + "( Pairs :" + analyzer.countPairsWithSum(arr, target) + ")");
    }
}
