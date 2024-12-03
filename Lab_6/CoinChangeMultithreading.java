package Lab_6;

import java.util.concurrent.locks.ReentrantLock;

public class CoinChangeMultithreading {
    public static int countWays(int[] coins, int totalSum, int numThreads) {
        int[] dp = new int[totalSum + 1];
        dp[0] = 1; // Base case: one way to form sum 0
        ReentrantLock lock = new ReentrantLock();

        // Thread worker class
        class Worker extends Thread {
            private int start, end;

            Worker(int start, int end) {
                this.start = start;
                this.end = end;
            }

            @Override
            public void run() {
                for (int coin = start; coin < end && coin < coins.length; coin++) {
                    int[] localDp = new int[totalSum + 1];
                    System.arraycopy(dp, 0, localDp, 0, dp.length);
                    for (int i = coins[coin]; i <= totalSum; i++) {
                        localDp[i] += localDp[i - coins[coin]];
                    }
                    lock.lock(); // Ensure thread-safe update to dp array
                    try {
                        for (int i = coins[coin]; i <= totalSum; i++) {
                            dp[i] += localDp[i] - dp[i];
                        }
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        // Create and divide threads for computation
        int n = coins.length;
        int step = (n + numThreads - 1) / numThreads; // Divide coins array into chunks
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int start = i * step;
            int end = Math.min((i + 1) * step, n); // Ensure no out-of-bound index
            threads[i] = new Worker(start, end);
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return dp[totalSum];
    }

    public static void main(String[] args) {
        int[] coins1 = { 1, 2, 3 };
        int totalSum1 = 4;
        System.out.println("Output: " + countWays(coins1, totalSum1, 2)); // Use 2 threads

        int[] coins2 = { 2, 5, 3, 6 };
        int totalSum2 = 10;
        System.out.println("Output: " + countWays(coins2, totalSum2, 4)); // Use 4 threads
    }
}
