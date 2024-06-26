import jakarta.inject.Named;
import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@Named
public class Katze implements Serializable {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "age")
    private int alter;

    public Katze(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

    public Katze() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }
}
