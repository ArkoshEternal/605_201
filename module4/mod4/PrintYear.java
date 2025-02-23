package mod4;
/* PrintYear
* 
* Program which takes in a year and prints out the calendar for that year
* 
* @author Duncan Parke
*/
import java.util.Scanner;

// Class to print the calendar for a given year 
public class PrintYear { 
    // Function entry point
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        System.out.print("Please enter the year you want to see the calendar for (YYYY): ");
        int year = input.nextInt(); 
        for(int i = 1; i <= 12; i++) { 
            PrintMonth.printMonthCalendar(i, year); 
        }
        input.close(); 
    }
}
