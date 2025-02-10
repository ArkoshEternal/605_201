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
