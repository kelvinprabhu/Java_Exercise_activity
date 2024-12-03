package Lab_6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class CounterEmptyException extends Exception {
    public CounterEmptyException(String message) {
        super(message);
    }
}

class CoffeeCounter {
    private final int capacity;
    private final Queue<String> counter = new LinkedList<>();

    public CoffeeCounter(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void addCoffee(String coffee) throws InterruptedException {
        while (counter.size() == capacity) {
            wait();
        }
        counter.add(coffee);
        System.out.println("Added: " + coffee);
        notifyAll();
    }

    public synchronized String takeCoffee() throws InterruptedException, CounterEmptyException {
        while (counter.isEmpty()) {
            wait();
        }
        String coffee = counter.poll();
        if (coffee == null) {
            throw new CounterEmptyException("Counter is empty!");
        }
        System.out.println("Taken: " + coffee);
        notifyAll();
        return coffee;
    }

    public synchronized String sampleCoffee() throws InterruptedException, CounterEmptyException {
        while (counter.isEmpty()) {
            wait();
        }
        String coffee = counter.peek();
        if (coffee == null) {
            throw new CounterEmptyException("Counter is empty!");
        }
        System.out.println("Sampled: " + coffee);
        notifyAll();
        return coffee;
    }
}

class Barista implements Runnable {
    private final CoffeeCounter counter;
    private final int coffeeCount;
    private final String name;

    public Barista(CoffeeCounter counter, int coffeeCount, String name) {
        this.counter = counter;
        this.coffeeCount = coffeeCount;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < coffeeCount; i++) {
                counter.addCoffee(name + " Coffee " + (i + 1));
                Thread.sleep(100); // Simulate time taken to prepare coffee
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Customer implements Runnable {
    private final CoffeeCounter counter;
    private final int coffeeCount;
    private final String name;

    public Customer(CoffeeCounter counter, int coffeeCount, String name) {
        this.counter = counter;
        this.coffeeCount = coffeeCount;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < coffeeCount; i++) {
                counter.takeCoffee();
                Thread.sleep(150); // Simulate time taken to pick up coffee
            }
        } catch (InterruptedException | CounterEmptyException e) {
            System.out.println(name + ": " + e.getMessage());
        }
    }
}

class CoffeeReviewer implements Runnable {
    private final CoffeeCounter counter;
    private final String name;

    public CoffeeReviewer(CoffeeCounter counter, String name) {
        this.counter = counter;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(200)); // Random delay before sampling
            counter.sampleCoffee();
        } catch (InterruptedException | CounterEmptyException e) {
            System.out.println(name + ": " + e.getMessage());
        }
    }
}

public class Q2 {
    public static void main(String[] args) {
        CoffeeCounter counter = new CoffeeCounter(3);

        Thread barista1 = new Thread(new Barista(counter, 2, "Barista 1"));
        Thread barista2 = new Thread(new Barista(counter, 3, "Barista 2"));
        Thread customer1 = new Thread(new Customer(counter, 1, "Customer 1"));
        Thread customer2 = new Thread(new Customer(counter, 2, "Customer 2"));
        Thread customer3 = new Thread(new Customer(counter, 1, "Customer 3"));
        Thread reviewer = new Thread(new CoffeeReviewer(counter, "Reviewer"));

        barista1.start();
        barista2.start();
        customer1.start();
        customer2.start();
        customer3.start();
        reviewer.start();
    }
}