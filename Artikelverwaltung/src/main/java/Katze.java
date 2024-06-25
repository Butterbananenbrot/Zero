import jakarta.inject.Named;
import java.io.Serializable;

@Named
public class Katze implements Serializable {
    private String name;
    private int alter;

    public Katze(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

    public Katze() {
        this.name = "Toto";
        this.alter = 666;
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
