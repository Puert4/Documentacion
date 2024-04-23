package loginManager;

import JPAEntities.UserEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author TeLesheo
 */
public abstract class LogIn implements ILogIn {

    private static final Logger LOGGER = Logger.getLogger(LogIn.class.getName());

    private LogIn() {

    }

//    @Override
//    public boolean validateUser(String user, String password) {
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("connectionPU");
//        EntityManager em = emf.createEntityManager();
//
//        TypedQuery<User> consultUser = em.createQuery("SELECT u FROM User u WHERE u.user = :user", User.class);
//        consultUser.setParameter("user", user);
//
//        try {
//            User username = consultUser.getSingleResult();
//
//            if (username != null && username.getPassword().equals(password)) {
//
//                LOGGER.log(Level.INFO, "Usuario Validado");
//                return true;
//            } else {
//                LOGGER.log(Level.INFO, "Contrasena Invalida o Usuario Inexistente");
//                return false;
//            }
//        } catch (Exception e) {
//            LOGGER.log(Level.SEVERE, "Error Validar ", e);
//            return false;
//        } finally {
//            em.close();
//            emf.close();
//        }
//    }
    @Override
    public Long validateUser(String user, String password) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("connectionPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<UserEntity> consultUser = em.createQuery("SELECT u FROM UserEntity u WHERE u.user = :user", UserEntity.class);
        consultUser.setParameter("user", user);

        try {
            UserEntity userEntity = consultUser.getSingleResult();

            if (userEntity != null && userEntity.getPassword().equals(password)) {
                LOGGER.log(Level.INFO, "Usuario Validado");
                // Devuelve el ID del paciente asociado al usuario
                return userEntity.getPatient().getId();
            } else {
                LOGGER.log(Level.INFO, "Contrasena Invalida o Usuario Inexistente");
                return null;
            }
        } catch (NoResultException e) {
            LOGGER.log(Level.INFO, "El usuario no existe");
            return null;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al validar", e);
            return null;
        } finally {
            em.close();
            emf.close();
        }
    }

    public static LogIn getInstance() {
        return new LogIn() {
        };
    }
}
