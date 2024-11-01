package Functions;

import java.util.Scanner;

public class SumOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter the second number:");
        int b = scanner.nextInt();
        int sum = sumOfTwo(a, b);
        System.out.println("The sum of " + a + " and " + b + " is " + sum);
    }

    public static int sumOfTwo(int num1, int num2) {
        return num1 + num2;
    }

}
