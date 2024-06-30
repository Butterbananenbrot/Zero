import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.*;

import java.util.List;

@Named
@ApplicationScoped
public class CountryDAO {

//    @PersistenceContext(unitName = "ZeroPU")
//    private EntityManager em;

    private final static EntityManagerFactory emf
            = jakarta.persistence.Persistence.createEntityManagerFactory("ZeroPU");

    public void save(Country country) {
        EntityManager em = emf.createEntityManager();
        Country existingCountry = em.find(Country.class, country.getNr());
        EntityTransaction t = em.getTransaction();
        t.begin();
        if (existingCountry == null) {
            em.persist(country);
        } else {
            em.merge(country);
        }
        em.close();
    }

    public List<Country> findAll() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT c FROM Country c");
        List<Country> countries = q.getResultList();
        em.close();
        return countries;
    }
}
