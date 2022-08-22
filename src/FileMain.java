import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileMain {
    public static void main(String[] args) throws IOException {

        // make a path object using absolute path for a contact folder
//        /Users/asininexashley/IdeaProjects/Contacts-Ashley-Jacob
        Path contactFolder = Paths.get("/Users", "asininexashley", "IdeaProjects", "Contacts-Ashley-Jacob", "contacts");

//        Path demoFolder = Paths.get("demo");

        System.out.println("Does this folder exist? " + Files.exists(contactFolder));

        Path contactFile = Paths.get("/Users", "asininexashley", "IdeaProjects", "Contacts-Ashley-Jacob", "contacts", "contacts.txt");

        System.out.println("Does this file exist? " + Files.exists(contactFile));

        if(Files.exists(contactFolder)) {
            System.out.println("Hey the folder already exists!");
        } else {
            Files.createDirectories(contactFolder);
        }
        if(Files.exists(contactFile)) {
            System.out.println("Hey the file already exists!");
        } else {
            Files.createFile(contactFile);
        }

        // make some fruits and write them to a file
        List<String> contacts = Arrays.asList("banana", "plum", "orange", "pears");
        Files.write(contactFile, contacts);

        List<String> contactDB = Files.readAllLines(contactFile);
        System.out.println(contactDB);

        contactDB.remove("banana");
        System.out.println(contactDB);
        Files.write(contactFile, contactDB);
    }
}
