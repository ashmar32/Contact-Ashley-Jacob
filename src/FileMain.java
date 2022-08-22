import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileMain {
public static Path contactFolder = Paths.get("data");

public static Path contactFile = Paths.get("data", "contacts.txt");

    public static void main(String[] args) throws IOException {

        // make a path object using absolute path for a contact folder
//        /Users/asininexashley/IdeaProjects/Contacts-Ashley-Jacob

//        Path demoFolder = Paths.get("demo");

        System.out.println("Does this folder exist? " + Files.exists(contactFolder));


        System.out.println("Does this file exist? " + Files.exists(contactFile));

//        if(Files.exists(contactFolder)) {
//            System.out.println("Hey the folder already exists!");
//        } else {
//            Files.createDirectories(contactFolder);
//        }
        if(Files.exists(contactFile)) {
            System.out.println("Hey the file already exists!");
        } else {
            Files.createFile(contactFile);
        }

        // make some contacts and write them to a file -this works check the contacts folder
//        List<String> contacts = Arrays.asList("Ashley", "Crystal", "Chuy", "Chica");
//        Files.write(contactFile, contacts);


//        contactDB.remove("banana");
//        System.out.println(contactDB);
//        Files.write(contactFile, contactDB);
    }

    public static void showAll() throws IOException {
        List<String> contactDB = Files.readAllLines(contactFile);
        for (String name : contactDB) {
            System.out.println(name);
        }
    }
    public static void addContact(String name, String number) {
        try {
            String fileLine = "";
            fileLine = name + "," + number;
            Files.write(
                    Paths.get("data", "contacts.txt"),
                    Arrays.asList(fileLine),
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*********************************************************************
     * @description returns all of the contacts from the contacts.txt as a List of Contact records
     * @return List<Contact> all of the contacts from the input file
     *
     ********************************************************************/
    public static List<Contact> getContactsFromFile() throws IOException {
        List<Contact> allContactsFromFile = new ArrayList<>();
        //get lines from file
        List<String> savedLinesToFiles = Files.readAllLines(contactFile);
        //for each file line save data to contact object record
        for (String individualContact: savedLinesToFiles){
            //go through each line saved from file, save as Contact record
            //split line of contact data into name and phone data
            //how do you take a string and break it down to individual data
            String[] splitContactThing = individualContact.split(",");
            String name = splitContactThing[0];
            String phone = splitContactThing[1];
            Contact singleContact = new Contact(name, Long.parseLong(phone));
            //add contact to list of contacts
            allContactsFromFile.add(singleContact);
        }

        //return list of contacts
        return allContactsFromFile;
    }
}
