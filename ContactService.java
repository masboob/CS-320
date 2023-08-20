/*******************
 * Elana Masboob
 * CS 320
 * Project 1
 * -> ContactService
 *      -> ContactService.java
 * ContactService.java This is the contact service. 
 * It maintains a list of contacts and has capabilities
 * for adding and deleting contacts, as well as updating first name, last name, phone number, and address.
 *******************/
 
package Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    // Start with an ArrayList of contacts to hold the list of contacts
    private List<Contact> contactList = new ArrayList<>();

    // Display the full list of contacts to the console for error checking.
    public void displayContactList() {
        for (Contact contact : contactList) {
            System.out.println("\t Contact ID: " + contact.getContactID());
            System.out.println("\t First Name: " + contact.getFirstName());
            System.out.println("\t Last Name: " + contact.getLastName());
            System.out.println("\t Phone Number: " + contact.getNumber());
            System.out.println("\t Address: " + contact.getAddress() + "\n");
        }
    }

    // Adds a new contact to the contactList.
    public boolean addContact(Contact newContact) {
        // Verify that the ID is not already in the list
        String newContactId = newContact.getContactID();
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(newContactId)) {
                throw new IllegalArgumentException("Duplicate ID: " + newContactId);
            }
        }
        return contactList.add(newContact);
    }

    // Using Contact ID, return a contact object
    // If a matching Contact ID is not found, return null
    public Contact getContact(String contactID) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(contactID)) {
                return contact;
            }
        }
        return null;
    }

    // Delete contact.
    // Use the contactID to find the right contact to delete from the list
    // If we get to the end of the list without finding a match for contactID, report that to the console.
    public void deleteContact(String contactID) {
        for (int counter = 0; counter < contactList.size(); counter++) {
            if (contactList.get(counter).getContactID().equals(contactID)) {
                contactList.remove(counter);
                return; // Exit the method after deletion.
            }
        }
        System.out.println("Contact ID: " + contactID + " not found.");
    }

    // Update the first name.
    public void updateFirstName(String updatedString, String contactID) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(contactID)) {
                contact.setFirstName(updatedString);
                return; // Exit the method after updating.
            }
        }
        System.out.println("Contact ID: " + contactID + " not found.");
    }

    // Update the last name.
    public void updateLastName(String updatedString, String contactID) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(contactID)) {
                contact.setLastName(updatedString);
                return; // Exit the method after updating.
            }
        }
        System.out.println("Contact ID: " + contactID + " not found.");
    }

    // Update the phone number.
    public void updateNumber(String updatedString, String contactID) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(contactID)) {
                contact.setNumber(updatedString);
                return; // Exit the method after updating.
            }
        }
        System.out.println("Contact ID: " + contactID + " not found.");
    }

    // Update the address.
    public void updateAddress(String updatedString, String contactID) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(contactID)) {
                contact.setAddress(updatedString);
                return; // Exit the method after updating.
            }
        }
        System.out.println("Contact ID: " + contactID + " not found.");
    }
}
