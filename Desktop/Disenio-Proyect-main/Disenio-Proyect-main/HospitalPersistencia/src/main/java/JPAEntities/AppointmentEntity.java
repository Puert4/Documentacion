package JPAEntities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author TeLesheo
 */
@Entity
@Table(name = "AppointmentEntity")
public class AppointmentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_doctor", nullable = false)
    private DoctorEntity doctor;

    @OneToOne
    @JoinColumn(name = "id_patint", nullable = false)
    private PatientEntity patient;

    @Column(name = "appointment_date", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar appointmentDate;

    @Column(name = "apponitment_state", nullable = false)
    private AppointmentStateEntity AppointmentState;

    public AppointmentEntity() {
    }

    public AppointmentEntity(DoctorEntity doctor, PatientEntity patient, Calendar appointmentDate, AppointmentStateEntity AppointmentState) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.AppointmentState = AppointmentState;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public Calendar getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Calendar appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public AppointmentStateEntity getAppointmentState() {
        return AppointmentState;
    }

    public void setAppointmentState(AppointmentStateEntity AppointmentState) {
        this.AppointmentState = AppointmentState;
    }

}
