import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class ZeroManager {

    private CountryDAO countryDAO;

    public ZeroManager() {
        countryDAO = new CountryDAO();
    }

    public List<Country> getCountries() {
        return countryDAO.findAll();
    }

    public CountryDAO getCountryDAO() {
        return countryDAO;
    }

    public void setCountryDAO(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }
}
