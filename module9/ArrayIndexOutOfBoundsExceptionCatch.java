package module9;

// Program which catches an ArrayIndexOutOfBoundsException exception
// and prints a message to the console identifying the exception

public class ArrayIndexOutOfBoundsExceptionCatch {
    
    // program entry point
    public static void main(String[] args) {
        // Array of size 5
        int[] arr = new int[5];
        try {
            // Accessing the 6th element
            System.out.println(arr[6]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Print a message to the console
            System.out.println("Caught an ArrayIndexOutOfBoundsException");
        } // end try-catch
    } // end main
} // end class ArrayIndexOutOfBoundsExceptionCatch
