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

    public void edit(Country country) {
        EntityManager em = emf.createEntityManager();
        Country existingCountry = em.find(Country.class, country.getNr());
        EntityTransaction t = em.getTransaction();
        t.begin();
        if (existingCountry == null) {
            em.persist(country);
        } else {
            em.merge(country);
        }
        t.commit();
        em.close();
    }

    public List<Country> findAll() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT c FROM Country c");
        List<Country> countries = q.getResultList();
        em.close();
        return countries;
    }

    public void saveNewCountry(Country country) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        country.setNr(generateUniqueCountryNr(em));
        em.persist(country);
        t.commit();
        em.close();
    }

    /**
     * auxiliary method to generate unique country IDs
     * should be replaced by DB logic in a real-world application
     * @return the highest country ID + 1
     */
    private int generateUniqueCountryNr(EntityManager em) {
//        EntityManager em = emf.createEntityManager();
        Integer maxId = em.createQuery("SELECT MAX(c.nr) FROM Country c", Integer.class).getSingleResult();
//        em.close();
        return (maxId == null ? 1 : maxId + 1);
    }

    public void delete(Country country) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();

        System.out.println("Deleting country: " + country);

        // ensure the entity is managed - find it first based on its ID/Nr
        Country managedCountry = em.find(Country.class, country.getNr());
        if (managedCountry != null) {
            em.remove(managedCountry);
            System.out.println("Deleted country: " + managedCountry);
        } else {
            System.out.println("Country not found, cannot delete: " + country);
        }


        t.commit();
        System.out.println("committed transaction");
        em.close();
        System.out.println("closed entity manager");

    }

}
