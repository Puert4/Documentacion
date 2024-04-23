package user.system;

import JPAEntities.UserEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author TeLesheo
 */
public class UserDAO implements IUserDAO {

    private UserDAO() {
    }

    @Override
    public void registerUser(UserEntity user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("connectionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static UserDAO getInstance() {
        return new UserDAO() {
        };
    }
}
