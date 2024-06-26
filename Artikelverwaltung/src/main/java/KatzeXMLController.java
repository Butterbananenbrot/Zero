import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.ServletContext;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.annotation.PostConstruct;
import java.io.File;
import java.util.Collections;
import java.util.List;

@Named
@ApplicationScoped
public class KatzeXMLController {
    private List<Katze> katzen;

    @PostConstruct
    public void init() {
        // Using FacesContext to retrieve ServletContext
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String realPath = servletContext.getRealPath("/WEB-INF/cats.xml");  // Get the real path from ServletContext
        this.katzen = loadCatsFromXML(realPath);
    }

    private List<Katze> loadCatsFromXML(String filePath) {
        File xmlFile = new File(filePath);
        if (!xmlFile.exists()) {
            System.out.println("XML file not found at " + filePath);
            return Collections.emptyList();
        }

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Cats.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Cats cats = (Cats) jaxbUnmarshaller.unmarshal(xmlFile);
            if (cats.getKatzen() == null || cats.getKatzen().isEmpty()) {
                System.out.println("No cats loaded from XML.");
            } else {
                System.out.println(cats.getKatzen().size() + " cats loaded from XML.");
            }
            return cats.getKatzen();
        } catch (JAXBException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<Katze> getKatzen() {
        return katzen;
    }

    public void setKatzen(List<Katze> katzen) {
        this.katzen = katzen;
    }
}
