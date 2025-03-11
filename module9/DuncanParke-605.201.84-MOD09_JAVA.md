# Module Nine - Assignment Submission

## The Assignment
> This programming assignment involves learning about some of the common exceptions that occur in Java programs. Consider the following exception types:

- `NullPointerException`
- `ArrayIndexOutOfBoundsException`
- `ClassCastException`
- `IllegalArgumentException`

Research what each exception type means and the conditions under which each occurs (i.e., is thrown). Write programs that demonstrate each type of exception being thrown (one program per exception) and provide a screen capture of the output. Name your programs as follows: `NullPointerExceptionThrown`, etc.

Then, write a program that catches each type of thrown exception and displays an error message indicating some of the details as to what that exception is. Write one program per type of exception. Name your programs as follows: `NullPointerExceptionCatch`, etc.

## Design

This is again an assignment which leaves no room to the imagination for what it wants us to do.

In order to generate the exception throws, I decided to use the following methods:

For a null pointer exception, which is thrown when we try to reference a null pointer, I decided to set a string to null and then try to access its length, which is an attempt to access a null pointer.

For the array index out of bounds exception, I'm choosing to attempt to access the value of an array which is out side the bounds of the array.

For the ClassCastException, I am choosing to attempt to cast a generic Object type class to a String type.

For the IllegalArgumentException, I chose to attempt to initialize a dynamic array with a negative value

## Implementation

```java

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

package module9;

// This class intentionally throws an IllegalArgumentException

public class IllegalArgumentExceptionThrown {
    // program entry point
    public static void main(String[] args) {
        // Create an object of type String
        int[] numbers = new int[-5]; // This will throw NegativeArraySizeException
    } // end main
} // end class IllegalArgumentExceptionThrown

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
```

## Output
Screenshots: 
![idx_oob]("ArrayIndexOutOfBoundsExceptionThrown.png")
![cast]("CastClassExceptionThrown.png")
![ill_arg]("IllegalArgumentExceptionThrown.png")
![nullptr]("NullPointerExceptionThrown.png")

Outputs from Catches

```
Script started on 2025-03-11 02:11:24-04:00 [TERM="xterm-256color" TTY="/dev/pts/13" COLUMNS="248" LINES="20"]
[?2004h]0;arkosh@greyskull: ~/repos/601_201/module9[01;32markosh@greyskull[00m:[01;34m~/repos/601_201/module9[00m$ jva [K[K[Kava ArrayIndexOutOfBoundsExceptionCatch.java
[?2004l
Caught an ArrayIndexOutOfBoundsException
[?2004h]0;arkosh@greyskull: ~/repos/601_201/module9[01;32markosh@greyskull[00m:[01;34m~/repos/601_201/module9[00m$ java Ca[KlassCastExceptionThrown[K[K[K[K[K[KCatch.java
[?2004l
Caught a ClassCastException
[?2004h]0;arkosh@greyskull: ~/repos/601_201/module9[01;32markosh@greyskull[00m:[01;34m~/repos/601_201/module9[00m$ java IllegalArgumentExceptionCathc[K[Kch.java
[?2004l
Caught an exception: java.lang.NegativeArraySizeException: -5
[?2004h]0;arkosh@greyskull: ~/repos/601_201/module9[01;32markosh@greyskull[00m:[01;34m~/repos/601_201/module9[00m$ java NullPointerExceptionCatch.java
[?2004l
Caught a NullPointerException
[?2004h]0;arkosh@greyskull: ~/repos/601_201/module9[01;32markosh@greyskull[00m:[01;34m~/repos/601_201/module9[00m$ exot[K[Kit
[?2004l
exit

Script done on 2025-03-11 02:12:11-04:00 [COMMAND_EXIT_CODE="0"]
```