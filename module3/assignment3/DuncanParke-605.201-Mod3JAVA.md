# Module Two - Assignment Submission

## The Assignment

This assignment tasks the programmer with two challenges:

1. Create a program which outputs a pyramid of asterisks
2. Create a program that implements a guessing game where the user inputs a number, n, which is used as the maximum for a range of numbers from which a random number is generated. The user then inputs how many guesses they want to have, and then tries until they either get it right or fails 

## Design

### Asterisk Printer

The asterisk printer program is a fairly simple one. We will need the following components: 

1. A mechanism to get the number of asterisks they want to print at the maximum line, and if they want it to be printed first or last
2. Some mechanism to do the printing

The method to get the input values can simply be a java scanner, and the mechanism to do the printing can just be a nested for loop which will execute to print aw number of asterisks on the corresponding line. This will be done using either an incrementing or decrementing counter, depending on if its ascending or descending

### Guess That Number

The, as I'm calling it, Guess That Number, is also a straightforward program with a design that's something like this:

1. Enter a loop that will keep running the program until the user is done
2. Get the range of numbers from which to generate the number, and the number of guesses they want
3. Generate the random number in that range
4. Enter a loop that allows the guesser to enter guesses until they've guessed more than allowed.
    1. If they don't guess in the allowed number, fail them. 
5. In the loop, Get inputs from the user, and check them against the generated number
    1. If equal, end the game and print "correct"
    2. If less, print "too little"
    3. If more, print "too large"
6. When the loop ends, ask them if they want to play again.
    1. If they do, keep going and reset the number of guesses to 0 and let the loop go back
    2. If they don't, end

## Implementation

### AsteriskPrinter.java

``` java
/** 
 * Asterick Printer 
 * 
 * This Program takes in a number and prints that many asterisks in either ascending or descending order
 * 
 * @author: Duncan Parke
 */

package module3.assignment3;
import java.util.Scanner;

public class AsteriskPrinter {
    /*
     * Program Entry Point
     */
    public static void main(String[] args) { 
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of asterisks to print: ");
        int n = scanner.nextInt();
        System.out.print("Enter whether to print ascending or descending (1/2)"); 
        int choice = scanner.nextInt();
        scanner.close();

        // Display asterisks in ascending order
        switch (choice) 
        {
            case 1: 
                for (int i = 0; i < n; i++) { 
                    for (int j = 0; j <= i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                } 
                break;
            
            case 2:
                for (int i = n; i > 0; i--) { 
                    for (int j = 0; j < i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;

            default:
                System.out.println("Invalid input");
                break;
        } // end switch (choice).
    } // end main() 
} // end class AsteriskPrinter
```

### GuessThatNumber.java

``` java
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
        int guess = 0; 
        Scanner input = new Scanner(System.in);
        // Start the game 
        System.out.println("Welcome to Guess That Number!");
        System.out.println("The game where for some reason you you give me a" 
            + "range of numbers and a number of guesses, and I generate a" 
            +  "number for you to guess.");
        System.out.println("If you guess the number, you win! If you don't" 
            + ", you lose. It's that simple.");
        System.out.println("Let's get started!");
        System.out.println("");

        // Get the user's input
        while (keep_playing == 1) {
            System.out.println("How many guesses would you like to have? "
                + "Guesses: "); 
            max_guesses = input.nextInt();
            System.out.println("What is the maximum number you would like to" 
            + " guess? Maximum Number: ");
            range = input.nextInt();

            // Generate the number 
            number = (int) (Math.random() * range) + 1;
            System.out.println("I have generated a number between 1 and " 
                + range + ". What is your guess?");
            
            // Start the guessing loop
            while(guess_num < max_guesses) {
                guess = input.nextInt();
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
            if(guess_num == max_guesses && guess != number) {
                System.out.println("You have run out of guesses." 
                    + "The number was " + number);
            }
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
```

## Output

Please see the attached logs
