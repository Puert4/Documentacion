package control;

import patient.system.IPatientDAO;
import patient.system.PatientDAO;
import user.system.IUserDAO;
import user.system.UserDAO;

/**
 *
 * @author TeLesheo
 */
public class Factory {

    private static IPatientDAO patientDAO;
    private static IUserDAO userDAO;

    public static IPatientDAO getPatientDAO() {
        return patientDAO == null ? (patientDAO = PatientDAO.getInstance()) : patientDAO;
    }

    public static IUserDAO getUserDAO() {
        return userDAO == null ? (userDAO = UserDAO.getInstance()) : userDAO;
    }

}
