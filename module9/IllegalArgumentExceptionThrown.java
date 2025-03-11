package module9;

// This class intentionally throws an IllegalArgumentException

public class IllegalArgumentExceptionThrown {
    // program entry point
    public static void main(String[] args) {
        // Create an object of type String
        int[] numbers = new int[-5]; // This will throw NegativeArraySizeException
    } // end main
} // end class IllegalArgumentExceptionThrown
