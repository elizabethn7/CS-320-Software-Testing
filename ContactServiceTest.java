import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    @Test
    void testAddContact() {
        Contact contact = new Contact("C123", "John", "Smith", "1234567890", "123 Main Street");
        service.addContact(contact);
        assertEquals(contact, service.getContact("C123"));
    }

    @Test
    void testDuplicateContactId() {
        service.addContact(new Contact("C123", "John", "Smith", "1234567890", "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> service.addContact(new Contact("C123", "Jane", "Jones", "0987654321", "456 Oak Avenue")));
    }

    @Test
    void testDeleteContact() {
        service.addContact(new Contact("C123", "John", "Smith", "1234567890", "123 Main Street"));
        service.deleteContact("C123");
        assertNull(service.getContact("C123"));
    }

    @Test
    void testDeleteMissingContact() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("C999"));
    }

    @Test
    void testUpdateContactFields() {
        service.addContact(new Contact("C123", "John", "Smith", "1234567890", "123 Main Street"));

        service.updateFirstName("C123", "Jane");
        service.updateLastName("C123", "Jones");
        service.updatePhone("C123", "0987654321");
        service.updateAddress("C123", "456 Oak Avenue");

        Contact updated = service.getContact("C123");
        assertEquals("Jane", updated.getFirstName());
        assertEquals("Jones", updated.getLastName());
        assertEquals("0987654321", updated.getPhone());
        assertEquals("456 Oak Avenue", updated.getAddress());
    }

    @Test
    void testUpdateMissingContact() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("C999", "Jane"));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("C999", "Jones"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("C999", "0987654321"));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("C999", "456 Oak Avenue"));
    }
}
