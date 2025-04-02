package module10;

import java.io.*;

// Class which parses text data from a census file
// Program takes in file path for input, file path for output, 
// and the number of records in the file
public class ParseCensus {
    // Program Entry Point
    static class CensusData { 
        int population; 
        int childPopulation;
        int childPovertyPopulation;

        CensusData() {
            population = 0;
            childPopulation = 0;
            childPovertyPopulation = 0;
        }
    }
    public static void main(String[] args) {
        // Check if the correct number of arguments is provided
        if (args.length != 3) {
            System.out.println("Usage: java ParseCensus <input_file> <output_file> <num_records>");
            return;
        }
        
        String inputFilePath = args[0];
        String outputFilePath = args[1];
        int numRecords = Integer.parseInt(args[2]);

        // Array of CensusData objects to store the census data
        CensusData[] censusDataArray = new CensusData[56];
        for (int i = 0; i < censusDataArray.length; i++) {
            censusDataArray[i] = new CensusData();
        }

        // Start the loop to process the census data

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));) {
            // Read each line from the input file
            String line;
            int recordCount = 0;
            while ((line = reader.readLine()) != null && recordCount < numRecords) {
                // process line and update data structure
                parseCensusData(line, censusDataArray);
                recordCount++;
            }
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }

        // Write the census data to json 
        writeToFile(outputFilePath, censusDataArray);
    }
    
    // Method to parse a line of census data and update the censusDataArray
    static void parseCensusData(String line, CensusData[] censusDataArray) {
        String[] data = line.split("\\s+"); // Assuming space-separated values

        
        // Convert first entry to int 
        int state = Integer.parseInt(data[0]) - 1;
        // Get the population, child population, and child poverty population
        // from the data array using "negative indexing"
        int populationPointer = (data.length - 5);

        int population = Integer.parseInt(data[populationPointer]); 
        int childPopulation = Integer.parseInt(data[populationPointer + 1]);
        int childPovertyPopulation = Integer.parseInt(data[populationPointer + 2]);

        censusDataArray[state].population += population;
        censusDataArray[state].childPopulation += childPopulation;
        censusDataArray[state].childPovertyPopulation += childPovertyPopulation;
    }

    // Method to write the census data a csv file
    static void writeToFile(String outputFilePath, CensusData[] censusDataArray) { 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            // Write the header
            writer.write("State,Population,ChildPopulation,ChildPovertyPopulation");
            writer.newLine();

            // Write the census data
            for (int i = 0; i < censusDataArray.length; i++) {
                CensusData data = censusDataArray[i];
                writer.write((i + 1) + "," + data.population + "," + data.childPopulation + "," + data.childPovertyPopulation);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    } 
}