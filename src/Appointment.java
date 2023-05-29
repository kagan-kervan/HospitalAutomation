package src;

public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private int minute;
    private int hour;
    private boolean isEmergency;

    public Appointment(Doctor doctor, Patient patient, int hour, int minute) {
        this.doctor = doctor;
        this.patient = patient;
        this.minute = minute;
        this.hour = hour;
    }

    public String getDate() {
        String date = Integer.toString(hour) + ":" + Integer.toString(minute);
        return date;
    }

    public boolean isEmergency() {
        return isEmergency;
    }
}