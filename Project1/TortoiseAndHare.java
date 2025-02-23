/*
 * Tortoise and Hare is an implementation of the Tortoise and Hare race from 
 * Aesop's Fables. The program simulates the race between the tortoise and the
 * hare, and determines the winner based on the distance traveled by each animal.
 * 
 * The finish line is 100 units away, and they move at speeds (units/cycle) which 
 * is determined by the following rules: 
 * 
 * Contender | Type of Move | Probability | Result 
 * Tortoise  | Fast Plod    | 50%         | +3 units
 *           | Slow Plod    | 30%         | +1 units
 *           | Slip         | 20%         | -6 units
 * Hare      | Big Hop      | 20%         | +9 units
 *           | Small Hop    | 30%         | +1 units
 *           | Big Slip     | 10%         | -12 units
 *           | Small Slip   | 20%         | -2 units 
 *           | Fall Asleep  | 20%         | 0 units 
 */      
package Project1;

public class TortoiseAndHare {
    /*
     * Program Entry Point
     */
    public static void main(String[] args) { 

        // Declare and Initialize Vars
        int tortoise_position = 1; 
        int hare_position = 1;

        System.out.println("AND THEY'RE OFF!!");

        // Play the game
        while(tortoise_position <= 100 && hare_position <= 100) {
            // Move the tortoise
            int tortoise_move = (int) (Math.random() * 10) + 1;
            if (tortoise_move <= 5) {
                tortoise_position += 3;
            } else if (tortoise_move <= 8) {
                tortoise_position += 1;
            } else {
                tortoise_position -= 6;
            }

            // Move the hare
            int hare_move = (int) (Math.random() * 10) + 1;
            if (hare_move <= 2) {
                hare_position += 9;
            } else if (hare_move <= 5) {
                hare_position += 1;
            } else if (hare_move <= 6) {
                hare_position -= 12;
            } else if (hare_move <= 8) {
                hare_position -= 2;
            } else {
                hare_position += 0;
            }

            if (hare_position < 1) {
                hare_position = 1;
            }

            if (tortoise_position < 1) {
                tortoise_position = 1;
            }

            // Display
            for(int i = 0; i < 100; i++) {
                if (i == tortoise_position && i == hare_position) {
                    System.out.print("OUCH!!!");
                } else if (i == tortoise_position) {
                    System.out.print("T");
                } else if (i == hare_position) {
                    System.out.print("H");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(); // New line
        } // end while(tortoise_position <= 100 && hare_position <= 100)

        // Determine the winner
        if (tortoise_position >= 100 && hare_position >= 100) {
            System.out.println("It's a tie!");
        } else if (tortoise_position >= 100) {
            System.out.println("TORTOISE WINS!!!");
        } else {
            System.out.println("HARE WINS!!");
        }
    } // end main()
} // end class TortoiseAndHare
