package module7;

// Class HourlyEmployee

/**

* The HourlyEmployee class extends the Employee class and represents 

 * an employee who is paid hourly. This class contains additional attributes

 * for hourly pay rate, hours worked, and earnings. It includes a method 

 * to calculate earnings, including overtime pay for hours worked beyond 40.

 */

public class hourlyEmployee extends employee {


    /**
     * Constructor to initialize an HourlyEmployee object with the given attributes.
     * 
     * @param name The name of the employee.
     * @param address The address of the employee.
     * @param birthday The birthdate of the employee.
     * @param employeeNumber The employee's unique identifier.
     * @param hourlyPayRate The hourly pay rate for the employee.
     */
    public hourlyEmployee(name name, address address, date birthday, int employeeNumber, double hourlyWage, int hoursWorked) {
        super(name, address, birthday, employeeNumber);
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
        this.earnings =  this.getEarnings();
    }

    // Getters
    public double getHourlyWage() {
        return hourlyWage;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    // Method to calulate earnings per the hourly wage and hours worked
    // If hours worked is greater than 40, calculate overtime pay
    public double getEarnings() {
        if (hoursWorked <= 40) {
            earnings = hourlyWage * hoursWorked;
        } else {
            earnings = (hourlyWage * 40) + ((hoursWorked - 40) * hourlyWage * 1.5);
        }
        return earnings;
    }

    // Setters
    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    // toString method
    public String toString() {
        return super.toString() + "\n" +
               "Hourly Wage: " + hourlyWage + "\n" +
               "Hours Worked: " + hoursWorked;
    }

    // Class Members
    private double hourlyWage;
    private int hoursWorked;
    private double earnings; 
    
} // end class hourlyEmployee
