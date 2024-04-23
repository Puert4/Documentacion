package patient.system;

import JPAEntities.PatientEntity;

/**
 *
 * @author TeLesheo
 */
public interface IPatientDAO {

    public void registerPatient(PatientEntity patient);

    public PatientEntity serachPatientById(Long idPatient);

    public PatientEntity searchPatientByCurp(String curp);

}
