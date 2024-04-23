package appointment.system;

import JPAEntities.AppointmentEntity;

/**
 *
 * @author TeLesheo
 */
public interface IAppointmentManager {

    public void createAppointment(AppointmentEntity appointment);
}
