package module9;

// Class which intentionally throws a ClassCastException

public class ClassCastExceptionThrown {

    // program entry point
    public static void main(String[] args) {
        // Create an object of type Object
        Object obj = new Object();
        // Attempt to cast the object to a String
        String str = (String) obj;
    } // end main
    
} // end class ClassCastExceptionThrown
