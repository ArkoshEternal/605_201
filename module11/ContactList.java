
package module11;

import java.io.*;
import java.util.*;

// Class which manages a contact list as a TreeMap 
// Program takes in file name as input and allows user 
// to add, delete, and display contacts
public class ContactList {
    // Contact class to store individual contact details
    static class Contact implements Serializable {
        String firstName;
        String lastName;
        String phoneNumber;
        String email;

        public Contact(String firstName, String lastName, String phoneNumber, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        @Override
        public String toString() {
            return firstName + " " + lastName + " | " + phoneNumber + " | " + email;
        }
    }

    // TreeMap to store contacts sorted by last name
    private static Map<String, Contact> contactList = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the filename to store contacts
        System.out.print("Enter the name of the file" + 
        " where contact list will be stored: ");
        String fileName = scanner.nextLine();
        loadContacts(fileName);

        while (true) {
            // Display options to the user
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a contact");
            System.out.println("2. Delete a contact");
            System.out.println("3. Display all contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    deleteContact(scanner);
                    break;
                case 3:
                    displayContacts();
                    break;
                case 4:
                    saveContacts(fileName);
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void loadContacts(String fileName) throws IOException {
        // Check if file exists and load data
        File file = new File(fileName);
        if (file.exists()) {
            try (ObjectInputStream ois = 
                new ObjectInputStream(new FileInputStream(file))) {
                // Safely deserialize the Map object
                Object object = ois.readObject();
                if (object instanceof Map) {
                    Map<?, ?> map = (Map<?, ?>) object;
                    contactList = new TreeMap<>();
                    for (Map.Entry<?, ?> entry : map.entrySet()) {
                        if (entry.getKey() instanceof String && 
                            entry.getValue() instanceof Contact) {
                            contactList.put((String) entry.getKey(), 
                                (Contact) entry.getValue());
                        }
                    }
                } else {
                    System.out.println("The data in the file" + 
                        " is not in the expected format.");
                }
            } catch (ClassNotFoundException | IOException e) {
                System.out.println("Error loading contacts: " + e.getMessage());
            }
        }
    }

    private static void saveContacts(String fileName) throws IOException {
        // Save contact list to file
        try (ObjectOutputStream oos = new 
            ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(contactList);
        }
    }

    private static void addContact(Scanner scanner) {
        // Prompt user for contact details
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();

        // Create new contact and add to the contact list
        Contact newContact = new 
            Contact(firstName, lastName, phoneNumber, email);
        contactList.put(lastName, newContact);
        System.out.println("Contact added successfully.");
    }

    private static void deleteContact(Scanner scanner) {
        // Ask user for the last name of the contact to delete
        System.out.print("Enter the last name of the contact to delete: ");
        String lastName = scanner.nextLine();

        if (contactList.containsKey(lastName)) {
            contactList.remove(lastName);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("No contact found with that last name.");
        }
    }

    private static void displayContacts() {
        // Display all contacts sorted by last name
        if (contactList.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("\nContact List:");
            for (Contact contact : contactList.values()) {
                System.out.println(contact);
            }
        }
    }
}
