import java.util.LinkedList;
import java.util.Queue;

class OrderQueue {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int MAX_SIZE = 10;

    public synchronized void addOrder(int order) throws InterruptedException {
        while (queue.size() == MAX_SIZE) {
            wait();
        }
        queue.add(order);
        notifyAll();
    }

    public synchronized int getOrder() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int order = queue.poll();
        notifyAll();
        return order;
    }
}

class Chef implements Runnable {
    private final OrderQueue orderQueue;

    public Chef(OrderQueue orderQueue) {
        this.orderQueue = orderQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 15; i++) {
                int order = orderQueue.getOrder();
                System.out.println("Chef is preparing order " + order);
                Thread.sleep(3000);
                System.out.println("Chef has prepared order " + order);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Waiter implements Runnable {
    private final OrderQueue orderQueue;

    public Waiter(OrderQueue orderQueue) {
        this.orderQueue = orderQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 15; i++) {
                int order = i + 1;
                orderQueue.addOrder(order);
                System.out.println("Waiter has taken order " + order);
                Thread.sleep(2000);
                System.out.println("Waiter has delivered order " + order);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class q2 {
    public static void main(String[] args) {
        OrderQueue orderQueue = new OrderQueue();
        Thread chefThread = new Thread(new Chef(orderQueue));
        Thread waiterThread = new Thread(new Waiter(orderQueue));

        chefThread.start();
        waiterThread.start();

        try {
            chefThread.join();
            waiterThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
