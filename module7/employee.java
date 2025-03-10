package module7;

/**
 * The Employee class represents an employee with basic information
 * such as name, address, birthday, and employee number. This class 
 * provides getter and setter methods for the attributes and includes 
 * an overridden toString method for displaying the employee's details.
 */

public class employee {
    // Constructor
    public employee(name name, address address, date birthday, int employeeNumber) {
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        this.employeeNumber = employeeNumber;
    }

    // Getters
    public name getName() {
        return name;
    }

    public address getAddress() {
        return address;
    }

    public date getBirthday() {
        return birthday;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    // Setters
    public void setName(name name) {
        this.name = name;
    }

    public void setAddress(address address) {
        this.address = address;
    }

    public void setBirthday(date birthday) {
        this.birthday = birthday;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    // toString method
    public String toString() {
        return "Name: " + name.toString() + "\n" +
               "Address: " + address.toString() + "\n" +
               "Birthday: " + birthday.getDay() + "/" + birthday.getMonth() + "/" + birthday.getYear() + "\n" +
               "Employee Number: " + employeeNumber;
    }

    // equals method
    public boolean equals(employee other) {
        if(other == null) {
            return false;
        }
        return this.name.equals(other.name) && 
               this.address.equals(other.address) && 
               this.birthday.equals(other.birthday) && 
               this.employeeNumber == other.employeeNumber;
    }
    
    // Class Members
    protected name name; 
    protected address address;
    protected date birthday;
    protected int employeeNumber; 
} // end class employee
