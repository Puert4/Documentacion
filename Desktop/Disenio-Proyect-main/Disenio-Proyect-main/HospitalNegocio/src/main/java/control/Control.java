package control;

import JPAEntities.PatientEntity;
import JPAEntities.UserEntity;
import dtos.ExistentPatientDTO;
import dtos.NewPatientDTO;
import dtos.UserDTO;
import loginManager.ILogIn;
import loginManager.LogIn;
import patient.system.IPatientDAO;
import user.system.IUserDAO;
import user.system.UserDAO;

/**
 *
 * @author TeLesheo
 */
public abstract class Control implements IControl {

    int code = 9;

    private Control() {
    }

    /**
     *
     * @param newPatient
     */
    @Override
    public void addNewPatient(NewPatientDTO newPatient) {
        IPatientDAO patientSystem = Factory.getPatientDAO();

        PatientEntity patient = new PatientEntity();
        patient.setNames(newPatient.getNames());
        patient.setFirstName(newPatient.getFirstName());
        patient.setSecondName(newPatient.getSecondName());
        patient.setCurp(newPatient.getCurp());
        patient.setPhone(newPatient.getPhone());
        patient.setBirthDate(newPatient.getBirthDate());
        patient.setSex(newPatient.getSex());
        patient.setStreet(newPatient.getStreet());
        patient.setZipCode(newPatient.getZipCode());
        patient.setColony(newPatient.getColony());
        patient.setSocialNumber(newPatient.getSocialNumber());

        patientSystem.registerPatient(patient);
    }

    @Override
    public void addNewUser(UserDTO newUser) {
        IUserDAO userSystem = UserDAO.getInstance();
        IPatientDAO patientSystem = Factory.getPatientDAO();

        UserEntity user = new UserEntity();
        user.setUser(encrypt(newUser.getUser(), code));
        user.setPassword(encrypt(newUser.getPassword(), code));
        user.setPatient(patientSystem.searchPatientByCurp(newUser.getPatientDTO().getCurp()));
        userSystem.registerUser(user);
    }

    @Override
    public PatientEntity findByCurp(String curp) {
        IPatientDAO patientSystem = Factory.getPatientDAO();
        return patientSystem.searchPatientByCurp(curp);
    }

    @Override
    public ExistentPatientDTO findById(Long id) {

        IPatientDAO patientSystem = Factory.getPatientDAO();
        return convertPatientToExistent(patientSystem.serachPatientById(id));

    }

    @Override
    public Long verifyUser(String user, String password) {
        ILogIn login = LogIn.getInstance();
        Long patientId = login.validateUser(encrypt(user, code), encrypt(password, code));
        return patientId;

    }

    @Override
    public ExistentPatientDTO convertPatientToExistent(PatientEntity patient) {
        ExistentPatientDTO existentPatientDTO = new ExistentPatientDTO();
        existentPatientDTO.setId(patient.getId());
        existentPatientDTO.setName(patient.getNames());
        existentPatientDTO.setFirstName(patient.getFirstName());
        existentPatientDTO.setSecondName(patient.getSecondName());
        existentPatientDTO.setCurp(patient.getCurp());
        existentPatientDTO.setPhone(patient.getPhone());
        existentPatientDTO.setBirthDate(patient.getBirthDate());
        existentPatientDTO.setSex(patient.getSex());
        existentPatientDTO.setStreet(patient.getStreet());
        existentPatientDTO.setZipCode(patient.getZipCode());
        existentPatientDTO.setColonia(patient.getColony());
        existentPatientDTO.setSocialNumber(patient.getSocialNumber());

        return existentPatientDTO;
    }

    public static Control getInstance() {
        return new Control() {
        };
    }

    @Override
    public String encrypt(String text, int code) {

        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char caracter = text.charAt(i);
            if (Character.isLetter(caracter)) {
                char base = Character.isLowerCase(caracter) ? 'a' : 'A';
                char encriptado = (char) (((caracter - base + code) % 26) + base);
                resultado.append(encriptado);
            } else {
                resultado.append(caracter);
            }
        }
        return resultado.toString();

    }

    @Override
    public String decrypt(String text, int code) {

        return encrypt(text, 26 - code);

    }

}
