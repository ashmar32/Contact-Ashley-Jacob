import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactManagerMain {
    public static void main(String[] args) throws IOException {
        Integer captureUserInput;
        do {
            System.out.println("""
                1. View contacts ddd
                2. Add a new contact
                3. Search a contact by name
                4. Delete an existing contact
                5. Exit
                Please enter an option (1, 2, 3, 4 or 5): """);
            Input input = new Input();
            captureUserInput = input.getInt(1, 5);

            switch (captureUserInput) {
                case 1:
                    //display all contact data from file
                    System.out.println("Contact Name | Contact Phone");
                    for (Contact individualContact : FileMain.getContactsFromFile()) {
                        System.out.println(individualContact.getName() +
                                " | " + individualContact.getPhone());
                    }
                    break;
                case 2:
                    //add a new contact to the file
                    System.out.println("Enter contact name");
                    Input input1 = new Input();
                    String getContactName = input1.getString();
                    System.out.println("Enter contact phone number: ");
                    String getContactPhone = input1.getString();
//                    System.out.println(getContactName + getContactPhone);
                    FileMain.addContact(getContactName, getContactPhone);
                    break;
                case 3:
                    //search file for a contact
                    Input input2 = new Input();
                    System.out.println("Search contact by name: ");

                    // if individual contact = searchinput then output individual contact
                    String searchedNameInput = input2.getString();

                    for (Contact individualContact : FileMain.getContactsFromFile()) {
                        if (individualContact.getName().equals(searchedNameInput)) {
                            System.out.println(individualContact);
                        }
                    }

//                    System.out.println("3");
                    break;
                case 4:
                    //delete a contact
                    Input input3 = new Input();
                    System.out.println("Delete contact by name: ");

                    // if individual contact = searchinput then output individual contact
                    String searchedNameInput2 = input3.getString();
                    List <Contact> getContactsList2 = FileMain.getContactsFromFile();
                    Files.write(Paths.get("data","contacts.txt"), Arrays.asList());

                    for (Contact individualContact : getContactsList2) {
                        if (!individualContact.getName().equals(searchedNameInput2)) {
                            // make a copy of the list of contacts that doesn't include the searched name
                            FileMain.addContact(individualContact.getName(), String.valueOf(individualContact.getPhone()));
                        }
                    }
                    break;
                case 5:
                    //kill the robot
                    System.out.println("Goodbye");
                    break;
            }

        } while (captureUserInput != 5);
        return;
    }
}

