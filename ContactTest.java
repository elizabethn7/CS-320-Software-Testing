import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testContactCreation() {
        Contact contact = new Contact("C123", "John", "Smith", "1234567890", "123 Main Street");
        assertEquals("C123", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null, "John", "Smith", "1234567890", "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "John", "Smith", "1234567890", "123 Main Street"));
    }

    @Test
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C123", null, "Smith", "1234567890", "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C123", "JohnathanDoe", "Smith", "1234567890", "123 Main Street"));
    }

    @Test
    void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C123", "John", null, "1234567890", "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C123", "John", "VeryLongName", "1234567890", "123 Main Street"));
    }

    @Test
    void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C123", "John", "Smith", null, "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C123", "John", "Smith", "12345", "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C123", "John", "Smith", "123456789a", "123 Main Street"));
    }

    @Test
    void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C123", "John", "Smith", "1234567890", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C123", "John", "Smith", "1234567890",
                        "1234567890123456789012345678901"));
    }

    @Test
    void testSetters() {
        Contact contact = new Contact("C123", "John", "Smith", "1234567890", "123 Main Street");
        contact.setFirstName("Jane");
        contact.setLastName("Jones");
        contact.setPhone("0987654321");
        contact.setAddress("456 Oak Avenue");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Jones", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak Avenue", contact.getAddress());
    }

    @Test
    void testSetterValidation() {
        Contact contact = new Contact("C123", "John", "Smith", "1234567890", "123 Main Street");

        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("VeryLongName"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123"));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }
}
