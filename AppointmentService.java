/*******************
 * Elana Masboob
 * CS 320
 * Project 1
 * -> Appointment
 *      -> AppointmentService.java
 * AppointmentService maintains appointments by the following:
 * adding, updating, and deleting appointments
 *******************/

package Appointment;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {
    // Start with an ArrayList of appointments to hold the list
    public ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();

    // Adds a new appointment using the Appointment constructor, then assigns to the list.
    public void addAppointment(Appointment appointment) {
        appointmentList.add(appointment);
    }

    // Using Appointment ID, return an appointment object
    // If a matching ID is not found, return an appointment object with default values
    public Appointment getAppointment(String appointmentID) {
        Appointment appointment = new Appointment(null, null);
        for (int counter = 0; counter < appointmentList.size(); counter++) {
            if (appointmentList.get(counter).getAppointmentID().contentEquals(appointmentID)) {
                appointment = appointmentList.get(counter);
            }
        }
        return appointment;
    }

    // Delete appointment.
    // Use the appointmentID to find the right appointment to delete from the list
    // If we get to the end of the list without finding a match for ID, report that to the console.
    // This method of searching for appointmentID is the same for all update methods below.
    public void deleteAppointment(String appointmentID) {
        for (int counter = 0; counter < appointmentList.size(); counter++) {
            if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
                appointmentList.remove(counter);
                break;
            }
            if (counter == appointmentList.size() - 1) {
                System.out.println("Appointment ID: " + appointmentID + " not found.");
            }
        }
    }

    // Update the appointment date.
    public void updateAppointmentDate(Date updatedDate, String appointmentID) {
        for (int counter = 0; counter < appointmentList.size(); counter++) {
            if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
                appointmentList.get(counter).setAppointmentDate(updatedDate);
                break;
            }
            if (counter == appointmentList.size() - 1) {
                System.out.println("Appointment ID: " + appointmentID + " not found.");
            }
        }
    }

    // Update the appointment description.
    public void updateAppointmentDesc(String updatedString, String appointmentID) {
        for (int counter = 0; counter < appointmentList.size(); counter++) {
            if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
                appointmentList.get(counter).setAppointmentDesc(updatedString);
                break;
            }
            if (counter == appointmentList.size() - 1) {
                System.out.println("Appointment ID: " + appointmentID + " not found.");
            }
        }
    }
}
