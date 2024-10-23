import java.util.Scanner;

public class CreditCardValidator {
    private String ccNumber;

    public CreditCardValidator(String ccNumber) {
        this.ccNumber = ccNumber;
        try {
            Long.parseLong(ccNumber); // Ensure the input is numeric
            validateCard();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid credit card number.");
        }
    }

    public void validateCard() {
        if (ccNumber.length() >= 8 && ccNumber.length() <= 9) {
            // Step a: Extract the last digit (check digit)
            String ccWithoutCheckDigit = ccNumber.substring(0, ccNumber.length() - 1);
            int lastDigit = Character.getNumericValue(ccNumber.charAt(ccNumber.length() - 1));

            // Step b: Reverse the remaining digits
            String reversedNumber = new StringBuilder(ccWithoutCheckDigit).reverse().toString();

            // Step c and d: Perform the doubling and summing
            int sum = 0;
            for (int i = 0; i < reversedNumber.length(); i++) {
                int digit = Character.getNumericValue(reversedNumber.charAt(i));
                if (i % 2 == 0) {
                    digit *= 2;
                    if (digit > 9) {
                        digit = digit / 10 + digit % 10; // Sum the digits if > 9
                    }
                }
                sum += digit;
            }

            // Step e: Subtract the last digit from 10
            int validationResult = 10 - lastDigit;

            // Step f: Compare the result of Step e with the last digit from Step a
            if (validationResult == sum % 10) { // Correct comparison
                System.out.println("The credit card number is valid.");
            } else {
                System.out.println("The credit card number is invalid.");
            }

            // System.out.println("Credit card number after removing last digit: " +
            // ccWithoutCheckDigit);
        } else {
            System.out.println("Credit card number must be exactly 8-9  digits.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a credit card number: ");
        String ccNumber = sc.nextLine();
        new CreditCardValidator(ccNumber);
    }
}
