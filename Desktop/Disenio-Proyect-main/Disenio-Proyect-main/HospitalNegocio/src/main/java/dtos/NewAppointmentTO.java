package dtos;

import java.util.Calendar;

/**
 *
 * @author Laboratorios
 */
public class NewAppointmentTO {

    private ExistentDoctorDTO doctor;
    private ExistentPatientDTO patient;
    private Calendar appointmentDate;
    private int status;

    public NewAppointmentTO() {
    }

    public NewAppointmentTO(ExistentDoctorDTO doctor, ExistentPatientDTO patient, Calendar appointmentDate, int status) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    public ExistentDoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(ExistentDoctorDTO doctor) {
        this.doctor = doctor;
    }

    public ExistentPatientDTO getPatient() {
        return patient;
    }

    public void setPatient(ExistentPatientDTO patient) {
        this.patient = patient;
    }

    public Calendar getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Calendar appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
