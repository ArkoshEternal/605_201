/**
 * Class which implements an american address
 * 
 * Consists of a street address, city, state, and zip code
 * and provides methods to manipulate and display the address
*/
package module7;

public class address {

    // Constructor
    // Throws an error if impossible values are passed
    // Doesn't guarantee valid address
    public address(String streetAddress, String city, String state, int zipCode) { 
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    
    // Getters 
    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }

    // Setters
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
    // toString method
    public String toString() {
        return streetAddress + "\n" + city + ", " + state + " " + zipCode;
    }
    
    // Class Members
    private String streetAddress; 
    private String city; 
    private String state; 
    private int zipCode; 
} // end class address
