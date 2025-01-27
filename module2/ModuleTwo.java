/** 
 * Assignment Two
 * 
 * This program takes in height and weight in inches and pounds to calculate BMI and return it
 * 
 * @author: Duncan Parke
 */
package test;

import java.util.Scanner;

// Class which takes in height and weight, and outputs BMI 
public class ModuleTwo 
{ 
    /*
     * Program Entry Point
     */
    public static void main(String[] args)
   {
        // Declare and Initialize Collected Vars
        int height = 0; // in inches
        int weight = 0; // in lbs 
        double metricWeight, metricHeight;
        
        // Declare and Initialize Consts
        // Over declared to not worry about 
        final double KGPLBS = 0.45359237; 
        final double MPIN = 0.0254; 
 
        // Use Scanner to get vars from user
        Scanner input = new Scanner(System.in); 
        System.out.print("Please enter a weight (in pounds): ");
        weight = input.nextInt(); // Get weight 
        System.out.print("\nPlease enter a height (in inches): "); 
        height = input.nextInt(); // Get height 

        // Calculate BMI 
        metricWeight = weight * KGPLBS; 
        metricHeight = height * MPIN; 

        // Report BMI to user 
        System.out.println(""); 
        System.out.println("Your BMI is: " + metricWeight/(metricHeight * metricHeight)); 

        // Report DHHS / NIH stuff
        System.out.println("");
        System.out.println("\t Underweight: less than 18.5");
        System.out.println("\t     Normal: 18.5 – 24.9");
        System.out.println("\t    Overweight: 25 – 29.9");
        System.out.println("\t     Obese: 30 or greater");
        System.out.println(""); 
   } // end main()
} // end ModuleTwo