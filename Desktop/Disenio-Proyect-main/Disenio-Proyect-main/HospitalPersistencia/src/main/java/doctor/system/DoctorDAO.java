package doctor.system;

import JPAEntities.DoctorEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author TeLesheo
 */
public class DoctorDAO implements IDoctorDAO {

    @Override
    public void registerDoctor(DoctorEntity doctor) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("connectionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(doctor);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
