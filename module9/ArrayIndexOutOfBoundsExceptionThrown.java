package module9;

// Class which intentionally throws an ArrayIndexOutOfBoundsException

public class ArrayIndexOutOfBoundsExceptionThrown {
    
    // Program entry point

    public static void main(String[] args) {
        // Array of size 5
        int[] arr = new int[5];
        // Accessing the 6th element
        System.out.println(arr[6]);
    } // end main 
} // end class ArrayIndexOutOfBoundsExceptionThrown
