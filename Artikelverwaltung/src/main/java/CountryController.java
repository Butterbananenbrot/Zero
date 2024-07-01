import jakarta.annotation.PostConstruct;
import jakarta.el.MethodExpression;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.event.RowEditEvent;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CountryController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ZeroManager zeroManager;

    List<Country> countries;
    private Country newCountry = new Country(); // temporary store for info when creating new country


    public List<Country> getCountries() {
        if (countries == null) {    // delete the internal logic here?
            countries = zeroManager.getCountries();
        }
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public void onRowEdit(RowEditEvent<Country> event) {
        Country editedCountry = event.getObject();
        zeroManager.getCountryDAO().edit(editedCountry);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Country Edited", editedCountry.getName()));
    }

    public String addCountry() {
        zeroManager.getCountryDAO().saveNewCountry(newCountry);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Country Added", newCountry.getName()));
        newCountry = new Country(); // reset the temp attribute
        return "admin.xhtml?faces-redirect=true"; // Redirect to the same page to refresh the list
    }

    public String deleteCountry(Country country) {
        try {
            zeroManager.getCountryDAO().delete(country); // Assume there's a method in DAO to handle deletion
            countries.remove(country); // Remove from the list to update UI
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Country deleted", null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error deleting country", null));
        }
        return "admin.xhtml?faces-redirect=true"; // Redirect to the same page to refresh the list
    }


    public Country getNewCountry() {
        return newCountry;
    }

    public void setNewCountry(Country newCountry) {
        this.newCountry = newCountry;
    }


}
