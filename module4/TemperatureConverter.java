// class TemperatureConversion
//    Performs Temperature conversion from Fahrenheit to Celsius and vice versa
//
import java.util.Scanner;

public class TemperatureConversion {
    
    // declare consts
    static final int CONVERT_TO_CELSIUS = 1; 
    static final int CONVERT_TO_FAHRENHEIT = 2; 
    static final int END_PROGRAM = 3;

    public static void main(String[] args) {
        int userChoice = 0; // User selection: 1, 2, 3
        Scanner input = new Scanner(System.in); // Create a Scanner to obtain user input

        while (userChoice != END_PROGRAM) {
            System.out.print("Enter 1 to convert F->C, 2 to convert C->F, 3 to quit: ");
            userChoice = input.nextInt(); // Read user input
            switch (userChoice) {
                case CONVERT_TO_CELSIUS:
                    fahrenheitToCelsius(input);
                    break;

                case CONVERT_TO_FAHRENHEIT:
                    celsiusToFahrenheit(input);
                    break;

                case END_PROGRAM:
                    System.out.println("Bye Bye");
                    break;

                default: // Invalid Data Entered
                    System.out.println("Invalid Data: You must enter 1, 2, or 3");
            } // end switch
        } // end while
        input.close();
    } // end main

    public static void celsiusToFahrenheit(Scanner input) { 
        System.out.print("Enter a Celsius temperature: ");
        float tempC = input.nextFloat();
        float tempF = 9F / 5F * tempC + 32F;
        System.out.println(tempC + " degrees Celsius is " + tempF + " degrees Fahrenheit");
    }

    public static void fahrenheitToCelsius(Scanner input) { 
        System.out.print("Enter a Fahrenheit temperature: ");
        float tempF = input.nextFloat();
        float tempC = 5F / 9F * (tempF - 32F);
        System.out.println(tempF + " degrees Fahrenheit is " + tempC + " degrees Celsius");
    }
} // end class TemperatureConversion