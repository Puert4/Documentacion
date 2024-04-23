package patient.system;

import JPAEntities.PatientEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author TeLesheo
 */
public class PatientDAO implements IPatientDAO {

    private static final Logger LOGGER = Logger.getLogger(PatientDAO.class.getName());

    @Override
    public void registerPatient(PatientEntity patient) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("connectionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(patient);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

    @Override
    public PatientEntity serachPatientById(Long idPatient) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("connectionPU");
        EntityManager em = emf.createEntityManager();

        try {
            // Consulta el paciente por su ID
            return em.find(PatientEntity.class, idPatient);
        } catch (NoResultException e) {
            LOGGER.log(Level.INFO, "No se encontró ningún paciente con el ID especificado.");
            return null;
        } finally {
            em.close();
            emf.close();
        }
    }

    @Override
    public PatientEntity searchPatientByCurp(String curp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("connectionPU");
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<PatientEntity> query = em.createQuery("SELECT p FROM PatientEntity p WHERE p.curp = :curp", PatientEntity.class);
            query.setParameter("curp", curp);
            return query.getSingleResult();
        } catch (NoResultException e) {
            LOGGER.log(Level.INFO, "No se encontró ningún paciente con el CURP especificado.");
            return null;
        } finally {
            em.close();
            emf.close();
        }
    }

    public static PatientDAO getInstance() {
        return new PatientDAO() {
        };
    }

}
