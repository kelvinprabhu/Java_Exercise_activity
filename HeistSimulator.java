import java.util.Scanner;

// Abstract class for Robber logic
abstract class Thief {
    // Abstract methods
    public abstract void displaySpecialization();

    public abstract int robLinearHomes(int[] homes);

    public abstract int robCircularHomes(int[] homes);

    public abstract int robSquareHomes(int[] homes);

    public abstract int robApartmentComplex(int[] homes);

    // Default method
    public void favoriteTech() {
        System.out.println("AI and Data Science are fascinating fields.");
    }
}

// Concrete class implementing the abstract methods
class AIThiefSpecialist extends Thief {
    @Override
    public void displaySpecialization() {
        System.out.println("Mastering AI & Cybersecurity!");
    }

    @Override
    public int robLinearHomes(int[] homes) {
        if (homes.length == 0)
            return 0;
        if (homes.length == 1)
            return homes[0];
        int previous1 = 0, previous2 = 0;
        for (int wealth : homes) {
            int temp = previous1;
            previous1 = Math.max(previous1, previous2 + wealth);
            previous2 = temp;
        }
        return previous1;
    }

    @Override
    public int robCircularHomes(int[] homes) {
        if (homes.length == 0)
            return 0;
        if (homes.length == 1)
            return homes[0];
        return Math.max(helperFunction(homes, 0, homes.length - 2), helperFunction(homes, 1, homes.length - 1));
    }

    private int helperFunction(int[] homes, int start, int end) {
        int previous1 = 0, previous2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = previous1;
            previous1 = Math.max(previous1, previous2 + homes[i]);
            previous2 = temp;
        }
        return previous1;
    }

    @Override
    public int robSquareHomes(int[] homes) {
        return robLinearHomes(homes); // Same logic as linear homes
    }

    @Override
    public int robApartmentComplex(int[] homes) {
        return robLinearHomes(homes); // Same logic as linear homes
    }
}

public class HeistSimulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AIThiefSpecialist specialist = new AIThiefSpecialist();

        boolean isRunning = true;

        // Demonstrate default methods
        specialist.displaySpecialization();
        specialist.favoriteTech();

        while (isRunning) {
            System.out.println("\nChoose the type of property to calculate maximum loot:");
            System.out.println("1. Linear Homes");
            System.out.println("2. Circular Homes");
            System.out.println("3. Square Homes");
            System.out.println("4. Apartment Complex");
            System.out.println("5. Exit");

            int option = input.nextInt();

            if (option == 5) {
                System.out.println("Ending simulation. Goodbye!");
                break;
            }

            System.out.println("Enter the number of properties:");
            int numProperties = input.nextInt();
            int[] wealthInHomes = new int[numProperties];
            System.out.println("Enter the wealth in each property:");
            for (int i = 0; i < numProperties; i++) {
                wealthInHomes[i] = input.nextInt();
            }

            int maxLoot = 0;
            switch (option) {
                case 1:
                    maxLoot = specialist.robLinearHomes(wealthInHomes);
                    System.out.println("Max loot from Linear Homes: " + maxLoot);
                    break;
                case 2:
                    maxLoot = specialist.robCircularHomes(wealthInHomes);
                    System.out.println("Max loot from Circular Homes: " + maxLoot);
                    break;
                case 3:
                    maxLoot = specialist.robSquareHomes(wealthInHomes);
                    System.out.println("Max loot from Square Homes: " + maxLoot);
                    break;
                case 4:
                    maxLoot = specialist.robApartmentComplex(wealthInHomes);
                    System.out.println("Max loot from Apartment Complex: " + maxLoot);
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }

            // Check if user wants to repeat
            System.out.println("\nWould you like to try another property type? (yes/no)");
            String answer = input.next();
            if (!answer.equalsIgnoreCase("yes")) {
                isRunning = false;
            }
        }

        input.close();
    }
}
