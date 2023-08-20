/*******************
 * Elana Masboob
 * CS 320
 * Project 1
 * -> Appointment
 *      -> AppointmentTest.java
 * AppointmentTest is the test class
 *******************/
 
package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Calendar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;

class AppointmentTest {

    /*
     * The following tests exercise the Appointment class. The first 2 tests make sure
     * the field does not become longer than the constraint (10 characters for
     * task ID and 50 characters for task description.
     * The next test checks to ensure the date is not before the current date.
     * The last 2 tests ensure that each field is not null.
     * AppointmentID is not tested for being not null because there isn't a way to
     * create an appointment with a null ID. Likewise, it is not tested for being
     * non-updateable because there is no way to update it.
     */

    private Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    @Test
    @DisplayName("Appointment ID cannot have more than 10 characters")
    void testAppointmentIDWithMoreThanTenCharacters() {
        Appointment appointment = new Appointment(createDate(2022, Calendar.JANUARY, 1), "Description");
        assertTrue(appointment.getAppointmentID().length() <= 10, "Appointment ID has more than 10 characters.");
    }

    @Test
    @DisplayName("Task Description cannot have more than 50 characters")
    void testAppointmentDescWithMoreThanFiftyCharacters() {
        Appointment appointment = new Appointment(createDate(2022, Calendar.JANUARY, 1), "123456789 is nine characters long" 
                + "123456789 is another nine characters long" 
                + "123456789 is another nine characters long"
                + "123456789 is another nine characters long");
        assertTrue(appointment.getAppointmentDesc().length() <= 50, "Appointment Description has more than 50 characters.");
    }
    
    @Test
    @DisplayName("Appointment Date cannot be before current date")
    void testAppointmentDateBeforeCurrent() {
        Appointment appointment = new Appointment(createDate(1022, Calendar.JANUARY, 1), "Description");
        assertTrue(appointment.getAppointmentDate().after(new Date()), "Appointment Date is before current date.");
    }

    @Test
    @DisplayName("Task Date shall not be null")
    void testAppointmentDateNotNull() {
        Appointment appointment = new Appointment(null, "Description");
        assertNotNull(appointment.getAppointmentDate(), "Appointment Date was null.");
    }
    
    @Test
    @DisplayName("Task Description shall not be null")
    void testAppointmentDescNotNull() {
        Appointment appointment = new Appointment(createDate(2022, Calendar.JANUARY, 1), null);
        assertNotNull(appointment.getAppointmentDesc(), "Appointment Description was null.");
    }
}
