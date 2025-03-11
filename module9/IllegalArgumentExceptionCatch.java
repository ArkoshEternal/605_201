package module9;

// Program which catches an IllegalArgumentException exception
// and prints a message to the console identifying the exception

public class IllegalArgumentExceptionCatch {
    // program entry point
    public static void main(String[] args) { 
        try {
            int[] numbers = new int[-5]; // This will throw NegativeArraySizeException
        } catch (NegativeArraySizeException e) {
            System.out.println("Caught an exception: " + e);
        }

    } // end main
} // end class IllegalArgumentExceptionCatch