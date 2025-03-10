/**
 * Class which implements a basic name
 * 
 * Consists of a first name and a last name 
 */
package module6;

public class name {
    // vars
    private String firstName;
    private String lastName;

    // Constructor
    // Throws an error if impossible values are passed
    // Doesn't guarantee valid name
    public name(String firstName, String lastName) {
        if(firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name empty");
        }
        if(lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name empty");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Setters
    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name empty");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name empty");
        }
        this.lastName = lastName;
    }

    // toString method
    public String toString() {
        return firstName + " " + lastName;
    }

    // equals method
    public boolean equals(name other) {
        if(other == null) {
            return false;
        }
        return this.firstName.equals(other.firstName) && this.lastName.equals(other.lastName);
    }
} // end class name

