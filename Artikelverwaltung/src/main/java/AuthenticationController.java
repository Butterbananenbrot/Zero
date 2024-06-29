


import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.application.NavigationHandler;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Named
@SessionScoped
public class AuthenticationController implements Serializable {
    private static final long serialVersionUID = 1L;

    private String scientist;
    private String password;
    private String failureMessage;
    private boolean authenticated;

    private static final Map<String, Scientist> scientists = new HashMap<>();

    static {
        scientists.put("scientist1", new Scientist("scientist1", "password1"));
        scientists.put("scientist2", new Scientist("scientist2", "password2"));
    }

    public String getScientist() {
        return scientist;
    }

    public void setScientist(String scientist) {
        this.scientist = scientist;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public String login() {
        Scientist foundScientist = scientists.get(scientist);
        if (foundScientist != null && foundScientist.getPassword().equals(password)) {
            failureMessage = null;
            authenticated = true;
            return "admin.xhtml?faces-redirect=true";
        } else {
            failureMessage = "Invalid username or password.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Failed", "Invalid username or password."));
            return null;
        }
    }

    public void checkLogin() {
        if(!authenticated) { // add additional security logic here
            FacesContext fc = FacesContext.getCurrentInstance();
            NavigationHandler nh = fc.getApplication().getNavigationHandler();
            nh.handleNavigation(fc, null, "authentication.xhtml?faces-redirect=true");
        }
    }

    public String logout() {
        authenticated = false;
        return "authentication.xhtml?faces-redirect=true";
    }
}