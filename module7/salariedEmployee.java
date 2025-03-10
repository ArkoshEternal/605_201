package module7;

// Class SalariedEmployee
/**
 * The SalariedEmployee class extends the Employee class and represents 
 * an employee with a fixed annual salary. This class provides a method 
 * to calculate the salary and displays the details of the salaried employee.
 */

public class salariedEmployee extends employee {
    // Annual fixed salary

    /**
     * Constructor to initialize a SalariedEmployee object with the given attributes.
     * 
     * @param name The name of the employee.
     * @param address The address of the employee.
     * @param birthday The birthdate of the employee.
     * @param employeeNumber The employee's unique identifier.
     * @param annualSalary The annual salary of the employee.
     */ 
    
    public salariedEmployee(name name, address address, date birthday, int employeeNumber, double salary) {
        super(name, address, birthday, employeeNumber);
        this.salary = salary;
    }

    // Getters
    public double getSalary() {
        return salary;
    }

    // Setters
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // toString method
    public String toString() {
        return super.toString() + "\n" +
               "Salary: " + salary;
    }

    // Class Members
    private double salary; 

} // end class salariedEmployee
