package control;

import JPAEntities.PatientEntity;
import dtos.ExistentPatientDTO;
import dtos.NewPatientDTO;
import dtos.UserDTO;

/**
 *
 * @author TeLesheo
 */
public interface IControl {

    public String encrypt(String text, int code);

    public String decrypt(String text, int code);

    public void addNewPatient(NewPatientDTO newPatient);

    public Long verifyUser(String user, String password);

    public ExistentPatientDTO convertPatientToExistent(PatientEntity patient);

    public PatientEntity findByCurp(String curp);

    public ExistentPatientDTO findById(Long id);

    public void addNewUser(UserDTO newUser);

}
