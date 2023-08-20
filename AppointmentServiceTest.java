/*******************
 * Elana Masboob
 * CS 320
 * Project 1
 * -> Appointment
 *      -> AppointmentServiceTest.java
 * AppointmentServiceTest is the test class
 *******************/

package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;
import Appointment.AppointmentService;

class AppointmentServiceTest {
    
    private AppointmentService appointmentService;
    
    @BeforeEach
    void setUp() {
        appointmentService = new AppointmentService();
    }

    @Test
    @DisplayName("Test adding a new appointment")
    void testAddAppointment() {
        Appointment appointment = new Appointment(Date(2023, Calendar.AUGUST, 5), "Test appointment");
        appointmentService.addAppointment(appointment);
        assertEquals(appointment, appointmentService.getAppointment(appointment.getAppointmentID()));
    }

    @Test
    @DisplayName("Test updating appointment date")
    void testUpdateAppointmentDate() {
        Appointment appointment = new Appointment(Date(2023, Calendar.AUGUST, 5), "Test appointment");
        appointmentService.addAppointment(appointment);
        
        Date updatedDate = Date(2023, Calendar.AUGUST, 10);
        appointmentService.updateAppointmentDate(updatedDate, appointment.getAppointmentID());
        
        assertEquals(updatedDate, appointmentService.getAppointment(appointment.getAppointmentID()).getAppointmentDate());
    }

    @Test
    @DisplayName("Test updating appointment description")
    void testUpdateAppointmentDesc() {
        Appointment appointment = new Appointment(Date(2023, Calendar.AUGUST, 5), "Test appointment");
        appointmentService.addAppointment(appointment);
        
        String updatedDesc = "Updated description";
        appointmentService.updateAppointmentDesc(updatedDesc, appointment.getAppointmentID());
        
        assertEquals(updatedDesc, appointmentService.getAppointment(appointment.getAppointmentID()).getAppointmentDesc());
    }

    @Test
    @DisplayName("Test deleting an appointment")
    void testDeleteAppointment() {
        Appointment appointment = new Appointment(Date(2023, Calendar.AUGUST, 5), "Test appointment");
        appointmentService.addAppointment(appointment);
        
        String appointmentID = appointment.getAppointmentID();
        appointmentService.deleteAppointment(appointmentID);
        
        assertNull(appointmentService.getAppointment(appointmentID));
   
