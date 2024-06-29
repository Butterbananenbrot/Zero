import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
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

    private final String[][] users =
            new String[][]{
                    // password hash obtained with java LoginController koch i-am-the-boss
                    new String[]{"scientist",
                            "+INdDt2JaxoJLHzD4iAlWPYMJA0uJhusP37DvMHBKmen15EMj1Vn7BAxWS1TYFniKFKjuSyIEFbxy9jSx4d8Tw==",
                            "admin"},
                    // password hash obtained with java LoginController you you-are-the-client
                    new String[]{"you",
                            "dNw2o1ZcCW+Ge/n/yfYpMLbUZ9fbxqLXEuxTa6ilzXLgmr1imFH27T6q9ZNzlqBeAdKIHDf5SopFt0ttbDybEg==",
                            "client"}
            };

    static String hashPassword(String name, String pass, String salt) {
        try {
            MessageDigest digester = MessageDigest.getInstance("SHA-512");
            byte[] hashBytes = digester.digest((name + pass + salt)
                    .getBytes(StandardCharsets.UTF_8));
            return new String(Base64.getEncoder().encode(hashBytes));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void validateUsernameAndPassword(CurrentUser currentUser, String name, String pass, String salt) {
        String passHash = hashPassword(name, pass, salt);
        currentUser.reset();
        for (String[] user : users) {
            if (user[0].equals(name)) {
                if (user[1].equals(passHash)) {
                    if (user[2].equals("admin")) {
                        currentUser.admin = true;
                        return;
                    } else if (user[2].equals("client")) {
                        currentUser.client = true;
                        return;
                    } else throw new RuntimeException("Benutzer " + name + " ist falsch angelegt.");
                }
            }
        }
    }
}
