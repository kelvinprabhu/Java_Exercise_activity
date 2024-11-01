package Functions;

import java.util.*;

public class Factorial {
    public static void main(String[] args) {
        int number = 5;
        long factorial = factorial(number);
        System.out.println("The factorial of " + number + " is" + factorial);
    }

    public static long factorial(int number) {
        long result = 1;
        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
            System.out.println(result);
        }
        return result;
    }
}
