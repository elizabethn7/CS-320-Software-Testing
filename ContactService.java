import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }

        String contactId = contact.getContactId();
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(
                    "A contact with this ID already exists.");
        }

        contacts.put(contactId, contact);
    }

    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID was not found.");
        }

        contacts.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        getRequiredContact(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        getRequiredContact(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        getRequiredContact(contactId).setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        getRequiredContact(contactId).setAddress(address);
    }

    public Contact getContact(String contactId) {
        return getRequiredContact(contactId);
    }

    public int getContactCount() {
        return contacts.size();
    }

    private Contact getRequiredContact(String contactId) {
        Contact contact = contacts.get(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact ID was not found.");
        }

        return contact;
    }
}
