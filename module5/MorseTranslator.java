package module5;
// Class Morse Translator
// This class will translate a string of text into Morse code
// and output the Morse code to the console, or translate a
// string of Morse code into text and output the text to the
// console.

import java.util.Scanner;
public class MorseTranslator {
    // Program Entry Point
    public static void main(String[] args) {
        boolean isMorse = false;
        String input = "";
        String output = "";
        Scanner scanner = new Scanner(System.in);
        // Get user input
        System.out.println("Please enter 0 to translate English to Morse or 1 to translate Morse to English: ");
        isMorse = scanner.nextInt() == 0;
        System.out.print("Please enter the text to translate: "); 
        input = scanner.nextLine();   // Consume newline from buffer
        input = scanner.nextLine(); 
        // Translate the input
        if(isMorse) { 
            output = translateToMorse(input);
        } else {
            output = translateToEnglish(input);
        }
        // Output the result
        System.out.println(output);
        scanner.close();
    } // end main
    
    static String translateToMorse(String input) {
        // Translate the input string to Morse code
        // and output the Morse code to the console
        String output = "";
        for(int i = 0; i < input.length(); i++) {
            output += getMorseCode(input.charAt(i));
            output += " ";
        }
        return output;  
    } // end translateToMorse

    static String translateToEnglish(String input) {
        // Translate the input string of Morse code to English
        // and output the English to the console
        String output = "";
        String[] morse = input.split(" ");
        for(int i = 0; i < morse.length; i++) {
            output += getEnglishChar(morse[i]);
        }
        return output;
    } 

    static String getMorseCode(char c) {
        // Return the Morse code for a single character
        switch (Character.toLowerCase(c)) {
            case 'a':
            return ".-";
            case 'b':
            return "-...";
            case 'c':
            return "-.-.";
            case 'd':
            return "-..";
            case 'e':
            return ".";
            case 'f':
            return "..-.";
            case 'g':
            return "--.";
            case 'h':
            return "....";
            case 'i':
            return "..";
            case 'j':
            return ".---";
            case 'k':
            return "-.-";
            case 'l':
            return ".-..";
            case 'm':
            return "--";
            case 'n':
            return "-.";
            case 'o':
            return "---";
            case 'p':
            return ".--.";
            case 'q':
            return "--.-";
            case 'r':
            return ".-.";
            case 's':
            return "...";
            case 't':
            return "-";
            case 'u':
            return "..-";
            case 'v':
            return "...-";
            case 'w':
            return ".--";
            case 'x':
            return "-..-";
            case 'y':
            return "-.--";
            case 'z':
            return "--..";
            case '0':
            return "-----";
            case '1':
            return ".----";
            case '2':
            return "..---";
            case '3':
            return "...--";
            case '4':
            return "....-";
            case '5':
            return ".....";
            case '6':
            return "-....";
            case '7':
            return "--...";
            case '8':
            return "---..";
            case '9':
            return "----.";
            case ' ':
            return "|";
            default:
            return "";
        }
    } // end getMorseCode

    static String getEnglishChar(String morse) {
        // Return the English character for a Morse code string
        switch (morse) {
            case ".-":
                return "a";
            case "-...":
                return "b";
            case "-.-.":
                return "c";
            case "-..":
                return "d";
            case ".":
                return "e";
            case "..-.":
                return "f";
            case "--.":
                return "g";
            case "....":
                return "h";
            case "..":
                return "i";
            case ".---":
                return "j";
            case "-.-":
                return "k";
            case ".-..":
                return "l";
            case "--":
                return "m";
            case "-.":
                return "n";
            case "---":
                return "o";
            case ".--.":
                return "p";
            case "--.-":
                return "q";
            case ".-.":
                return "r";
            case "...":
                return "s";
            case "-":
                return "t";
            case "..-":
                return "u";
            case "...-":
                return "v";
            case ".--":
                return "w";
            case "-..-":
                return "x";
            case "-.--":
                return "y";
            case "--..":
                return "z";
            case "-----":
                return "0";
            case ".----":
                return "1";
            case "..---":
                return "2";
            case "...--":
                return "3";
            case "....-":
                return "4";
            case ".....":
                return "5";
            case "-....":
                return "6";
            case "--...":
                return "7";
            case "---..":
                return "8";
            case "----.":
                return "9";
            case "|":
                return " ";
            default:
                return "";
        }
    } // end getEnglishChar
} // end class MorseTranslator
