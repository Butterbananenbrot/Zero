import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;
import java.util.List;

/**
 * This class acts as a wrapper for a list of Katze objects.
 * It is used to unmarshal XML data into a list of Katze objects.
 */
@XmlRootElement(name = "Cats")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cats {
    @XmlElement(name = "Cat")
    private List<Katze> katzen;

    public List<Katze> getKatzen() {
        return katzen;
    }

    public void setKatzen(List<Katze> katzen) {
        this.katzen = katzen;
    }
}
