import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;
    String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + emailAddress;
    }
}

class ContactManager {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    exitProgram();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nContact Manager Menu:");
        System.out.println("1. Add New Contact");
        System.out.println("2. View Contacts");
        System.out.println("3. Edit Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Exit");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return choice;
    }

    private static void addContact() {
        System.out.print("Enter Name: ");
        String name = scanner.next();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.next();

        System.out.print("Enter Email Address: ");
        String emailAddress = scanner.next();

        contacts.add(new Contact(name, phoneNumber, emailAddress));
        System.out.println("Contact added successfully!");
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("Contact List:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    private static void editContact() {
        viewContacts();
        if (contacts.isEmpty()) {
            return;
        }

        System.out.print("Enter the index of the contact you want to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (index >= 0 && index < contacts.size()) {
            System.out.print("Enter new Name: ");
            contacts.get(index).name = scanner.next();

            System.out.print("Enter new Phone Number: ");
            contacts.get(index).phoneNumber = scanner.next();

            System.out.print("Enter new Email Address: ");
            contacts.get(index).emailAddress = scanner.next();

            System.out.println("Contact edited successfully!");
        } else {
            System.out.println("Invalid index. Please enter a valid index.");
        }
    }

    private static void deleteContact() {
        viewContacts();
        if (contacts.isEmpty()) {
            return;
        }

        System.out.print("Enter the index of the contact you want to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (index >= 0 && index < contacts.size()) {
            Contact deletedContact = contacts.remove(index);
            System.out.println("Contact deleted successfully: " + deletedContact);
        } else {
            System.out.println("Invalid index. Please enter a valid index.");
        }
    }

    private static void exitProgram() {
        System.out.println("Exiting Contact Manager. Goodbye!");
        System.exit(0);
    }
}