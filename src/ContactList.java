import java.util.ArrayList;

public class ContactList {
    private ArrayList<Contact> Contacts;
    public ContactList() {
        Contacts = new ArrayList<>();
    }
// this adds contacts to the ContactList
    public void addContact(Contact contact) {
        Contacts.add(contact);
    }

    public void printList() {
        System.out.println("My Contact List");
        for(Contact contact : Contacts) {
            System.out.println("\t" + contact);
        }
    }
}
