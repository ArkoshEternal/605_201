package module6;

import java.util.Scanner; 

public class assignmentSix {
    // Program entry point
    public static void main(String[] args) {
        // Declare and initialize variables
        // Prompt user to start the program 
        System.out.println("Welcome to employee manager 3000!");
        System.out.println("Please enter the number of employees you would like to enter: ");
        Scanner input = new Scanner(System.in);
        int numEmployees = input.nextInt();
        input.nextLine(); // Consume newline
        employee[] employees = new employee[numEmployees];

        // Create an instance of assignmentSix
        assignmentSix instance = new assignmentSix();

        // Loop through and get employee data
        for (int i = 0; i < numEmployees; i++) {
            System.out.println("Enter employee " + (i + 1) + " data: ");
            employees[i] = instance.getEmployee(input);
        }

        // Print out employee data
        System.out.println("Employee data entered: ");
        for (int i = 0; i < numEmployees; i++) {
            System.out.println("\nEmployee " + (i + 1) + ": ");
            System.out.println(employees[i].toString());
        }
        // Close the scanner
        input.close();
        System.out.println("Thank you for using employee manager 3000!");
        System.out.println("Goodbye!");
    } // end main

    // Method which gets employee data from standard in
    private employee getEmployee(Scanner input) { 

        employee toReturn; 
        name name; 
        address address;
        date birthday;
        int employeeNumber;

        // Get Employee Name
        System.out.print("Enter employee name.\n");
        System.out.print("First Name: "); 
        String firstName = input.nextLine();
        System.out.print("Last Name: ");
        String lastName = input.nextLine(); 
        name = new name(firstName, lastName); 

        // Get Employee ID
        System.out.print("Enter employee ID: "); 
        employeeNumber = input.nextInt();
        input.nextLine(); // Consume newline

        // Get Address
        System.out.print("Enter employee address.\n Street: ");
        String street = input.nextLine();
        System.out.print(" City: ");
        String city = input.nextLine();
        System.out.print(" State: ");
        String state = input.nextLine(); 
        System.out.print(" Zip: ");
        int zip = input.nextInt(); 

        address = new address(street, city, state, zip);

        // Get Birthday
        System.out.print("Enter employee birthday. MM/DD/YYYY\n Month: ");
        int month = input.nextInt();
        System.out.print(" Day: ");
        int day = input.nextInt();
        System.out.print(" Year: ");
        int year = input.nextInt();
        birthday = new date(day, month, year);
        input.nextLine(); // Consume newline

        // Make Employee and Return 
        toReturn = new employee(name, address, birthday, employeeNumber); 
        
        return toReturn;
    }   // end getEmployee
} // end class assignmentSix