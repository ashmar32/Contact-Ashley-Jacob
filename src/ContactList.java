import java.util.List;

public class ContactList {
    private static List<String> Contacts;
//    public ContactList() {
//        Contacts = new ArrayList<>();
//    }
// this adds contacts to the ContactList

    public static void printList() {
        System.out.println("My Contact List");
        for(String contact : Contacts) {
            System.out.println("\t" + contact);
        }
    }
}
