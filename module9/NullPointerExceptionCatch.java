package module9;

// Program which catches a NullPointerException exception
// and prints a message to the console identifying the exception

public class NullPointerExceptionCatch {

    // program entry point
    public static void main(String[] args) {
        // Declare a variable of type String
        String str = null;
        // Attempt to access the length of the null string
        try {
            int length = str.length();
        } 
        catch (NullPointerException e) {
            // Print a message to the console
            System.out.println("Caught a NullPointerException");
        } // end try-catch
    } // end main
} // end class NullPointerExceptionCatch
