/*******************
 * Elana Masboob
 * CS 320
 * Project 1
 * -> ContactService
 *      -> ContactServiceTest.java
 * ContactServiceTest.java is the unit test for ContactService
 *******************/

package Contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    void testAddContactDuplicateIdFail() {
        Contact contact1 = new Contact("123457", "Omar", "Toledo", "1112 E Road Street", "5613665975");
        Contact contact2 = new Contact("123457", "Nicholas", "Renna", "1111 E Road Street", "4802929112");

        assertTrue(contactService.addContact(contact1));
        assertFalse(contactService.addContact(contact2));
    }

    @Test
    void testGetContactAndUpdateSuccess() {
        Contact contact1 = new Contact("1234", "Omar", "Toledo", "1111 E Road Street", "5616998652");

        assertTrue(contactService.addContact(contact1));

        // Update using setters
        contactService.updateFirstName("Nicholas", "1234");
        contactService.updateLastName("Renna", "1234");
        contactService.updateNumber("4802929112", "1234");
        contactService.updateAddress("1234 W Road Street", "1234");

        Contact updatedContact = contactService.getContact("1234");
        assertNotNull(updatedContact);
        assertEquals("Nicholas", updatedContact.getFirstName());
        assertEquals("Renna", updatedContact.getLastName());
        assertEquals("4802929112", updatedContact.getNumber());
        assertEquals("1234 W Road Street", updatedContact.getAddress());
    }

    @Test
    void testGetContactAndDeleteSuccess() {
        Contact contact1 = new Contact("5678", "Alice", "Johnson", "2222 S Road Street", "9876543210");

        assertTrue(contactService.addContact(contact1));

        // Delete by ID
        contactService.deleteContact("5678");
        assertNull(contactService.getContact("5678"));
    }
}
