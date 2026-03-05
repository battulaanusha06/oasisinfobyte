 
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1; // 1 to 100
        int userGuess = 0; 
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("Try to guess it!");

        while (userGuess != secretNumber) {

            System.out.print("Enter your guess: ");
            userGuess = sc.nextInt();
            attempts++;

            if (userGuess > secretNumber) {
                System.out.println("Too high! Try again.");
            } 
            else if (userGuess < secretNumber) {
                System.out.println("Too low! Try again.");
            } 
            else {
                System.out.println("Correct! You guessed the number.");
                System.out.println("Total attempts: " + attempts);
            }
        }

        sc.close();
    }
}