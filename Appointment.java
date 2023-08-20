/*******************
 * Elana Masboob
 * CS 320
 * Project 1
 * -> Appointment
 *      -> Appointment.java
 * Appointment.java creates and stores appointment information
 *******************/
 
package Appointment;

import java.util.Date;

public class Appointment {
    private final String appointmentID;
    private Date appointmentDate;
    private String appointmentDesc;

    public Appointment(Date appointmentDate, String appointmentDesc) {
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment date cannot be null.");
        } else if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Cannot make appointment before current date.");
        } else {
            this.appointmentDate = appointmentDate;
        }

        if (appointmentDesc == null || appointmentDesc.isEmpty()) {
            this.appointmentDesc = "NULL";
        } else if (appointmentDesc.length() > 50) {
            this.appointmentDesc = appointmentDesc.substring(0, 50);
        } else {
            this.appointmentDesc = appointmentDesc;
        }

        // Appointment ID
        // Appointment ID is generated when the constructor is called. It is set as a final variable and has
        // no other getter or setter so there should be no way to change it.
        this.appointmentID = generateAppointmentID();
    }

    // GETTERS
    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentDesc() {
        return appointmentDesc;
    }

    // SETTERS
    /*
     * The setters follow the same rules as the constructor.
     */
    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment date cannot be null.");
        } else if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Cannot make appointment before current date.");
        } else {
            this.appointmentDate = appointmentDate;
        }
    }

    public void setAppointmentDesc(String appointmentDesc) {
        if (appointmentDesc == null || appointmentDesc.isEmpty()) {
            this.appointmentDesc = "NULL";
        } else if (appointmentDesc.length() > 50) {
            this.appointmentDesc = appointmentDesc.substring(0, 50);
        } else {
            this.appointmentDesc = appointmentDesc;
        }
    }

    // Helper method to generate a unique appointment ID
    private String generateAppointmentID() {
        return String.valueOf(System.currentTimeMillis());
    }
}
