package module9;

// Class which generates a NullPointerException to be thrown

public class NullPointerExceptionThrown {
    
    // Program Entry Point

    public static void main(String[] args) {
        // Declare a variable of type String
        String str = null;
        // Attempt to access the length of the null string
        int length = str.length();
    } /// end function main

} // end class NullPointerExceptionThrown
