import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AlphabetWarGame {
    private Map<Character, Integer> leftStrengths;
    private Map<Character, Integer> rightStrengths;

    // Default constructor
    public AlphabetWarGame() {
        leftStrengths = new HashMap<>();
        rightStrengths = new HashMap<>();
    }

    // Constructor to accept custom strengths
    public AlphabetWarGame(Map<Character, Integer> leftStrengths, Map<Character, Integer> rightStrengths) {
        this.leftStrengths = leftStrengths;
        this.rightStrengths = rightStrengths;
    }

    // Method to input strengths from the user
    public void inputStrengths() {
        try (Scanner scanner = new Scanner(System.in)) {
            // Input strengths for left-side letters
            System.out.println("Enter strengths for left-side letters (format: letter strength):");
            for (int i = 0; i < 4; i++) {
                String input = scanner.nextLine();
                String[] parts = input.split(" ");
                char letter = parts[0].charAt(0);
                int strength = Integer.parseInt(parts[1]);
                leftStrengths.put(letter, strength);
            }

            // Input strengths for right-side letters
            System.out.println("Enter strengths for right-side letters (format: letter strength):");
            for (int i = 0; i < 4; i++) {
                String input = scanner.nextLine();
                String[] parts = input.split(" ");
                char letter = parts[0].charAt(0);
                int strength = Integer.parseInt(parts[1]);
                rightStrengths.put(letter, strength);
            }
        }
    }

    // Method to evaluate the battle with one word
    public String AlphabetWar(String word) {
        return determineWinner(word, "");
    }

    // Method to evaluate the battle with separate left and right words
    public String AlphabetWar(String leftWord, String rightWord) {
        return determineWinner(leftWord, rightWord);
    }

    // Helper method to determine the winner
    private String determineWinner(String leftWord, String rightWord) {
        int leftScore = calculateScore(leftWord, leftStrengths);
        int rightScore = calculateScore(rightWord, rightStrengths);

        if (leftScore > rightScore) {
            return "Left side wins!";
        } else if (rightScore > leftScore) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    // Method to calculate the score based on word and strengths
    private int calculateScore(String word, Map<Character, Integer> strengths) {
        int score = 0;
        for (char c : word.toCharArray()) {
            score += strengths.getOrDefault(c, 0); // Default to 0 if letter is not found
        }
        return score;
    }

    // Main method for testing the game
    public static void main(String[] args) {
        AlphabetWarGame game = new AlphabetWarGame();

        // Input strengths for left and right teams
        game.inputStrengths();

        // Sample test cases
        System.out.println(game.AlphabetWar("z")); // Right side wins! (Depends on input)
        System.out.println(game.AlphabetWar("zdqmwpbs")); // Let's fight again! (Depends on input)
        System.out.println(game.AlphabetWar("wwwwwwz")); // Left side wins! (Depends on input)

        // Example with customizable strengths (if needed)
        /*
         * Map<Character, Integer> customLeft = new HashMap<>();
         * customLeft.put('w', 5);
         * customLeft.put('p', 2);
         * customLeft.put('b', 3);
         * customLeft.put('s', 1);
         * 
         * Map<Character, Integer> customRight = new HashMap<>();
         * customRight.put('m', 3);
         * customRight.put('q', 4);
         * customRight.put('d', 2);
         * customRight.put('z', 1);
         * 
         * AlphabetWarGame customGame = new AlphabetWarGame();
         * customGame.leftStrengths = customLeft;
         * customGame.rightStrengths = customRight;
         * System.out.println(customGame.AlphabetWar("wwp")); // Left side wins!
         * (Depends on custom strengths)
         * System.out.println(customGame.AlphabetWar("zqm")); // Right side wins!
         * (Depends on custom strengths)
         */
    }
}
