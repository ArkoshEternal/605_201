/*
 * Guess That Number
 *  
 * This is the implementation of a program that asks a user to give a maximum 
 * number of guesses and a maximum number of the range of numbers to guess from. 
 * 
 * It then generates a random number within the range and asks the user to guess
 * the number. The user has a maximum number of guesses to guess the number, and
 * the program responds with whether the guess was too high, too low, or correct.
 * 
 * If allows the user to play again if they want to.
 * 
 * @author: Duncan Parke
 */

package module3.assignment3;
import java.util.Scanner;

public class GuessThatNumber {
    /*
     * Program Entry Point
     */
    public static void main(String[] args) { 
        // Declare and Initialize Vars
        int max_guesses = 0;
        int range = 0;
        int number = 0;
        int guess_num = 0;
        int keep_playing = 1; 
        Scanner input = new Scanner(System.in);
        // Start the game 
        System.out.println("Welcome to Guess That Number!");
        System.out.println("The game where for some reason you you give me a range of numbers and a number of guesses, and I generate a number for you to guess.");
        System.out.println("If you guess the number, you win! If you don't, you lose. It's that simple.");
        System.out.println("Let's get started!");
        System.out.println("");

        // Get the user's input
        while (keep_playing == 1) {
            System.out.println("How many guesses would you like to have? Guesses: "); 
            max_guesses = input.nextInt();
            System.out.println("What is the maximum number you would like to guess? Maximum Number: ");
            range = input.nextInt();

            // Generate the number 
            number = (int) (Math.random() * range) + 1;
            System.out.println("I have generated a number between 1 and " + range + ". What is your guess?");

            // Start the guessing loop
            while(guess_num < max_guesses) {
                int guess = input.nextInt();
                guess_num++;
                if (guess == number) {
                    System.out.println("correct");
                    break;
                } else if (guess < number) {
                    System.out.println("too low");
                } else {
                    System.out.println("too high");
                } 
            } // end while (guess_num < max_guesses)

            // Ask the user if they want to play again
            System.out.println("Would you like to play again? (yes/no)");
            String play_again = input.next();
            if (play_again.equals("no")) {
                keep_playing = 0;
                input.close(); 
            } else if (play_again.equals("yes")) {
                guess_num = 0;
            } else {
                System.out.println("Invalid input. Exiting game.");
                keep_playing = 0;
                input.close();
            }
        } // end while (keep_playing == 1)
    } // end main()
} // end class GuessThatNumber
