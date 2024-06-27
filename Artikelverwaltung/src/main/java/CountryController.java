import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CountryController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ZeroManager zeroManager;

    List<Country> countries;

    public List<Country> getCountries() {
        if (countries == null) {
            countries = zeroManager.getCountries();
        }
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

}
