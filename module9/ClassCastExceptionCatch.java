package module9;

// Class which handles a ClassCastException exception
// and prints a message to the console identifying the exception

public class ClassCastExceptionCatch {
    // program entry point
    public static void main(String[] args) {
        // Create an object of type Object
        Object obj = new Object();
        try {
            // Attempt to cast the object to a String
            String str = (String) obj;
        } catch (ClassCastException e) {
            // Print a message to the console
            System.out.println("Caught a ClassCastException");
        } // end try-catch
    } // end main    
} // end class ClassCastExceptionCatch
