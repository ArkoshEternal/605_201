package module10;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.text.NumberFormat;
import java.util.Locale;

// Class which takes in csv representation of census data and prints it
// to the console
public class PrintData {
    // Program Entry Point
    public static void main(String[] args) {
        // Check if the correct number of arguments is provided
        if (args.length != 2) { 
            System.out.println("Usage: java PrintData <input_file> <num_records>");
            return;
        }

        // Extract Args
        String inputFilePath = args[0];

        // Print Header
        printHeader();

        // Read CSV file and print data
               try {
            List<String> lines = Files.readAllLines(Paths.get(inputFilePath));
            processCsv(lines);
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
    
    // Method to process CSV data
    public static void processCsv(List<String> lines) {
        // Process each line in the CSV, except the header
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        if (lines.isEmpty()) return; // No data to process
        lines.remove(0); // Remove header line
        for (String line : lines) {
            String[] columns = line.split(",");
            if (columns.length != 4) continue; // Skip invalid rows
            
            try {
                int state = Integer.parseInt(columns[0].trim());
                int population = Integer.parseInt(columns[1].trim());
                int childPopulation = Integer.parseInt(columns[2].trim());
                int childPovertyPopulation = Integer.parseInt(columns[3].trim());

                double povertyPercentage = ((double) childPovertyPopulation / childPopulation) * 100;

                // Print data rows with right justification
                System.out.printf("%5s    %10s %17s %24s %16.2f%n", 
                    String.format("%02d", state),
                    numberFormat.format(population),
                    numberFormat.format(childPopulation),
                    numberFormat.format(childPovertyPopulation),
                    povertyPercentage);
            } catch (NumberFormatException e) {
                System.err.println("Error parsing numbers in line: " + line);
            }
        }
    }

    // Method to print header 
    static void printHeader() { 
        // Print header 
        System.out.print("State");
        System.out.print("    Population");
        System.out.print("  Child Population");
        System.out.print(" Child Poverty Population");
        System.out.print("  % Child Poverty");
        System.out.println();
        // Print Table Ticks 
        System.out.print("-----");
        System.out.print("    ----------");
        System.out.print("  ----------------");
        System.out.print(" ------------------------");
        System.out.print("  ---------------");
        System.out.println();
    }
}
