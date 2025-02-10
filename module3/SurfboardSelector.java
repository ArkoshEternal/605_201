/*
 * Surf Board Selector
 * 
 * Different surfboards are better for different conditions.
 * This program mocks pulling data for swell & wind, then
 * determines the ideal surfboard for those simple conditions.
 * 
 */
package module3.discussion;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SurfboardSelector {
    public static void main(String[] args) {

        String board = "undetermined";
        List<String> messages = new ArrayList<String>();
        Random mock = new Random();

        // get wave height from open-meteo API (mocked here)
        double waveHeight = mock.nextDouble(20);
        String waveCategory = "unknown"; // should be an enum
        // EDIT: Use a switch statement to categorize wave height

        int waveHeightCategory = (int) Math.ceil(waveHeight / 5);
        switch (waveHeightCategory) {
            case 0: // less than 5 feet
                waveCategory = "small";
                messages.add("Small waves : " + waveHeight);
            break;
            case 1: // 5-9 feet
                waveCategory = "medium";
                messages.add("Medium waves : " + waveHeight);
            break;
            case 2: // 10-14 feet
                waveCategory = "large";
                messages.add("Large waves : " + waveHeight);
            break;
            default: // greater than 15 feet
                waveCategory = "xlarge";
                messages.add("Waves are pounding : " + waveHeight);
            break;
        } // end waveCategory switch statement.
        
        // is there wind? check windspeeds from NOAA (mocked here)
        // Edit: use a switch statement again since we have multiple categories
        double steadyWind = mock.nextDouble(40);
        String windCategory = "unknown"; // should be an enum
        int windSpeedCategory = (int) Math.ceil(steadyWind / 5);
        switch (windSpeedCategory) {
            case 0: // less than 5 kph
                windCategory = "light";
                messages.add("Light winds : " + steadyWind);
            break;
            case 1: // 5-9 kph
                windCategory = "medium";
                messages.add("Medium winds : " + steadyWind);
            break;
            default: // greater than 10 kph
                windCategory = "heavy";
                messages.add("Heavy winds : " + steadyWind);
            break;
        } // end windCategory switch statement.

        // determine the best board for the conditions
        if (waveCategory.equals("small")) {
            if(windCategory.equals("light")) {
                board = "log";
            } else {
                board = "floaty";
            }
        } else if (waveCategory.equals("medium")) {
            if(windCategory.equals("light")) { 
                board = "log";
            } else {
                board = "funboard";
            }  
        } else if (waveCategory.equals("large")) {
            if (windCategory.equals("light") || windCategory.equals("medium")) {
                board = "fish";
            } else {
                board = "funboard";
            }
        } else { // xlarge 

            board = "gun";
        } // end board determination
       
        // print out any messages acquired from wave and wind data.
        for (String message : messages) {
            System.out.println(message);
        }

        System.out.println("Recommended board is a " + board);

    } // end main()
} // end SurfboardSelector