import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.util.List;

@Named
@ApplicationScoped
public class ZeroManager {

    private final static EntityManagerFactory emf
            = jakarta.persistence.Persistence.createEntityManagerFactory("ZeroPU");

    public ZeroManager() {}

    public List<Country> getCountries() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT c FROM Country c");
        List<Country> countries = q.getResultList();
        return countries;
    }



}
