package module7;

// Class which implements the test of the employees

public class testEmployee {
    public static void main(String[] args) {
        // Create a salaried employee
        salariedEmployee salariedEmployee = new salariedEmployee(
            new name("John", "Doe"),
            new address("123 Main St", "Baltimore", "CA", 21218),
            new date(1, 1, 1975),
            1,
            50000
        );

        // Create two hourly employees
        hourlyEmployee hourlyEmployee1 = new hourlyEmployee(
            new name("Jane", "Smith"),
            new address("456 Oak St", "Boston", "MA", 67890),
            new date(2, 2, 1975),
            2,
            20,
            35
        );

        hourlyEmployee hourlyEmployee2 = new hourlyEmployee(
            new name("Bob", "Johnson"),
            new address("789 Pine St", "Watertown", "FL", 11223),
            new date(3, 3, 1975),
            3,
            20,
            45
        );

        // Display attributes for the salaried employee
        System.out.println("Salaried Employee:");
        System.out.println(salariedEmployee);
        System.out.println();

        // Display attributes for the first hourly employee
        System.out.println("Hourly Employee 1:");
        System.out.println(hourlyEmployee1);
        System.out.println();

        // Display attributes for the second hourly employee
        System.out.println("Hourly Employee 2:");
        System.out.println(hourlyEmployee2);
    }
} // end class TestEmployee