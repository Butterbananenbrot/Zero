
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named("emissionBean")
@ApplicationScoped
public class EmissionBean implements Serializable {
    private List<CountryEmission> emissions;

    public EmissionBean() {
        emissions = Arrays.asList(
                new CountryEmission("Germany", 802.5),
                new CountryEmission("USA", 5000.3),
                new CountryEmission("China", 10356.7)
        );
    }

    public List<CountryEmission> getEmissions() {
        return emissions;
    }

    public void setEmissions(List<CountryEmission> emissions) {
        this.emissions = emissions;
    }
}
